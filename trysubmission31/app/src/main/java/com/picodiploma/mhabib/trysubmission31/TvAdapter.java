package com.picodiploma.mhabib.trysubmission31;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.TvViewHolder> {
    private ArrayList<TvItems> mData = new ArrayList <>(  );
    public void setData(ArrayList<TvItems> items){
        mData.clear();
        mData.addAll( items );
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public TvViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
       View mView = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.tv_items, viewGroup, false );
        return new TvViewHolder( mView );
    }

    @Override
    public void onBindViewHolder(@NonNull TvViewHolder tvViewHolder, int position) {
        tvViewHolder.bind( mData.get( position ) );
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class TvViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTvShow;
        TextView tvTitle;
        TextView tvPopularity;
        TextView tvReleaseDate;
        public TvViewHolder(@NonNull View itemView) {
            super( itemView );
            tvTitle = itemView.findViewById( R.id.textTitle );
            tvPopularity = itemView.findViewById( R.id.textPopularity );
            tvReleaseDate = itemView.findViewById( R.id.textReleaseDate );
            imgTvShow = itemView.findViewById( R.id.imageTvShow );
        }
        void bind(TvItems tvItems){
            Picasso.get().load( tvItems.getImageTvShow()).into( imgTvShow );
            tvTitle.setText( tvItems.getTitleTvShow() );
            tvPopularity.setText( tvItems.getPopularityTvShow() );
            tvReleaseDate.setText( tvItems.getReleaseDateTvShow() );
        }
    }
}
