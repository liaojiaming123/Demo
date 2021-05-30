package com.example.test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public class RetrofitTest {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://blog.liaojiaming.com/").build();//创建Retrofit
    Http http = retrofit.create(Http.class);//创建请求对象

    public void getReq(){
        Call<Response<String>> call = http.getCall();
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<Response<String>> call, Response<Response<String>> response) {

                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<Response<String>> call, Throwable t) {
                System.out.println(t.toString());
            }
        });
    }

    /**
     * 创建HTTP请求接口
     * */
    interface Http{
        @GET("categories/Android/")
        Call<Response<String>> getCall();
    }

}
