package android.channel.soybeansprouthead.common;

import android.channel.soybeansprouthead.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joonki on 2017-01-14.
 */

public class BasicListAdapter extends BaseAdapter {
    //
    private List<BasicListItem> items;

    public BasicListAdapter() {
        this.items = new ArrayList<>();
    }

    public void add(BasicListItem item) {
        items.add(item);
    }

    public void removeAll() {
        //
        items.clear();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.basiclistitemview, parent, false);
        }

        ImageView mainImageView = (ImageView) convertView.findViewById(R.id.mainImageView);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.titleTextView);
        TextView subTitleTextView = (TextView) convertView.findViewById(R.id.subTitleTextView);
        TextView contentTextView = (TextView) convertView.findViewById(R.id.contentTextView);
        ImageView bookmarkImageView = (ImageView) convertView.findViewById(R.id.bookmarkImageView);

        BasicListItem basicListItem = items.get(position);

        mainImageView.setImageDrawable(basicListItem.getMainImage());
        titleTextView.setText(basicListItem.getTitle());
        subTitleTextView.setText(basicListItem.getSubTitle());
        contentTextView.setText(basicListItem.getContent());
        bookmarkImageView.setImageDrawable(basicListItem.getBookmarkImage());

        return convertView;
    }
}
