package com.example.newsappusingmvvm.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.newsappusingmvvm.modal.Article;

import java.util.List;
@Dao
public interface ArticlesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Article article);

    @Query("SELECT * FROM  articles")
    LiveData<List<Article>>getAllArticles();

    @Query("DELETE FROM articles")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertArticles(List<Article>articles);
}
