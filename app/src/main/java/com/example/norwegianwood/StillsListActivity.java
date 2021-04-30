package com.example.norwegianwood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Color;
import android.os.Bundle;

import com.githang.statusbar.StatusBarCompat;

import java.util.ArrayList;
import java.util.List;

public class StillsListActivity extends AppCompatActivity {
    private List<Still> still_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stills_list);
        StatusBarCompat.setStatusBarColor(this, Color.parseColor("#000000"), false);

        initialStillsRecycler();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.still_recycle_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        StillAdapter adapter = new StillAdapter(still_list);
        recyclerView.setAdapter(adapter);
    }

    private void initialStillsRecycler(){
        still_list.add(new Still(R.drawable.still1));
        still_list.add(new Still(R.drawable.still2));
        still_list.add(new Still(R.drawable.still3));
        still_list.add(new Still(R.drawable.still4));
        still_list.add(new Still(R.drawable.still5));
        still_list.add(new Still(R.drawable.still6));
        still_list.add(new Still(R.drawable.still7));
        still_list.add(new Still(R.drawable.still8));
        still_list.add(new Still(R.drawable.still9));
        still_list.add(new Still(R.drawable.still10));
        still_list.add(new Still(R.drawable.still11));
        still_list.add(new Still(R.drawable.still12));
        still_list.add(new Still(R.drawable.still13));
        still_list.add(new Still(R.drawable.still14));
        still_list.add(new Still(R.drawable.still15));
        still_list.add(new Still(R.drawable.still16));
        still_list.add(new Still(R.drawable.still17));
        still_list.add(new Still(R.drawable.still18));
        still_list.add(new Still(R.drawable.still19));
        still_list.add(new Still(R.drawable.still20));
        still_list.add(new Still(R.drawable.still21));
        still_list.add(new Still(R.drawable.still22));
        still_list.add(new Still(R.drawable.still23));
        still_list.add(new Still(R.drawable.still24));
        still_list.add(new Still(R.drawable.still25));
        still_list.add(new Still(R.drawable.still26));
        still_list.add(new Still(R.drawable.still27));
        still_list.add(new Still(R.drawable.still28));
        still_list.add(new Still(R.drawable.still29));
        still_list.add(new Still(R.drawable.still30));
        still_list.add(new Still(R.drawable.still31));
        still_list.add(new Still(R.drawable.still32));
        still_list.add(new Still(R.drawable.still33));
        still_list.add(new Still(R.drawable.still34));
        still_list.add(new Still(R.drawable.still35));
        still_list.add(new Still(R.drawable.still36));
        still_list.add(new Still(R.drawable.still37));
        still_list.add(new Still(R.drawable.still38));
        still_list.add(new Still(R.drawable.still39));
        still_list.add(new Still(R.drawable.still40));
        still_list.add(new Still(R.drawable.still41));
        still_list.add(new Still(R.drawable.still42));
        still_list.add(new Still(R.drawable.still43));
        still_list.add(new Still(R.drawable.still44));
        still_list.add(new Still(R.drawable.still45));
        still_list.add(new Still(R.drawable.still46));



    }
}