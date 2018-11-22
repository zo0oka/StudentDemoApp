package com.example.zo0okadev.studentdemoapp.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class SingletonVolley {

    private static SingletonVolley mInstance;
    private Context mContext;
    private RequestQueue requestQueue;
    private ImageLoader mImageLoader;

    private SingletonVolley(Context context) {
        mContext = context;
        requestQueue = getRequestQueue();

        mImageLoader = new ImageLoader(requestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<String, Bitmap>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });
    }

    public static synchronized SingletonVolley getInstance(Context context) {

        if (mInstance == null) {
            mInstance = new SingletonVolley(context);
        }
        return mInstance;
    }

    private RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mContext);
        }
        return requestQueue;
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        requestQueue.add(request);
    }
}
