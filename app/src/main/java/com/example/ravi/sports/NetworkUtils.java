package com.example.ravi.sports;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Ravi on 29-07-2018.
 */

public class NetworkUtils {

    private static final String apiKey = "Enter an API Key";

    private static final String url = "https://newsapi.org/v2/";

    private static final String cricketUrl = "https://newsapi.org/v2/";


    public static Service service = null;

    public static Service getService(){

        if (service == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            service = retrofit.create(Service.class);
        }

        return service;
    }


    public interface Service{

        @GET("top-headlines?sources=bbc-sport&apiKey=" + apiKey)
        Call <BBC> getBBC();


    }





    public static CricketService cricketService = null;

    public static CricketService getCricketService(){

        if (cricketService == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(cricketUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            cricketService = retrofit.create(CricketService.class);
        }

        return cricketService;
    }



    public interface CricketService{

        @GET("top-headlines?sources=espn-cric-info&apiKey=" + apiKey)
        Call <BBC> getBBC();


    }





}
