package com.bored.boredapp.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.bored.boredapp.BuildConfig;
import com.bored.boredapp.R;
import com.bored.boredapp.base.AppManager;
import com.bored.boredapp.crash.CaocConfig;
import com.bored.boredapp.ui.MainActivity;
import com.bored.boredapp.utils.KLog;
import com.bored.boredapp.utils.Utils;
import com.squareup.leakcanary.LeakCanary;

import androidx.annotation.NonNull;


/**
 * Created by goldze on 2017/7/16.
 */

public class AppApplication extends Application {

    private static Application sInstance;

    /**
     * 获得当前app运行的Application
     */
    public static Application getInstance() {
        if (sInstance == null) {
            throw new NullPointerException("please inherit BaseApplication or call initApplication.");
        }
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initApplication(this);
        //是否开启打印日志
        KLog.init(BuildConfig.DEBUG);
        //初始化全局异常崩溃
        initCrash();
        //内存泄漏检测
        if (!LeakCanary.isInAnalyzerProcess(this)) {
            LeakCanary.install(this);
        }
    }

    private void initCrash() {
        CaocConfig.Builder.create()
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //背景模式,开启沉浸式
                .enabled(true) //是否启动全局异常捕获
                .showErrorDetails(true) //是否显示错误详细信息
                .showRestartButton(true) //是否显示重启按钮
                .trackActivities(true) //是否跟踪Activity
                .minTimeBetweenCrashesMs(2000) //崩溃的间隔时间(毫秒)
                .errorDrawable(R.mipmap.ic_launcher) //错误图标
                .restartActivity(MainActivity.class) //重新启动后的activity
//                .errorActivity(YourCustomErrorActivity.class) //崩溃后的错误activity
//                .eventListener(new YourCustomEventListener()) //崩溃后的错误监听
                .apply();
    }

    /**
     * 当主工程没有继承BaseApplication时，可以使用initApplication方法初始化BaseApplication
     *
     * @param application
     */
    private void initApplication(@NonNull Application application) {
        sInstance = application;
        Utils.init(application);
        //注册监听每个activity的生命周期,便于堆栈式管理
        application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {

            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                AppManager.getAppManager().addActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {
            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                AppManager.getAppManager().removeActivity(activity);
            }
        });
    }

}
