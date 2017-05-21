package com.example.narmal.aquasafe_prototype;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by narmal on 5/12/2017.
 */
public class Interface {
    Context mContext;

    /** Instantiate the interface and set the context */
    Interface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }
}
