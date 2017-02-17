package common.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Joonki on 2016-12-05.
 */

public class BaseService {
    protected static Object retrofit(Class<?> className)
    {
        String host = "http://192.168.200.112:8000";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(host).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(className);
    }
}
