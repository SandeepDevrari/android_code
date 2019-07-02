package com.trainning.sandeep.mvvm.view;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.trainning.sandeep.mvvm.room.Word;
import com.trainning.sandeep.mvvm.room.WordRepository;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository wordRepository;
    private LiveData<List<Word>>listLiveData;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository=new WordRepository(application);
        listLiveData=wordRepository.getAllWords();
    }

    public LiveData<List<Word>> getListLiveData() {
        return listLiveData;
    }

    public void insert(Word word){
        wordRepository.insert(word);
    }
}
