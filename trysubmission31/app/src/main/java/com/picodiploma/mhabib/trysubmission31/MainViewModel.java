package com.picodiploma.mhabib.trysubmission31;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainViewModel extends ViewModel {
    private static final String API_KEY = "f619004834d9f9c4c709d3d51b305d07";
    private MutableLiveData<ArrayList<TvItems>> listTvShow = new MutableLiveData <>();

    void setTvShow(){
        AsyncHttpClient client = new AsyncHttpClient(  );
        final ArrayList<TvItems> listItemsTvShow = new ArrayList <>(  );
        String url = "https://api.themoviedb.org/3/discover/tv?api_key=" + API_KEY + "&language=en-US";

        client.get( url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
              try {
                  String result = new String( responseBody );
                  JSONObject responseObject = new JSONObject( result );
                  JSONArray list = responseObject.getJSONArray( "results" );

                  for (int i=0; i<list.length(); i++){
                      JSONObject tvShowObject = list.getJSONObject( i );
                      TvItems tvItems = new TvItems( tvShowObject );
                      listItemsTvShow.add( tvItems );
                  }
                  listTvShow.postValue( listItemsTvShow );

              }
              catch (Exception e){
                  e.printStackTrace();
              }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure : ", error.getMessage());
            }
        } );
    }
    LiveData <ArrayList<TvItems>> getTvShows(){
        return listTvShow;
    }
}
