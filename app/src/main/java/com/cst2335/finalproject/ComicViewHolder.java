package com.cst2335.finalproject;

import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.WindowDecorActionBar;
import androidx.recyclerview.widget.RecyclerView;

public class ComicViewHolder extends RecyclerView.ViewHolder {
    public WindowDecorActionBar.TabImpl titleTextView;
    public ImageView imageView;

    public ComicViewHolder(View itemView) {
        super(itemView);
    }
}
