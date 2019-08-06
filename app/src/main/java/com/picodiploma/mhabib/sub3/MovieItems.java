package com.picodiploma.mhabib.sub3;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import java.text.DecimalFormat;

public class MovieItems implements Parcelable {
    private  int id;
    private String title;
    private String image;
    private String popularity;
    private String releaseDate;
    private  String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    MovieItems(JSONObject object){
    try {
        int id = object.getInt( "id" );
        String titleMovie = object.getString( "title" );
        double popularityMovie = object.getDouble( "popularity" );
        String descMovie = object.getString( "overview" );
        String releaseMovie = object.getString( "release_date" );
        String image = object.getString( "poster_path" );

        String popular = new DecimalFormat( "##.##" ).format( popularityMovie );
        String imageView = "https://image.tmdb.org/t/p/w185/" + image;
        this.id = id;
        this.title = titleMovie;
        this.popularity = popular;

        this.description = descMovie;
        this.releaseDate = releaseMovie;
        this.image = imageView;
    }
    catch (Exception e){
        e.printStackTrace();
    }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt( this.id );
        dest.writeString( this.title );
        dest.writeString( this.image );
        dest.writeString( this.popularity );
        dest.writeString( this.releaseDate );
        dest.writeString( this.description );
    }

    protected MovieItems(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.image = in.readString();
        this.popularity = in.readString();
        this.releaseDate = in.readString();
        this.description = in.readString();
    }

    public static final Creator <MovieItems> CREATOR = new Creator <MovieItems>() {
        @Override
        public MovieItems createFromParcel(Parcel source) {
            return new MovieItems( source );
        }

        @Override
        public MovieItems[] newArray(int size) {
            return new MovieItems[size];
        }
    };
}
