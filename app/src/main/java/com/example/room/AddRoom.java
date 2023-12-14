package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddRoom extends AppCompatActivity {


    EditText word_input;
    Button addWord;

    static final String WORD_KEY="word";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);
        addWord=findViewById(R.id.buttonAddWord);
        word_input=findViewById(R.id.editTextWord);

        addWord.setOnClickListener(view -> {

            String word= String.valueOf(word_input.getText());
            Intent data=new Intent();
            data.putExtra(WORD_KEY,word);
            setResult(RESULT_OK,data);
            AddRoom.this.finish();


        });
    }
}