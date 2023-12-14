package com.example.room.data.repositories;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.room.dao.WordDao;
import com.example.room.data.db.WordRoomDatabase;
import com.example.room.entities.Word;

import java.io.Serializable;
import java.util.List;

public class WordRepository implements Serializable {


    WordDao wordDao;

    LiveData<List<Word>> words;



    public WordRepository(Context context){
        WordRoomDatabase database=WordRoomDatabase.getWordRoomDataBase(context.getApplicationContext());
        wordDao=database.wordDao();
        words= wordDao.getAllWords();
    }

    public void insert(Word word){
        new insertAsyncTasck(wordDao).execute(word);
    }


    public LiveData<List<Word>> getAllWords(){
        return this.words;
    }


    private static  class insertAsyncTasck extends AsyncTask<Word,Void,Void>{
        WordDao wordDao;
        public insertAsyncTasck(WordDao wordDao){

            this.wordDao=wordDao;
        }
        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insertWord(words[0]);
           return null;

        }
    }
}
