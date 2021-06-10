package com.daquexian.flexiblerichtextview;

import android.widget.ImageView;

public interface IFlexibleRichImageLoader {
    void loadImageDrawable(ImageView imageView, String url, FlexibleRichImageLoadCallback callback);
}
