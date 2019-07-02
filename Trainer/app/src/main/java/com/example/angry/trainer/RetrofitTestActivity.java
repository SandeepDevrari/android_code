package com.example.angry.trainer;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.angry.trainer.model.RetrofitPhoto;
import com.example.angry.trainer.network.RetrofitInstanceClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitTestActivity extends AppCompatActivity {

    private CustomAdapter customAdapter;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_test);
        init();
    }

    private void init() {
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loding...");
        progressDialog.show();

        RetrofitAPI retrofitAPI= RetrofitInstanceClass.getRetrofitInstance().create(RetrofitAPI.class);
        Call<List<RetrofitPhoto>>call=retrofitAPI.getAllPhotos();
        call.enqueue(new Callback<List<RetrofitPhoto>>() {
            @Override
            public void onResponse(Call<List<RetrofitPhoto>> call, Response<List<RetrofitPhoto>> response) {
                progressDialog.dismiss();
                List<RetrofitPhoto>list=response.body();
                customAdapter=new CustomAdapter(RetrofitTestActivity.this,list);
                recyclerView.setAdapter(customAdapter);
            }

            @Override
            public void onFailure(Call<List<RetrofitPhoto>> call, Throwable t) {

            }
        });
        recyclerView=findViewById(R.id.retrofitRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}
