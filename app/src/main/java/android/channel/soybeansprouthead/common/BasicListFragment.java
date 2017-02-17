package android.channel.soybeansprouthead.common;

import android.channel.soybeansprouthead.R;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import music.domain.Music;
import music.service.MusicService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Joonki on 2017-01-24.
 */

public class BasicListFragment extends ListFragment {
    //
    BasicListAdapter adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new BasicListAdapter();
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.basiclistitemview, container, false);
//        return view;
//        adapter = new BasicListAdapter();
//        setListAdapter(adapter);

//        Call<List<Music>> musics = MusicService.api().getAllMusics();
//        BasicListItem listItem = new BasicListItem("아아", "에엥", "오오오오오");

//        listItem.setBookmarkImage(ResourcesCompat.getDrawable(getResources(), R.drawable.beethoven, null));
//        adapter.add(listItem);
//        Call<Music> music = MusicService.api().getMusic("1");
//        musics.enqueue(new Callback<List<Music>>() {
//            @Override
//            public void onResponse(Call<List<Music>> call, Response<List<Music>> response) { // Platform.runLater();
//                List<Music> musics = response.body();
//                for (Music music : musics) {
//                    BasicListItem item = new BasicListItem(music.getComposer(), music.getName(), Float.toString(music.getAverageGrade()));
//                    adapter.add(item);
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<List<Music>> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void addItem(BasicListItem item) {
        adapter.add(item);
    }

    public BasicListAdapter getAdapter() {
        return adapter;
    }
}
