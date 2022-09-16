package com.example.mymovies.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mymovies.R;
import com.example.mymovies.model.DetailModel;
import com.example.mymovies.viewmodel.MovieViewModel;

import org.w3c.dom.Text;

public class MovieDetails extends AppCompatActivity {
    Intent intent;
    private TextView text,time,date,lang,vote,budget,revenue;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        text=(TextView)findViewById(R.id.text1);
        imageView=(ImageView)findViewById(R.id.imageView2);
        time=(TextView)findViewById(R.id.dtime);
        date=(TextView)findViewById(R.id.ddate);
        lang=(TextView)findViewById(R.id.dlang);
        vote=(TextView)findViewById(R.id.vote);
        budget=(TextView)findViewById(R.id.budget);
        revenue=(TextView)findViewById(R.id.revenue);
        intent=getIntent();
        getDetailViewModel(intent.getStringExtra("id"));
    }
    public void getDetailViewModel(String val){
        MovieViewModel viewModel=new ViewModelProvider(this).get(MovieViewModel.class);
        viewModel.getDetail(val);
        viewModel.getLiveData().observe(this, new Observer<DetailModel>() {
            @Override
            public void onChanged(DetailModel detailModel) {
                Glide.with(imageView.getContext()).load("https://image.tmdb.org/t/p/original"+detailModel.getBackdrop_path())
                                .into(imageView);
                text.setText(detailModel.getOverview());
                time.setText(detailModel.getRuntime()+"minutes");
                date.setText(detailModel.getRelease_date());
                lang.setText(detailModel.getOriginal_language());
                vote.setText(detailModel.getVote_average());
                budget.setText(detailModel.getBudget());
                revenue.setText(detailModel.getRevenue());
            }
        });
    }
}