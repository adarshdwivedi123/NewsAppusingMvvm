package com.example.newsappusingmvvm.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.newsappusingmvvm.constant.AppConstant.BASE_URL;

public class RetrofitInstance {

    private static Retrofit retrofit;
    public static Retrofit getRetrofitClient()
    {

        if(retrofit == null)

        {
            retrofit =new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }
        return  retrofit;
    }

}
