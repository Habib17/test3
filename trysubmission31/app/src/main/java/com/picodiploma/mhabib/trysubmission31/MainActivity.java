package com.picodiploma.mhabib.trysubmission31;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TvAdapter adapter;
    private ProgressBar progressBar;
    private MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        adapter = new TvAdapter();
        adapter.notifyDataSetChanged();

        RecyclerView recyclerView = findViewById( R.id.recyclerView );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
        recyclerView.setAdapter( adapter );

        progressBar = findViewById( R.id.progressBar );

        mainViewModel = ViewModelProviders.of( this ).get(MainViewModel.class);
        mainViewModel.getTvShows().observe(this, getTvShow);

        findViewById( R.id.btnShow ).setOnClickListener( myListener );
    }

    private Observer<ArrayList<TvItems>> getTvShow = new Observer <ArrayList <TvItems>>() {
        @Override
        public void onChanged(@Nullable ArrayList <TvItems> tvItems) {
            if(tvItems != null){
                adapter.setData( tvItems );
                showLoading(false);
            }
        }
    };

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mainViewModel.setTvShow();
            showLoading(true);
        }
    };

    private void showLoading(boolean state){
        if(state){
            progressBar.setVisibility( View.VISIBLE );
        }
        else {
            progressBar.setVisibility( View.GONE );
        }
    }
}
