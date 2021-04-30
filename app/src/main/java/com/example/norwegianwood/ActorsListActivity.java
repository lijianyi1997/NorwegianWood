package com.example.norwegianwood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

import com.githang.statusbar.StatusBarCompat;

import java.util.ArrayList;
import java.util.List;

public class ActorsListActivity extends AppCompatActivity {
    private List<Actors> actors_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors_list);
        StatusBarCompat.setStatusBarColor(this, Color.parseColor("#000000"), false);
        initialActorList();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.actors_vertical_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ActorsVerticalAdapter actorsVerticalAdapter = new ActorsVerticalAdapter(actors_list);
        recyclerView.setAdapter(actorsVerticalAdapter);
    }
    public void initialActorList(){
        actors_list.add(new Actors("陈英雄","导演",R.drawable.director_img,"https://baike.baidu.com/item/%E9%99%88%E8%8B%B1%E9%9B%84/5074534","Anh Hung Tran"));
        actors_list.add(new Actors("松山健一","饰：渡边",R.drawable.dubian_img,"https://baike.baidu.com/item/%E6%9D%BE%E5%B1%B1%E5%81%A5%E4%B8%80/8067001","松山ケンイチ"));
        actors_list.add(new Actors("菊地凛子 ","饰：直子",R.drawable.zhizi_img,"https://baike.baidu.com/item/%E8%8F%8A%E5%9C%B0%E5%87%9B%E5%AD%90/1879030","Rinko Kikuchi"));
        actors_list.add(new Actors("水原希子","饰：绿子",R.drawable.lvzi_img,"https://baike.baidu.com/item/%E6%B0%B4%E5%8E%9F%E5%B8%8C%E5%AD%90/2797640","Mizuhara Kiko"));
        actors_list.add(new Actors("高良健吾","饰：木月",R.drawable.muyue_img,"https://baike.baidu.com/item/%E9%AB%98%E8%89%AF%E5%81%A5%E5%90%BE/1132020","Kora Kengo"));
        actors_list.add(new Actors("玉山铁二 ","饰：永泽",R.drawable.yongze_img,"https://baike.baidu.com/item/%E7%8E%89%E5%B1%B1%E9%93%81%E4%BA%8C/7436239","Tamayama Tetsuji"));
        actors_list.add(new Actors("雾岛丽香","饰：玲子",R.drawable.lingzi_img,"https://baike.baidu.com/item/%E9%9B%BE%E5%B2%9B%E4%B8%BD%E9%A6%99/4706555","雾岛 れいか"));
        actors_list.add(new Actors("初音映莉子 ","饰：初美",R.drawable.chuyin_img,"https://baike.baidu.com/item/%E5%88%9D%E9%9F%B3%E6%98%A0%E8%8E%89%E5%AD%90/10726722","Hatsune Eriko"));
        actors_list.add(new Actors("柄本时生 ","饰：敢死队",R.drawable.gansi_img,"https://baike.baidu.com/item/%E6%9F%84%E6%9C%AC%E6%97%B6%E7%94%9F/5558090","Tokio Emoto"));
        actors_list.add(new Actors("糸井重里 ","饰：大学教授",R.drawable.jiaoshou_img,"https://baike.baidu.com/item/%E7%B3%B8%E4%BA%95%E9%87%8D%E9%87%8C/1249531",""));
        actors_list.add(new Actors("高桥幸宏  ","饰：宿舍看门人",R.drawable.sushe_img,"https://baike.baidu.com/item/%E9%AB%98%E6%A1%A5%E5%B9%B8%E5%AE%8F/8945476","Yukihiro Takahashi"));




    }

}