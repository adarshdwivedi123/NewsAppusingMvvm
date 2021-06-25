package com.example.newsappusingmvvm.view_modal;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.newsappusingmvvm.modal.Article;
import com.example.newsappusingmvvm.repository.ArticlesRepository;

import java.util.List;

public class NewsListViewModel extends AndroidViewModel {
    private ArticlesRepository articlesRepository;
    private MutableLiveData<List<Article>> newsList;

    public NewsListViewModel(@NonNull Application application) {
        super(application);
        articlesRepository= new ArticlesRepository(application);
        articlesRepository.makeApiCallDatabase();
        newsList= articlesRepository.getAllNews();

    }


    public MutableLiveData<List<Article>> getNewsListObserver() {
        return newsList;
    }

//    public void makeApiCall(){
//        NewsService newsService = RetrofitInstance.getRetrofitClient().create(NewsService.class);
//        Call<NewsModel> call = newsService.getNews();
//         call.enqueue(new Callback<NewsModel>() {
//             @Override
//             public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
//                 newsList.postValue(response.body().getArticles());
//             }
//             @Override
//             public void onFailure(Call<NewsModel> call, Throwable t) {
//                 newsList.postValue(null);
//
//             }
//         });
//    }
}
