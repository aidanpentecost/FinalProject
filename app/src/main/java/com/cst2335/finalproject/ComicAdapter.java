package com.cst2335.finalproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ComicAdapter extends RecyclerView.Adapter {

    private int itemId;
    private int itemCount;
    private int itemViewType;
    private List<Comic> comicList;
    private OnItemClickListener listener;
    private Context context;


    public ComicAdapter(List<Comic> comicList, OnItemClickListener listener) {
        this.comicList = comicList;
        this.listener = listener;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    @NonNull
    @Override
    public ComicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_comic, parent, false);

        return new ComicViewHolder(itemView);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onBindViewHolder(@NonNull ComicViewHolder holder, int position) {
        Comic comic = comicList.get(position);
        holder.titleTextView.setText(comic.getTitle());
        Glide.with(context).load(comic.getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    public interface OnItemClickListener {

        void onItemClick(int position);
    }
}
