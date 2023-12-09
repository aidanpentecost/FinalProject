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

    /**
     * @param context
     * @param items
     */
    public ComicListAdapter(Context context, List<ComicItem> items) {
        super(context, 0, items);
    }

    /**
     * @param position The position of the item within the adapter's data set of the item whose view
     *        we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *        is non-null and of an appropriate type before using. If it is not possible to convert
     *        this view to display the correct data, this method can create a new view.
     *        Heterogeneous lists can specify their number of view types, so that this View is
     *        always of the right type (see {@link #getViewTypeCount()} and
     *        {@link #getItemViewType(int)}).
     * @param parent The parent that this view will eventually be attached to
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item_layout, parent, false);
        }

        ComicItem currentComic = getItem(position);

        TextView idTextView = convertView.findViewById(R.id.textId);
        TextView nameTextView = convertView.findViewById(R.id.textName);
        TextView descriptionTextView = convertView.findViewById(R.id.textDescription);
        ImageView thumbnailImageView = convertView.findViewById(R.id.imageThumbnail);

        //change HTTP request to HTTPS for security
        String secureUrl = currentComic.getThumbnailPath()
                .replace("http://", "https://");

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
