package com.cst2335.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ComicListAdapter extends ArrayAdapter<ComicItem> {

    public ComicListAdapter(Context context, List<ComicItem> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ComicItem item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
        }

        TextView idTextView = convertView.findViewById(R.id.textId);
        TextView nameTextView = convertView.findViewById(R.id.textName);
        TextView descriptionTextView = convertView.findViewById(R.id.textDescription);

        idTextView.setText(item.getId());
        nameTextView.setText(item.getName());
        descriptionTextView.setText(item.getDescription());

        return convertView;
    }
}
