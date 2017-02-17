package android.channel.soybeansprouthead.music;


import android.channel.soybeansprouthead.R;
import android.channel.soybeansprouthead.common.BasicListAdapter;
import android.channel.soybeansprouthead.common.BasicListFragment;
import android.channel.soybeansprouthead.common.BasicListItem;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import common.util.JsonUtil;
import music.domain.Music;
import music.service.MusicService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MusicFragment extends Fragment {
    //
    private Spinner composerSpinner;
    private Spinner genreSpinner;
    private AutoCompleteTextView musicAutoCompleteTextView;
    private Spinner sortOrderSpinner;
    private ListView musicListView;
    private BasicListAdapter musicListViewAdapter;

    public MusicFragment() {
        // Required empty public constructor
        this.musicListViewAdapter = new BasicListAdapter();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initControls();
        bindEvents();
        loadInitData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        return view;
    }

    private void initControls() {
        this.composerSpinner = (Spinner) getView().findViewById(R.id.composerSpinner);
        this.genreSpinner = (Spinner) getView().findViewById(R.id.genreSpinner);
        this.musicAutoCompleteTextView = (AutoCompleteTextView) getView().findViewById(R.id.musicAutoCompleteTextView);
        this.sortOrderSpinner = (Spinner) getView().findViewById(R.id.sortOrderSpinner);
        this.musicListView = (ListView) getView().findViewById(R.id.musicListView);
        musicListView.setAdapter(musicListViewAdapter);
    }

    private void bindEvents() {

    }

    private void loadInitData() {
        List<String> composerDummyItems = new ArrayList<>();
        List<String> genreDummyItems = new ArrayList<>();
        List<String> sortOrderDummyItems = new ArrayList<>();

        composerDummyItems.add("베토벤");
        composerDummyItems.add("쇼팽");
        ArrayAdapter<String> composerAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, composerDummyItems);
        composerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        composerSpinner.setAdapter(composerAdapter);

        genreDummyItems.add("교향곡");
        genreDummyItems.add("협주곡");
        ArrayAdapter<String> genreAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, genreDummyItems);
        genreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genreSpinner.setAdapter(genreAdapter);

        sortOrderDummyItems.add("별점순");
        sortOrderDummyItems.add("추천순");
        ArrayAdapter<String> sortOrderAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, sortOrderDummyItems);
        sortOrderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortOrderSpinner.setAdapter(sortOrderAdapter);

        refreshList();
    }

    private void refreshList() {
        //
        Call<List<Music>> musics = MusicService.api().getAllMusics();
        musics.enqueue(new Callback<List<Music>>() {
            @Override
            public void onResponse(Call<List<Music>> call, Response<List<Music>> response) { // Platform.runLater();
                musicListViewAdapter.removeAll();
                List<Music> musics = response.body();
                for (Music music : musics) {
                    BasicListItem item = new BasicListItem(music.getComposer(), music.getName(), Float.toString(music.getAverageGrade()));
                    item.setMainImage(ResourcesCompat.getDrawable(getResources(), R.drawable.symphony, null));
                    musicListViewAdapter.add(item);
                }
                musicListViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Music>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
