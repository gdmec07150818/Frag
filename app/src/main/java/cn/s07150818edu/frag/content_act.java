package cn.s07150818edu.frag;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/8/17.
 */

public class content_act extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_layout);

        String news_title = getIntent().getStringExtra("news_title");
        String news_content = getIntent().getStringExtra("news_content");
        content_frag content_frag= (cn.s07150818edu.frag.content_frag) getSupportFragmentManager().findFragmentById(R.id.content_fra);
        content_frag.refresh(news_title,news_content);

    }


    public static void actionStart(Context context,String title,String content){
        Intent intent = new Intent(context, content_act.class);
        intent.putExtra("news_title",title);
        intent.putExtra("news_content",content);
        context.startActivity(intent);

    }
}
