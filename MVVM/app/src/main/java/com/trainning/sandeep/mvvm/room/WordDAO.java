package com.trainning.sandeep.mvvm.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.trainning.sandeep.mvvm.room.Word;

import java.util.List;

@Dao
public interface WordDAO {
    @Insert
    void insert(Word word);

    @Query("DELETE from world_table")
    void deleteAll();

    @Query("SELECT * from world_table ORDER BY word ASC")
    LiveData<List<Word>>getAllWords();
}
