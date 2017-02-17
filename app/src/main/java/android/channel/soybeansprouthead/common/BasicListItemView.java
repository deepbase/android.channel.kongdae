package android.channel.soybeansprouthead.common;

import android.channel.soybeansprouthead.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Joonki on 2017-01-13.
 */

public class BasicListItemView extends LinearLayout {
    //
    private BasicListItem listItem;
    private ImageView mainImageView;
    private TextView titleTextView;
    private TextView subTitleTextView;
    private TextView contentTextView;
    private ImageView bookmarkImageView;

    public BasicListItemView(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.basiclistitemview, this, true);

        this.mainImageView = (ImageView)findViewById(R.id.mainImageView);
        this.titleTextView = (TextView)findViewById(R.id.titleTextView);
        this.subTitleTextView = (TextView)findViewById(R.id.subTitleTextView);
        this.contentTextView = (TextView)findViewById(R.id.contentTextView);
        this.bookmarkImageView = (ImageView)findViewById(R.id.bookmarkImageView);
    }

    public BasicListItemView(Context context, BasicListItem listItem) {
        this(context);

        this.listItem = listItem;
        mainImageView.setImageDrawable(listItem.getMainImage());
        titleTextView.setText(listItem.getTitle());
        subTitleTextView.setText(listItem.getSubTitle());
        contentTextView.setText(listItem.getContent());
        bookmarkImageView.setImageDrawable(listItem.getBookmarkImage());
    }

    public void setItem(BasicListItem listItem) {
        //
        this.listItem = listItem;

        mainImageView.setImageDrawable(listItem.getMainImage());
        titleTextView.setText(listItem.getTitle());
        subTitleTextView.setText(listItem.getSubTitle());
        contentTextView.setText(listItem.getContent());
        bookmarkImageView.setImageDrawable(listItem.getBookmarkImage());
    }

    public BasicListItem getListItem() {
        return listItem;
    }

    public void setListItem(BasicListItem listItem) {
        this.listItem = listItem;
    }

    public ImageView getMainImageView() {
        return mainImageView;
    }

    public void setMainImageView(Drawable icon) {
        mainImageView.setImageDrawable(icon);
    }

    public TextView getTitleTextView() {
        return titleTextView;
    }

    public void setTitleTextView(String title) {
        titleTextView.setText(title);
    }

    public TextView getSubTitleTextView() {
        return subTitleTextView;
    }

    public void setSubTitleTextView(String subTitle) {
        subTitleTextView.setText(subTitle);
    }

    public TextView getContentTextView() {
        return contentTextView;
    }

    public void setContentTextView(String content) {
        contentTextView.setText(content);
    }

    public ImageView getBookmarkImageView() {
        return bookmarkImageView;
    }

    public void setBookmarkImageView(Drawable icon) {
        bookmarkImageView.setImageDrawable(icon);
    }
}
