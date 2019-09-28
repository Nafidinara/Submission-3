package com.nafidinara.threesubmission.db;

import android.provider.BaseColumns;

public class TvDbContract {

    static final class TvColumns implements BaseColumns{
        static final String TABLE_TV_NAME = "tv";

        static final String ID = "id";
        static final String TITLE = "title";
        static final String OVERVIEW = "overview";
        static final String RELEASE_DATE = "release_date";
        static final String VOTE_AVERAGE = "vote_average";
        static final String VOTE_COUNT = "vote_count";
        static final String ORIGINAL_LANGUAGE = "original_language";
        static final String POSTER_PATH = "poster_path";
        static final String BACKDROP_PATH = "backdrop_path";
    }
}
