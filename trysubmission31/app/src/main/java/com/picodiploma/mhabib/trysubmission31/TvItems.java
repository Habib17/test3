package com.picodiploma.mhabib.trysubmission31;

import org.json.JSONObject;

import java.text.DecimalFormat;

public class TvItems {
    private int id;
    private  String titleTvShow;
    private String imageTvShow;
    private String popularityTvShow;
    private String releaseDateTvShow;
    private String descriptionTvShow;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleTvShow() {
        return titleTvShow;
    }

    public void setTitleTvShow(String titleTvShow) {
        this.titleTvShow = titleTvShow;
    }

    public String getImageTvShow() {
        return imageTvShow;
    }

    public void setImageTvShow(String imageTvShow) {
        this.imageTvShow = imageTvShow;
    }

    public String getPopularityTvShow() {
        return popularityTvShow;
    }

    public void setPopularityTvShow(String popularityTvShow) {
        this.popularityTvShow = popularityTvShow;
    }

    public String getReleaseDateTvShow() {
        return releaseDateTvShow;
    }

    public void setReleaseDateTvShow(String releaseDateTvShow) {
        this.releaseDateTvShow = releaseDateTvShow;
    }

    public String getDescriptionTvShow() {
        return descriptionTvShow;
    }

    public void setDescriptionTvShow(String descriptionTvShow) {
        this.descriptionTvShow = descriptionTvShow;
    }

    TvItems(JSONObject object){
        try {
            int id = object.getInt( "id" );
            String titleTvShow = object.getString( "name" );
            double popular = object.getDouble( "popularity" );
            String descMovie = object.getString( "overview" );
            String releaseTvShow = object.getString( "first_air_date" );
            String image = object.getString( "poster_path" );

            String popularTvShow = new DecimalFormat( "##.##" ).format( popular );
            String imageTvShow = "https://image.tmdb.org/t/p/w185/" + image;
            this.id = id;
            this.titleTvShow = titleTvShow;
            this.descriptionTvShow = descMovie;
            this.releaseDateTvShow = releaseTvShow;
            this.imageTvShow = imageTvShow;
            this.popularityTvShow = popularTvShow;



        }
        catch (Exception e){
            e.printStackTrace();

        }


    }
}
