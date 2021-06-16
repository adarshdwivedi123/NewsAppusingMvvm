package com.example.newsappusingmvvm.retrofit;

import com.example.newsappusingmvvm.Response.ArticleResponse;
import com.example.newsappusingmvvm.modal.Article;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.example.newsappusingmvvm.constant.AppConstant.API_KEY;

public interface ApiRequest {

    @GET("top-headlines?country=in&category=business&apikey="+API_KEY)
    Call<ArticleResponse>getTopHeadlines();
}
