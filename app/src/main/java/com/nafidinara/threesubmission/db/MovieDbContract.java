package com.nafidinara.threesubmission.db;

import android.provider.BaseColumns;

public class MovieDbContract {

    static final class MovieColumns implements BaseColumns{
        static final  String TABLE_MOVIE_NAME = "movie";

        static final String ID = "id";
        static final String TITLE = "title";
        static final String OVERVIEW = "overview";
        static final String RELEASE_DATE= "release_date";
        static final String VOTE_AVERAGE = "vote_average";
        static final String VOTE_COUNT = "vote_count";
        static final String ORIGINAL_LANGUANGE = "original_language";
        static final String POSTER_PATH = "poster_path";
        static final String BACKDROP_PATH = "backdrop_path";
    }
}
