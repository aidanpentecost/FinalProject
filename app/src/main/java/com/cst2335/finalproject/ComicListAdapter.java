package com.cst2335.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ComicListAdapter extends ArrayAdapter<ComicItem> {

    public ComicListAdapter(Context context, List<ComicItem> items) {
        super(context, 0, items);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
        }

        ComicItem currentComic = getItem(position);

        TextView idTextView = convertView.findViewById(R.id.textId);
        TextView nameTextView = convertView.findViewById(R.id.textName);
        TextView descriptionTextView = convertView.findViewById(R.id.textDescription);
        ImageView thumbnailImageView = convertView.findViewById(R.id.imageThumbnail);


        String secureUrl = currentComic.getThumbnailPath().replace("http://", "https://");

        if (currentComic != null) {
            idTextView.setText(currentComic.getId());
            nameTextView.setText(currentComic.getName());
            descriptionTextView.setText(currentComic.getDescription());

            String imageUrl = secureUrl + "." + currentComic.getThumbnailExtension();
            Picasso.get().load(imageUrl).into(thumbnailImageView);
        }

        return convertView;
    }
}
