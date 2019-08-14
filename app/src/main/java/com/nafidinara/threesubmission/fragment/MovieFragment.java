package com.nafidinara.threesubmission.fragment;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.nafidinara.threesubmission.R;
import com.nafidinara.threesubmission.adapter.AdapterMovie;
import com.nafidinara.threesubmission.model.Movie;
import com.nafidinara.threesubmission.viewModel.MovieVM;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private AdapterMovie adapter;
    private ProgressBar progressBar;
    private MovieVM movieVM;
    private RecyclerView rv;


    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_movie,container,false);
        rv = v.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));

        progressBar = v.findViewById(R.id.progressBar);
        movieVM = ViewModelProviders.of(this).get(MovieVM.class);
        movieVM.getMovies().observe(this,getMovie);

        showLoading(true);

        return v;
    }

    private Observer<Movie> getMovie = new Observer<Movie>() {
        @Override
        public void onChanged(@Nullable Movie movie) {
            adapter = new AdapterMovie(getContext(),movie.getResults());
            rv.setAdapter(adapter);
            showLoading(false);
        }
    };

    private void showLoading(Boolean state){
        if (state){
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
