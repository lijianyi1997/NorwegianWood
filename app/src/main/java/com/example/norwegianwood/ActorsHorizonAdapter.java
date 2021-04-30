package com.example.norwegianwood;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;
import static java.security.AccessController.getContext;

public class ActorsHorizonAdapter extends RecyclerView.Adapter<ActorsHorizonAdapter.ViewHolder> {
    private List<Actors> mActorsList;
    public ActorsHorizonAdapter(List<Actors> actorsList){
        mActorsList = actorsList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.actors_horizon_item, parent, false);
        ActorsHorizonAdapter.ViewHolder holder = new ActorsHorizonAdapter.ViewHolder(view);
        holder.actorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(mActorsList.get(position).getUriDir()));
                view.getContext().startActivity(intent);
            }
        });
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Actors actor = mActorsList.get(position);
        holder.actorRole.setText(actor.getRole());
        holder.actorName.setText(actor.getName());
        holder.actorImage.setImageResource(actor.getImgId());

    }

    @Override
    public int getItemCount() {
        return mActorsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView actorImage;
        TextView actorName;
        TextView actorRole;
        View actorView;
        public ViewHolder(View view){
            super(view);
            actorView = view;
            actorImage = view.findViewById(R.id.img_actor_horizon);
            actorName = view.findViewById(R.id.txt_actor_name_horizon);
            actorRole = view.findViewById(R.id.txt_actor_role_horizon);
        }
    }


}
