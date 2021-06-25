package com.example.newsappusingmvvm.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.newsappusingmvvm.R;
import com.example.newsappusingmvvm.adapter.SavedListAdapter;
import com.example.newsappusingmvvm.modal.Article;
import com.example.newsappusingmvvm.view_modal.SavedListViewModel;

import java.util.ArrayList;
import java.util.List;

public class SavedActivity extends AppCompatActivity {
    private List<Article> savedList;
    private RecyclerView recyclerView;
    private SavedListAdapter adapter;
    private SavedListViewModel viewModel;
    private TextView nothingSaved;
    private EditText searchField;
    private List<Article> removedObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        init();
        setListener();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        viewModel.setSavedList(savedList);
        viewModel.getSavedListObserver().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
                if(articles!=null &&savedList.size()!=0 ){
                    savedList=articles;
                    adapter.setSavedList(articles);
                }
                else{
                    nothingSaved.setVisibility(View.VISIBLE);

                }
            }
        });

    }

    private void setListener() {
        searchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());

            }
        });
    }

    public void init(){
        savedList=getIntent().getParcelableArrayListExtra("savedList");
        recyclerView=findViewById(R.id.recycler_view);
        adapter = new SavedListAdapter(this,savedList);
        viewModel= new ViewModelProvider(this).get(SavedListViewModel.class);
        nothingSaved=findViewById(R.id.no_result);
        searchField=findViewById(R.id.search_field);


    }
    public void filter(String search){
        List<Article> temp= new ArrayList<>();
        for(Article a: savedList){
            if(a.getTitle().toLowerCase().contains(search.toLowerCase()))
                temp.add(a);
        }
        if(temp.size()==0)
            nothingSaved.setVisibility(View.VISIBLE);
        else
            nothingSaved.setVisibility(View.GONE);
        adapter.setSavedList(temp);



    }
}