package com.example.test;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OkHttp使用实例
 * */
public class OkhttpTest {
    private final OkHttpClient client = new OkHttpClient();//创建OkHttp实例
    Request request = new Request.Builder().url("http://blog.liaojiaming.com/").build();//创建请求对象
    public void getReq(){
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });
    }

}
