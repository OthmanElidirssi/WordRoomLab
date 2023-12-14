package com.example.room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.room.entities.Word;

import java.util.ArrayList;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomHolder> {

    private List<Word> words=new ArrayList<>();
    private int layout;
    private Context context;
    private LayoutInflater inflater;

    public RoomAdapter(Context context,int layout){
        this.context=context;
        this.layout=layout;
        this.inflater=LayoutInflater.from(this.context);
    }


    @NonNull
    @Override
    public RoomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View room_item=inflater.inflate(this.layout,parent,false);
        return new RoomHolder(room_item);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomHolder holder, int position) {

        Word word=this.words.get(position);
        holder.populate(word);
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public void setWords(List<Word> words){
        this.words=words;
        notifyDataSetChanged();
    }
}
