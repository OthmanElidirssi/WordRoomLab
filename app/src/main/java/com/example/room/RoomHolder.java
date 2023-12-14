package com.example.room;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.room.entities.Word;

import org.w3c.dom.Text;

public class RoomHolder extends RecyclerView.ViewHolder {


    private TextView textView;

    public RoomHolder(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.text_view_word);
    }

    public void populate(Word word){
        this.textView.setText(word.getNom());
    }
}
