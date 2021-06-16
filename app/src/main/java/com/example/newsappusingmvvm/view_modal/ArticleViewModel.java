package com.example.newsappusingmvvm.view_modal;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.newsappusingmvvm.Response.ArticleResponse;
import com.example.newsappusingmvvm.modal.Article;
import com.example.newsappusingmvvm.repository.ArticleRepository;

public class ArticleViewModel  extends AndroidViewModel {
    private ArticleRepository articleRepository;
    private LiveData<ArticleResponse>articleResponseLiveData;

    public ArticleViewModel(Application application) {
        super(application);

        articleRepository = new ArticleRepository();
        this.articleResponseLiveData = articleRepository.getDashBoardNews();


    }
    public LiveData<ArticleResponse>getBashboardNewsResponseLiveData()
    {
            return articleResponseLiveData;


    }



}
