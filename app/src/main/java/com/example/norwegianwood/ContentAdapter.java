package com.example.norwegianwood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {
    private List<Content> contentList;

    public ContentAdapter(List<Content> contentList){
        this.contentList = contentList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView bookContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookContent = (TextView)itemView.findViewById(R.id.txt_content_item);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Content content = contentList.get(position);
        holder.bookContent.setText(content.getText());

    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }



}
