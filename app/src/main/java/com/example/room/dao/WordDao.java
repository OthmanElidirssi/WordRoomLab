package com.example.room.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.room.entities.Word;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    public void insertWord(Word word);

    @Query("SELECT * FROM Word")
    LiveData<List<Word>> getAllWords();


}
