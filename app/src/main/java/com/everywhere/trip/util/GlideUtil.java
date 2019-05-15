package com.everywhere.trip.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.everywhere.trip.R;
import com.everywhere.trip.base.Constants;

/**
 * Created by 灵风 on 2019/5/6.
 */

public class GlideUtil {
    /**
     * 加载圆形资源图片
     * @param placeholderImg    图片加载时的占位图
     * @param imgId         要加载的资源图片Id
     * @param iv
     * @param context
     */
    public static void loadResCircleImage( int placeholderImg, Object imgId, ImageView iv, Context context){
        RequestOptions options = new RequestOptions()

                .placeholder(placeholderImg)
                .circleCrop();
        Glide.with(context)
                .load(imgId)
                .apply(options)
                .into(iv);
    }

    //加载资源图片
    public static void loadResImage(int placeholderImg, Object imgId, ImageView iv, Context context){
        RequestOptions options = new RequestOptions()
                .placeholder(placeholderImg);
        Glide.with(context)
                .load(imgId)
                .apply(options)
                .into(iv);
    }

    //加载圆角图片
    public static void loadUrlRoundImg(int roundRadius, int placeholderImg, String url, ImageView iv, Context context) {
        RoundedCorners corners = new RoundedCorners(SystemUtil.dp2px(roundRadius));
        RequestOptions options = RequestOptions.bitmapTransform(corners)
                .placeholder(placeholderImg);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(iv);
    }

}
