package com.example.norwegianwood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ActorsUtilsAdapter extends ArrayAdapter<ActorsUtils> {
    private int resourceId;

    public ActorsUtilsAdapter(@NonNull Context context, int textViewResourceId, @NonNull List<ActorsUtils> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ActorsUtils actorsUtils = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView img = (ImageView) view.findViewById(R.id.img_actor_utils_listview);
        TextView txtLeft = (TextView)view.findViewById(R.id.txt_left_actor_utils_listview);
        TextView txtRight = (TextView)view.findViewById(R.id.txt_right_actor_utils_listview);
        img.setImageResource(actorsUtils.getImageId());
        txtLeft.setText(actorsUtils.getTxtLeft());
        txtRight.setText(actorsUtils.getTxtRight());
        return view;
    }
}
