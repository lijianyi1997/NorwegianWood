package com.example.norwegianwood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.githang.statusbar.StatusBarCompat;

import java.util.ArrayList;
import java.util.List;

public class MovieContentActivity extends AppCompatActivity {
    private List<ActorsUtils> actorsUtilsList = new ArrayList<>();
    private List<Actors> actors_list = new ArrayList<>();
    private TextView details;
    private TextView stills;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_content);
        StatusBarCompat.setStatusBarColor(this, Color.parseColor("#000000"), false);
        initialActorsUtils();
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewTest.this, android.R.layout.simple_list_item_1,data);
        ActorsUtilsAdapter adapter = new ActorsUtilsAdapter(MovieContentActivity.this, R.layout.actors_utils_listview_item, actorsUtilsList);
        ListView listView = (ListView) findViewById(R.id.actors_utils_list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ActorsUtils actorsUtils = actorsUtilsList.get(position);
                Intent intent = new Intent(MovieContentActivity.this, ActorsListActivity.class);
                startActivity(intent);
            }

        });
        details = (TextView)findViewById(R.id.txt_show_detail);
        stills = (TextView)findViewById(R.id.txt_more_stills);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://v.sogou.com/movie/mzuwy3k7gu2tgmbwbhc3ftp6wxcmtlob2y.html"));
                startActivity(intent);
            }
        });
        stills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieContentActivity.this, StillsListActivity.class);
                startActivity(intent);
            }
        });

        initialActorList();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.actors_horizon_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        ActorsHorizonAdapter actorsHorizonAdapter = new ActorsHorizonAdapter(actors_list);
        recyclerView.setAdapter(actorsHorizonAdapter);

    }
    public void initialActorsUtils(){
        actorsUtilsList.add(new ActorsUtils("演职人员","全部", R.drawable.actors_utils_icon));
        return;
    }
    public void initialActorList(){
        actors_list.add(new Actors("陈英雄","导演",R.drawable.director_img,"https://baike.baidu.com/item/%E9%99%88%E8%8B%B1%E9%9B%84/5074534"));
        actors_list.add(new Actors("松山健一","饰：渡边",R.drawable.dubian_img,"https://baike.baidu.com/item/%E6%9D%BE%E5%B1%B1%E5%81%A5%E4%B8%80/8067001"));
        actors_list.add(new Actors("菊地凛子 ","饰：直子",R.drawable.zhizi_img,"https://baike.baidu.com/item/%E8%8F%8A%E5%9C%B0%E5%87%9B%E5%AD%90/1879030"));
        actors_list.add(new Actors("水原希子","饰：绿子",R.drawable.lvzi_img,"https://baike.baidu.com/item/%E6%B0%B4%E5%8E%9F%E5%B8%8C%E5%AD%90/2797640"));
        actors_list.add(new Actors("高良健吾","饰：木月",R.drawable.muyue_img,"https://baike.baidu.com/item/%E9%AB%98%E8%89%AF%E5%81%A5%E5%90%BE/1132020"));
        actors_list.add(new Actors("玉山铁二 ","饰：永泽",R.drawable.yongze_img,"https://baike.baidu.com/item/%E7%8E%89%E5%B1%B1%E9%93%81%E4%BA%8C/7436239"));
        actors_list.add(new Actors("雾岛丽香","饰：玲子",R.drawable.lingzi_img,"https://baike.baidu.com/item/%E9%9B%BE%E5%B2%9B%E4%B8%BD%E9%A6%99/4706555"));
        actors_list.add(new Actors("初音映莉子 ","饰：初美",R.drawable.chuyin_img,"https://baike.baidu.com/item/%E5%88%9D%E9%9F%B3%E6%98%A0%E8%8E%89%E5%AD%90/10726722"));



    }
}