package com.example.newsappusingmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.newsappusingmvvm.R;
import com.example.newsappusingmvvm.adapter.ArticleAdapter;
import com.example.newsappusingmvvm.modal.Article;
import com.example.newsappusingmvvm.view_modal.ArticleViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG=MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private ProgressBar progress_Bar;
    private LinearLayoutManager LayoutManager;
    ArticleViewModel articleViewModel;
    private ArrayList<Article>articleArrayList=new ArrayList<>();
    private ArticleAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getArticles();

    }

    private void getArticles() {
        articleViewModel.getBashboardNewsResponseLiveData().observe(this,articleResponse -> {
            if(articleResponse!=null  && articleResponse.getArticles()!=null
            && !articleResponse.getArticles().isEmpty())
            {
                progress_Bar.setVisibility(View.GONE);
                List<Article>articleList=articleResponse.getArticles();
                articleArrayList.addAll(articleList);
                adapter.notifyDataSetChanged();


            }
        });

    }

    private void  init(){
         progress_Bar=findViewById(R.id.progres_bar);
         recyclerView=findViewById(R.id.recyler_view);
         LayoutManager=new LinearLayoutManager(MainActivity.this);
         recyclerView.setLayoutManager(LayoutManager);
         recyclerView.setHasFixedSize(true);
         adapter =new ArticleAdapter(MainActivity.this,articleArrayList);
         recyclerView.setHasFixedSize(true);

         adapter=new ArticleAdapter(MainActivity.this,articleArrayList);
         recyclerView.setAdapter(adapter);
        articleViewModel=ViewModelProviders.of(this).get(ArticleViewModel.class);





    }

}