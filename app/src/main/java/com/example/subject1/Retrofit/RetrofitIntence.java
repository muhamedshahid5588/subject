package com.example.subject1.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitIntence {

    public static final String BASE_URL="http://apps.mnets.in:85/MCTest/Android/CommanAjaxRequest.aspx/";
    static Retrofit retrofit;
    public static Retrofit getRetrofit(){
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit;
    }
}
