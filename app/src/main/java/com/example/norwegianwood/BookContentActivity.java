package com.example.norwegianwood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Color;
import android.os.Bundle;

import com.githang.statusbar.StatusBarCompat;

import java.util.ArrayList;
import java.util.List;

public class BookContentActivity extends AppCompatActivity {
    private List<Content> content_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_content);
        StatusBarCompat.setStatusBarColor(this, Color.parseColor("#000000"), false);

        initContentList();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.content_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);
        ContentAdapter adapter = new ContentAdapter(content_list);
        recyclerView.setAdapter(adapter);
    }

    private void initContentList(){
        String book_content1 = "\u3000"+"《挪威的森林》是日本作家村上春树的长篇小说。讲述了“我”与死去好友木月的" +
                "女友直子和“我”大学同学绿子之间发生的爱情故事。" ;
        String book_content2 =
                "\u3000"+"木月和直子从小青梅竹马，两小无猜，一直在一起玩耍，上学，到情窦初开的年纪，俩人自然而然成" +
                        "了男女朋友关系。小说中的“我”即渡边，是木月的好朋友，因此和木月、直子经常一起玩耍。"+
                "木月在17岁自杀身亡后，给渡边和直子心里留下深深的怀念和阴影。他们不约而同有意识离开神户去东京上大学，" +
                        "只为在一个完全陌生的环境里重新开始生活。";
        String book_content3 = "\u3000"+"一次在电车上，渡边和直子偶然邂逅，俩人从此开始约会。直子20岁生日那天，俩" +
                "人发生了关系。但很快，直子因为精神疾病不得不休学，去深山里的疗养院治疗。"
                +"渡边经常去疗养院看望直子，回到学校就给直子写信。他希望直子尽快恢复健康，和他一起共同度过未来生活。";
        String book_content4 = "\u3000"+"在这个过程中，绿子出现在渡边身边。她的性格和直子完全相反。直子典雅娴静，美丽端庄，澄澈纯洁，" +
                "而绿子外向热情，活泼可爱，坦率直接。" +
                "渡边一方面爱上了绿子，一方面留恋着直子，对直子更有着深深的责任感。这让他“心乱如麻，不知所措”。陷入难以选择" +
                "的痛苦境地，十分纠结。" ;
        String book_content5 =
                "\u3000"+"当直子选择自杀后，渡边在悲痛无奈中四处游走，消极颓废，经常会独自哭泣流泪。直子生前的音容笑貌，一举一动，" +
                "无不在他脑海中闪现回放。" + "结束了流浪生活后，渡边选择了绿子。";
        String book_content6 = "\u3000"+"小说以回忆的方式开始了故事的讲述。37岁的“我”在德国飞机场听到了甲壳虫乐队演奏的《挪威的森林》，" +
                "想起了18年前的往事。那时直子也喜欢听《挪威的森林》。" ;
        String book_content7 =
                "\u3000"+"小说整体以线状结构为主，中间又点缀了不少画面结构，这些画面有的包含与主人公命运有关的意象，但大多数以比喻为主，" +
                        "有的画面比较细致，有的画面比较简约，这使得小说看起来像水晶珠帘一般美丽剔透。";
        content_list.add(new Content(book_content1));
        content_list.add(new Content(book_content2));
        content_list.add(new Content(book_content3));
        content_list.add(new Content(book_content4));
        content_list.add(new Content(book_content5));
        content_list.add(new Content(book_content6));
        content_list.add(new Content(book_content7));



        return;
    }
}