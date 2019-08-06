package com.picodiploma.mhabib.sub3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    public ArrayList<MovieItems> mData = new ArrayList <>(  );
    public void setData(ArrayList<MovieItems> items){
        mData.clear();
        mData.addAll( items );
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View mView = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.movie_items, viewGroup, false );
        return new MovieViewHolder( mView );
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int position) {
        movieViewHolder.bind( mData.get( position ) );
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imageMovie;
        TextView textViewTitle;
        TextView textViewPopularity;
        TextView textViewReleaseDate;
        TextView textViewDesc;
        public MovieViewHolder(@NonNull View itemView) {
            super( itemView );
            textViewTitle = itemView.findViewById( R.id.textTitle );
            textViewPopularity = itemView.findViewById( R.id.textPopularity );
            textViewReleaseDate = itemView.findViewById( R.id.textReleaseDate );
            textViewDesc = itemView.findViewById( R.id.textDesc );
            imageMovie = itemView.findViewById( R.id.imageMovie );

        }
        void bind(MovieItems movieItems){
            Picasso.get().load(movieItems.getImage()).into(imageMovie);
            textViewTitle.setText( movieItems.getTitle() );
            textViewPopularity.setText(  movieItems.getPopularity() );
            textViewReleaseDate.setText( movieItems.getReleaseDate() );
            textViewDesc.setText( movieItems.getDescription() );
        }
    }
}
