package com.example.room;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.room.data.models.WordViewModel;
import com.example.room.entities.Word;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    WordViewModel wordViewModel;

    RecyclerView recyclerView;

    RoomAdapter adapter;
    FloatingActionButton actionButton;


    static  final int ADD_WORD_REQUEST=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_rooms);
        recyclerView=findViewById(R.id.recycler_view_rooms);
        actionButton=findViewById(R.id.floatingActionButton);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new RoomAdapter(this,R.layout.room_item);
        recyclerView.setAdapter(adapter);

        wordViewModel= new ViewModelProvider(this).get(WordViewModel.class);

        wordViewModel.getAllWords().observe(this, words ->
                adapter.setWords(words)
        );

        actionButton.setOnClickListener(view -> new Thread(() -> {
            Intent intent = new Intent(MainActivity.this, AddRoom.class);
            MainActivity.this.startActivityForResult(intent,ADD_WORD_REQUEST);
        }).start());
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ADD_WORD_REQUEST&& resultCode==RESULT_OK){

            String word_nom=data.getStringExtra(AddRoom.WORD_KEY);

            Word word=new Word(word_nom);
            wordViewModel.insert(word);
            Toast.makeText(this, "Word inserted Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}