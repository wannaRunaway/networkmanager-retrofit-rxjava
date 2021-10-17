package com.example.networkmanager_retrofitrxjava;

import android.content.Context;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class InternetworkManager {
    //单利retrofitApi
    private static volatile RetrofitApi retrofitApi;
    private static Retrofit retrofit;
    public static RetrofitApi getRetrofitApi(Context context){
        if (retrofitApi==null){
            synchronized (InternetworkManager.class){
                if (retrofitApi==null){
                    retrofitInit(context);
                    retrofitApi = retrofit.create(RetrofitApi.class);
                }
            }
        }
        return retrofitApi;
    }

    private static void retrofitInit(Context context){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient.Builder()
                            .addInterceptor(new HttpLogInterceptor(context))
                            .sslSocketFactory(createSSLSocketFactory(), new TrustAllCerts())
                            .hostnameVerifier(new TrustAllHostnameVerifier())
                            .build())
                    .baseUrl("https://www.wanandroid.com/")
                    .build();
        }
    }
    private static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory ssfFactory = null;
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new TrustAllCerts()}, new SecureRandom());
            ssfFactory = sc.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ssfFactory;
    }

    private static class TrustAllCerts implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}
