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
import com.nafidinara.threesubmission.adapter.AdapterTvShow;
import com.nafidinara.threesubmission.model.TvShow;
import com.nafidinara.threesubmission.viewModel.TvShowVM;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {
    private AdapterTvShow adapter;
    private ProgressBar progressBar;
    private TvShowVM tvShowVM;
    private RecyclerView rv;


    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tv_show,container,false);
        rv = v.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));

        progressBar = v.findViewById(R.id.progressBar2);
        tvShowVM = ViewModelProviders.of(this).get(TvShowVM.class);
        tvShowVM.getTvShow().observe(this,getTvShow);

        showLoading(true);

        return v;

    }

    private Observer<TvShow> getTvShow = new Observer<TvShow>() {
        @Override
        public void onChanged(@Nullable TvShow tvShow) {
            adapter = new AdapterTvShow(getContext(),tvShow.getResults());
            rv.setAdapter(adapter);
            showLoading(false);
        }
    };

    private void showLoading(Boolean state){
        if (state){
            progressBar.setVisibility(View.VISIBLE);
        }else {
            progressBar.setVisibility(View.GONE);
        }
    }

}
