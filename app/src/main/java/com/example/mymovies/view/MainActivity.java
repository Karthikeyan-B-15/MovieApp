package com.example.mymovies.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mymovies.R;
import com.example.mymovies.adapter.MovieListAdapter;
import com.example.mymovies.databinding.ActivityMainBinding;
import com.example.mymovies.model.Results;
import com.example.mymovies.viewmodel.MovieViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String  API_KEY="9a2bdc61f7e9de98ec887d51db0cde00";
    private ActivityMainBinding binding;
    private RecyclerView recyclerView;
    private MovieListAdapter adapter;
    private MovieListAdapter.AdapterClickListener listener;
    private List<Results> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        getAdapter();
        MovieViewModel model=new ViewModelProvider(this).get(MovieViewModel.class);
        model.apiCall().observe(this, new Observer<List<Results>>() {
            @Override
            public void onChanged(List<Results> results) {
                adapter.setItems(results);
                list=results;
            }
        });
    }
    public void getAdapter(){
        setOnClick();
        recyclerView=binding.movierecycle;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new MovieListAdapter(listener);
        recyclerView.setAdapter(adapter);
    }
    public void setOnClick(){
listener=new MovieListAdapter.AdapterClickListener() {
    @Override
    public void onClick(View v, int position) {
        Results results=list.get(position);
        Intent intent=new Intent(MainActivity.this,MovieDetails.class);
        intent.putExtra("id",results.getId());
        startActivity(intent);
    }
};
    }
}