package com.example.norwegianwood;

import android.app.Dialog;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;
import java.util.List;
import java.util.zip.Inflater;

public class StillAdapter extends RecyclerView.Adapter<StillAdapter.ViewHolder> {

    private List<Still> mStillList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView stillImg;
        private View stillView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            stillImg = (ImageView)itemView.findViewById(R.id.img_still_recycler);
            stillView = itemView;
        }
    }

    public StillAdapter(List<Still> stillList){
        mStillList = stillList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.still_recycler_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.stillView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Still still = mStillList.get(position);
                final Dialog dialog = new Dialog(view.getContext(), android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                ImageView imgView = getView(view, still.getImgId());
                dialog.setContentView(imgView);
                dialog.show();


//      点击图片消失
                imgView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });

        return viewHolder;
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
        Still still = mStillList.get(position);
        holder.stillImg.setImageResource(still.getImgId());


    }

    @Override
    public int getItemCount() {
        return mStillList.size();
    }




}
