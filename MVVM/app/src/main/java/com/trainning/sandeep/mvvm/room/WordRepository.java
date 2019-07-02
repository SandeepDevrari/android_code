package com.trainning.sandeep.mvvm.room;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {
    private WordDAO wordDAO;
    private LiveData<List<Word>>listLiveData;

    public WordRepository(Application application){
        WordRoomDB wordRoomDB=WordRoomDB.getDatabase(application);
        wordDAO=wordRoomDB.wordDao();
        listLiveData=wordDAO.getAllWords();
    }

    public LiveData<List<Word>>getAllWords(){
        return listLiveData;
    }

    public void insert(Word word){
        new InsertAsyncTask(wordDAO).execute(word);
    }

    private static class InsertAsyncTask extends AsyncTask<Word,Void,Void>{
        private WordDAO wordDAO;

        InsertAsyncTask(WordDAO wordDAO) {
            this.wordDAO=wordDAO;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDAO.insert(words[0]);
            return null;
        }
    }
}
