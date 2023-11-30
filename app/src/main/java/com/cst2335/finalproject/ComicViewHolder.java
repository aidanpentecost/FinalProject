package com.cst2335.finalproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.WindowDecorActionBar;
import androidx.recyclerview.widget.RecyclerView;

public class ComicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView titleTextView;
    public ImageView imageView;

    public ComicViewHolder(View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.titleTextView);
        imageView = itemView.findViewById(R.id.imageView);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //send to MainActivity listener
        if (listener != null){
            listener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}
