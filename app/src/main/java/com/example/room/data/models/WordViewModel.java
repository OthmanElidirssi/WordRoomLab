package com.example.room.data.models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.room.data.repositories.WordRepository;
import com.example.room.entities.Word;

import java.util.List;

public class WordViewModel extends AndroidViewModel {



    private WordRepository wordRepository;
    private LiveData<List<Word>> words;




    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository=new WordRepository(application.getApplicationContext());
        words= wordRepository.getAllWords();
    }


    public void insert(Word word){
        wordRepository.insert(word);
    }

    public LiveData<List<Word>> getAllWords(){
        return this.words;
    }

    public WordRepository getWordRepository(){
        return this.wordRepository;
    }


}
