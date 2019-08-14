package com.nafidinara.threesubmission.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.nafidinara.threesubmission.R;
import com.nafidinara.threesubmission.model.TvShow;

public class DetailTvActivity extends AppCompatActivity {
    public static final String DATA_TVSHOW = "data_tvshow";
    private String img_main_url = "https://image.tmdb.org/t/p/w185";
    private String img_bg_url = "https://image.tmdb.org/t/p/w500";
    TextView title, release, language, vote, rating, storyline, title_toolbar;
    ImageView image_Poster, image_bg;
    ProgressBar progressBar;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv);

        prepare();

        getTVShowDetail();
    }

    private void prepare() {
        title = findViewById(R.id.detail_tv_title1);
        language = findViewById(R.id.detail_tv_language1);
        release = findViewById(R.id.detail_tv_release1);
        vote = findViewById(R.id.detail_tv_vote1);
        rating = findViewById(R.id.detail_tv_rating1);
        storyline = findViewById(R.id.detail_tv_storyline1);
        image_bg = findViewById(R.id.detail_poster_background1);
        image_Poster = findViewById(R.id.detail_poster1);
        progressBar = findViewById(R.id.progressBarDetail1);
        title_toolbar = findViewById(R.id.detail_title_tolbar1);
    }

    private void getTVShowDetail() {
        progressBar.setVisibility(View.VISIBLE);
        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        TvShow tvShow = getIntent().getParcelableExtra(DATA_TVSHOW);

                        title_toolbar.setText(tvShow.getTitle());
                        title.setText(tvShow.getTitle());
                        rating.setText(Double.toString(tvShow.getVoteAverage()));
                        vote.setText(Double.toString(tvShow.getVoteCount()));
                        language.setText(tvShow.getOriginalLanguage());
                        release.setText(tvShow.getReleaseDate());
                        storyline.setText(tvShow.getOverview());

                        Glide.with(DetailTvActivity.this)
                                .load(img_main_url + tvShow.getPosterPath())
                                .into(image_Poster);
                        Glide.with(DetailTvActivity.this)
                                .load(img_bg_url + tvShow.getBackdropPath())
                                .into(image_bg);

                        toolbar = findViewById(R.id.detail_toolbar1);
                        toolbar.setNavigationIcon(R.drawable.back_arrow);
                        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                finish();
                            }
                        });

                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }).start();
    }
}