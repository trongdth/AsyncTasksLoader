package com.mroomsoft.asynctasksloadersample;

import android.content.AsyncTaskLoader;
import android.content.Context;
import java.util.List;

/**
 * Created by Trong_iOS on 9/3/16.
 */
public class NewsLoader extends AsyncTaskLoader<List<String>> {

    public NewsLoader(Context context) {
        super(context);
    }

    @Override
    public List<String> loadInBackground() {
        return null;
    }
}
