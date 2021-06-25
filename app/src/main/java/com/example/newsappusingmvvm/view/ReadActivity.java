package com.example.newsappusingmvvm.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.newsappusingmvvm.R;
import com.example.newsappusingmvvm.modal.Article;

public class ReadActivity extends AppCompatActivity {
    private Article article;
    private TextView descriptionView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        article=getIntent().getParcelableExtra("article");
        imageView= findViewById(R.id.image_view3);
        descriptionView=findViewById(R.id.description);
        Glide.with(this)
                .load(article.getUrlToImage())
                .apply(RequestOptions.centerCropTransform())
                .into(imageView);
        String content= article.getDescription() +"\n \n"+ article.getTitle() +"\n \n"+ article.getContent();
        descriptionView.setText(content);
    }
}