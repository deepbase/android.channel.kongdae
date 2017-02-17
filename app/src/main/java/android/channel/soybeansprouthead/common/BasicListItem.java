package android.channel.soybeansprouthead.common;

import android.graphics.drawable.Drawable;

/**
 * Created by Joonki on 2017-01-13.
 */

public class BasicListItem {
    //
    private Drawable mainImage;
    private String title;
    private String subTitle;
    private String content;
    private Drawable bookmarkImage;

    public BasicListItem(String title, String subTitle, String content) {
        //
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
    }

    public Drawable getMainImage() {
        return mainImage;
    }

    public void setMainImage(Drawable mainImage) {
        this.mainImage = mainImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Drawable getBookmarkImage() {
        return bookmarkImage;
    }

    public void setBookmarkImage(Drawable bookmarkImage) {
        this.bookmarkImage = bookmarkImage;
    }
}
