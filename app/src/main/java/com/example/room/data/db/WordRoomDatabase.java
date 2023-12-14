package com.example.room.data.db;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.room.dao.WordDao;
import com.example.room.entities.Word;

@Database(entities = {Word.class},version = 1)
public  abstract  class WordRoomDatabase extends RoomDatabase{



    public abstract WordDao wordDao();

    public static WordRoomDatabase instance;


    public static synchronized WordRoomDatabase getWordRoomDataBase(Context context){
        if(instance==null){

            instance= Room.databaseBuilder(context.getApplicationContext(),WordRoomDatabase.class,"word_database")
                         .fallbackToDestructiveMigration()
                         .addCallback(callback)
                         .build();
        }
        return instance;
    }


    private static RoomDatabase.Callback callback=new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new insertAsyncTask(instance).execute();


        }
    };


    private static class insertAsyncTask extends AsyncTask<Void,Void,Void>{


        WordDao wordDao;


        public  insertAsyncTask(WordRoomDatabase db){
            this.wordDao=db.wordDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.insertWord(new Word("2ITE"));
            return null;
        }
    }

}

