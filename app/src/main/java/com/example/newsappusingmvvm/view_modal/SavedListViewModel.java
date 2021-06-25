package com.example.newsappusingmvvm.view_modal;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsappusingmvvm.modal.Article;

import java.util.List;

public class SavedListViewModel extends ViewModel {
    private MutableLiveData<List<Article>> savedList;

    public SavedListViewModel() {
        savedList = new MutableLiveData<>();
    }

    public MutableLiveData<List<Article>> getSavedListObserver(){
        return this.savedList;
    }
    public void setSavedList(List<Article> articles){
        savedList.postValue(articles);
    }
}
