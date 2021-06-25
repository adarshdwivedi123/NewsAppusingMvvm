package com.example.newsappusingmvvm.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.newsappusingmvvm.R;

public class DetailNews extends AppCompatActivity {
    TextView tvDesc;
    ImageView imageView;
    ProgressBar loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        tvDesc=findViewById(R.id.tvDescrption);
        imageView=findViewById(R.id.imgViewCover);
        Intent intent=getIntent();
        String desc=intent.getStringExtra("description");
        String urlToImage=intent.getStringExtra("urlToImage");
        tvDesc.setText(desc);

        Glide.with(DetailNews.this)
                .load(urlToImage)
                .into(imageView);


    }
}