package com.example.mymovies.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mymovies.databinding.MovielistitemBinding;
import com.example.mymovies.model.Results;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private List<Results> list;
    private AdapterClickListener listener;
    public void setItems(List<Results> list){
        this.list=list;
        notifyDataSetChanged();
    }
    public MovieListAdapter(AdapterClickListener listener){
    this.listener=listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(MovielistitemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Results results=list.get(position);
        Glide.with(holder.binding.imageView)
                .load("https://image.tmdb.org/t/p/original"+results.getPoster_path())
                .into(holder.binding.imageView);
        holder.binding.content.setText(results.getOverview());
        holder.binding.count.setText(results.getVote_average());
        holder.binding.date.setText(results.getRelease_date());
        holder.binding.lang.setText(results.getOriginal_language());
        holder.binding.head.setText(results.getOriginal_title());
    }

    @Override
    public int getItemCount() {
        if(list==null){
            return 0;
        }else {
            return list.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private MovielistitemBinding binding;
        public ViewHolder(@NonNull MovielistitemBinding itemView) {
            super(itemView.getRoot());
            this.binding=itemView;
            itemView.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAbsoluteAdapterPosition());
        }
    }
    public interface AdapterClickListener{
        void onClick(View v,int position);
    }
}
