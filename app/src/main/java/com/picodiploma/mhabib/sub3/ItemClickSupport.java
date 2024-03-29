package com.picodiploma.mhabib.sub3;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

public class ItemClickSupport {
    private final RecyclerView mRecyclerView;
    private OnItemClickListener mOnItemClickListener;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mOnItemClickListener != null){
                RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder( v );
                mOnItemClickListener.onItemClicked( holder.getAdapterPosition() );
            }
        }
    };

    private ItemClickSupport(RecyclerView recyclerView){
        mRecyclerView = recyclerView;
        mRecyclerView.setTag( R.id.item_click_support, this );
        RecyclerView.OnChildAttachStateChangeListener mAttachListener = new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(@NonNull View view) {
                if(mOnClickListener != null){
                    view.setOnClickListener( mOnClickListener );
                }
            }

            @Override
            public void onChildViewDetachedFromWindow(@NonNull View view) {

            }
        };
        mRecyclerView.addOnChildAttachStateChangeListener( mAttachListener );
    }

    public static ItemClickSupport addTo(RecyclerView view){
        ItemClickSupport support = (ItemClickSupport) view.getTag(R.id.item_click_support);
        if(support == null){
            support = new ItemClickSupport( view );
        }
        return support;
    }

    public void setOnClickListener(OnItemClickListener listener){
        mOnItemClickListener = listener;
    }

    public interface OnItemClickListener{
        void onItemClicked(int position);
    }

}
