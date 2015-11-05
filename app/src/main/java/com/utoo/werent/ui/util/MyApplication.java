package com.utoo.werent.ui.util;

import android.app.Application;
import android.os.Environment;
import android.util.Log;

import java.io.File;

public class MyApplication extends Application {
    public String catchDirPath;

    @Override
    public void onCreate() {
        super.onCreate();
        catchDirPath = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/werent";
        Log.e("缓存", catchDirPath);
        File file = new File(catchDirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

}
