package com.picodiploma.mhabib.sub3;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import com.picodiploma.mhabib.sub3.MovieAdapter;

public class MainActivity extends AppCompatActivity {
    private final ArrayList <MovieItems> listMovies = new ArrayList <>();

    private MovieAdapter adapter;
    private ProgressBar progressBar;

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        adapter = new MovieAdapter();
        adapter.notifyDataSetChanged();

        RecyclerView recyclerView = findViewById( R.id.recyclerView );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
        recyclerView.setAdapter( adapter );

        progressBar = findViewById( R.id.progressBar );

        mainViewModel = ViewModelProviders.of( this ).get( MainViewModel.class );
        mainViewModel.getMovies().observe( this, getMovie );

        findViewById( R.id.btnShow ).setOnClickListener( myListener );

        ItemClickSupport.addTo( recyclerView ).setOnClickListener( new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(int position) {
                Intent detailsMovieIntent = new Intent( MainActivity.this, DetailsMovieActivity.class );
                detailsMovieIntent.putExtra( DetailsMovieActivity.EXTRA_MOVIE, listMovies.get( position ) );
                startActivity( detailsMovieIntent );
            }
        }
        );
    }

    private Observer <ArrayList <MovieItems>> getMovie = new Observer <ArrayList <MovieItems>>() {
        @Override
        public void onChanged(ArrayList <MovieItems> movieItems) {
            if (movieItems != null) {
                adapter.setData( movieItems );
                showLoading( false );
            }
        }
    };

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mainViewModel.setMovie();
            showLoading( true );
        }
    };


    private void showLoading(boolean state) {
        if (state) {
            progressBar.setVisibility( View.VISIBLE );
        } else {
            progressBar.setVisibility( View.GONE );
        }
    }
}
