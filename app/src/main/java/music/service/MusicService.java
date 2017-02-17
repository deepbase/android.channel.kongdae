package music.service;


import java.util.List;

import common.service.BaseService;
import music.domain.Music;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by Joonki on 2017-01-01.
 */

public final class MusicService extends BaseService {

    public static MusicAPI api()
    {
        return (MusicAPI) retrofit(MusicAPI.class);
    }

    public interface MusicAPI
    {
//        @Headers("Authorization: Basic am9vbmtpOjEyMzQ=")
        @GET("/musics/")
        Call<List<Music>> getAllMusics();

//        @Headers("Authorization: Basic am9vbmtpOjEyMzQ=")
        @GET("/musics/{index}")
        Call<Music> getMusic(@Path("index") String index);
    }
}
