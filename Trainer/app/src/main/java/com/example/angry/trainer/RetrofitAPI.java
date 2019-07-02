package com.example.angry.trainer;

import com.example.angry.trainer.model.RetrofitPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Angry on 6/25/2018.
 */

public interface RetrofitAPI {
@GET("/photos")
    Call<List<RetrofitPhoto>>getAllPhotos();
}
