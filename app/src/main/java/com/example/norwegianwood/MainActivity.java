package com.example.norwegianwood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.githang.statusbar.StatusBarCompat;

import me.jessyan.autosize.AutoSize;
import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.internal.CustomAdapt;

public class MainActivity extends AppCompatActivity implements CustomAdapt {
    private TextView txtAuthor, txtComment, txtMovie, txtIntro;
    private final String[] items = new String[]{"拨打客服电话", "取消"};//创建item
    private final String[] items_comment = new String[]{"豆瓣书评", "视频讲书"};//创建item
    private int index;



//    AutoSizeConfig.getInstance().setBaseOnWidth(false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarCompat.setStatusBarColor(this, Color.parseColor("#000000"), false);

        DisplayMetrics dm = getResources().getDisplayMetrics();
//手机宽度dp值 = 手机实际宽度像素px / 手机屏幕密度比
        float widthDP = dm.widthPixels / dm.density;
        Log.d("MainActivity", "屏幕宽度dp是: "+widthDP);
        Log.d("MainActivity", "手机实际宽度像素dp是: "+dm.widthPixels);
        Log.d("MainActivity", "屏幕密度比是: "+dm.density);
        Log.d("MainActivity", "屏幕密度是: "+dm.densityDpi);



        txtAuthor = (TextView)findViewById(R.id.txt_author_main);
        txtComment = (TextView)findViewById(R.id.txt_comment_main);
        txtMovie = (TextView)findViewById(R.id.txt_movie_main);
        txtIntro = (TextView)findViewById(R.id.txt_intro_main);

        txtAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://baike.sogou.com/v231520.htm?fromTitle=%E6%9D%91%E4%B8%8A%E6%98%A5%E6%A0%91"));
                startActivity(intent);
            }
        });
        txtMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MovieContentActivity.class);
                startActivity(intent);

            }
        });
        txtIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BookContentActivity.class);
                startActivity(intent);
            }
        });

        txtComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alertDialog_comment = new AlertDialog.Builder(new ContextThemeWrapper(v.getContext(), R.style.AlertDialogCustom))
                        .setTitle("打开")
                        .setIcon(R.mipmap.open_comment_img)
                        .setSingleChoiceItems(items_comment, 0, new DialogInterface.OnClickListener() {//添加单选框
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                index = i;
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                switch (index){
                                    case 0:
                                        Intent intent_douban = new Intent(Intent.ACTION_VIEW);
                                        intent_douban.setData(Uri.parse("https://book.douban.com/subject/1046265/reviews"));
                                        startActivity(intent_douban);
                                        dialogInterface.cancel();
                                        break;
                                    case 1:
                                        Intent intent_bili = new Intent(Intent.ACTION_VIEW);
                                        intent_bili.setData(Uri.parse("https://www.bilibili.com/video/BV1LT4y157yH/?spm_id_from=333.788.recommend_more_video.0"));
                                        startActivity(intent_bili);
                                        dialogInterface.cancel();
                                        break;

                                }

                            }
                        })

                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {//添加取消
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();

                            }
                        })
                        .create();
                alertDialog_comment.show();
                Button pos_button = (Button) alertDialog_comment.getButton(AlertDialog.BUTTON_POSITIVE);
//                LinearLayout.LayoutParams posBtnPara = (LinearLayout.LayoutParams) pos_button.getLayoutParams();
//                posBtnPara.height = LinearLayout.LayoutParams.WRAP_CONTENT;
//                posBtnPara.width = LinearLayout.LayoutParams.WRAP_CONTENT;
//                pos_button.setLayoutParams(posBtnPara);
                pos_button.setBackground(ContextCompat.getDrawable(v.getContext(),R.color.transparent));
                pos_button.setTextColor(ContextCompat.getColor(v.getContext(),R.color.white));
                Button neg_button = (Button) alertDialog_comment.getButton(AlertDialog.BUTTON_NEGATIVE);
                neg_button.setBackground(ContextCompat.getDrawable(v.getContext(),R.color.transparent));
                neg_button.setTextColor(ContextCompat.getColor(v.getContext(),R.color.white));

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.contact_item:
                // 弹出对话框
                AlertDialog alertDialog_cotent = new AlertDialog.Builder(this)
                        .setTitle("联系我们")
                        .setIcon(R.mipmap.phone_img)
                        .setItems(items, new DialogInterface.OnClickListener() {//添加列表
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                switch (i){
                                    case 0:
                                        Intent intent = new Intent(Intent.ACTION_DIAL);
                                        intent.setData(Uri.parse("tel:18632089013"));
                                        startActivity(intent);
                                        dialogInterface.cancel();
                                        break;

                                    case 1:
                                        dialogInterface.cancel();
                                        break;
                                }
                            }
                        })
                        .create();
                alertDialog_cotent.show();
                break;

            default:
                break;
        }
        return true;
    }

    private static boolean isExit = false;

    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }


    @Override
    public boolean isBaseOnWidth() {
        return true;
    }

    @Override
    public float getSizeInDp() {
        return 0;
    }
}