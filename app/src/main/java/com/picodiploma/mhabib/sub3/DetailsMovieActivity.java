package com.picodiploma.mhabib.sub3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_details_movie );

        TextView tvTitleDetails = findViewById( R.id.tv_details_title_movie );
        TextView tvRatingDetails = findViewById( R.id.tv_details_rating_movie );
        TextView tvDescDetails = findViewById( R.id.tv_details_desc_movie );
        TextView tvGenreDetails = findViewById( R.id.tv_details_genre_movie );
        TextView tvReleaseDateDetails = findViewById( R.id.tv_details_release_date_movie );

        ImageView ivImgDetails = findViewById( R.id.iv_details_img_movie );

        MovieItems movieItems = getIntent().getParcelableExtra( EXTRA_MOVIE );

        String titleDetails = movieItems.getTitle();
        tvTitleDetails.setText( titleDetails );
        String ratingDetails = movieItems.getPopularity();
        tvRatingDetails.setText( ratingDetails );
        String descDetails = movieItems.getDescription();
        tvDescDetails.setText( descDetails );
        String releaseDetails = movieItems.getReleaseDate();
        tvReleaseDateDetails.setText( releaseDetails );

        Picasso.get().load(movieItems.getImage()).into(ivImgDetails);
    }
}
