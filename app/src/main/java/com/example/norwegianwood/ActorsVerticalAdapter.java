package com.example.norwegianwood;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;
import java.util.List;

public class ActorsVerticalAdapter extends RecyclerView.Adapter<ActorsVerticalAdapter.ViewHolder> {
    private List<Actors> mActorsList;
    public ActorsVerticalAdapter(List<Actors> actorsList){
        mActorsList = actorsList;
    }
    @NonNull
    @Override
    public ActorsVerticalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.actors_vertical_item, parent, false);
        ActorsVerticalAdapter.ViewHolder holder = new ActorsVerticalAdapter.ViewHolder(view);
        holder.actorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Actors actor = mActorsList.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(actor.getUriDir()));
                view.getContext().startActivity(intent);
            }
        });
        // 设置点击图片放大
        holder.actorImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Actors actor = mActorsList.get(position);
                final Dialog dialog = new Dialog(view.getContext(), android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                ImageView imgView = getView(view, actor.getImgId());
                dialog.setContentView(imgView);
                dialog.show();

                // 点击图片消失
                imgView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
        return holder;

    }

    private ImageView getView(View view, int imageId) {
        ImageView imgView = new ImageView(view.getContext());
        imgView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        InputStream is = view.getContext().getResources().openRawResource(imageId);
        Drawable drawable = BitmapDrawable.createFromStream(is, null);
        imgView.setImageDrawable(drawable);
        return imgView;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Actors actor = mActorsList.get(position);
        holder.actorImage.setImageResource(actor.getImgId());
        holder.actorName.setText(actor.getName());
        holder.actorRole.setText(actor.getRole());
        holder.actorJname.setText(actor.getJname());

    }



    @Override
    public int getItemCount() {
        return mActorsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView actorImage;
        TextView actorName;
        TextView actorRole;
        TextView actorJname;
        View actorView;
        public ViewHolder(View view){
            super(view);
            actorView = view;
            actorImage = view.findViewById(R.id.img_actor_vertical);
            actorName = view.findViewById(R.id.txt_actor_name_vertical);
            actorRole = view.findViewById(R.id.txt_actor_role_vertical);
            actorJname = view.findViewById(R.id.txt_actor_jname_vertical);
        }
    }

}
