package com.elision.infotech.elisionsdk;

import android.app.Application;

import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(
                this,
                initializationStatus -> {
                });
        new AppOpenManager(this);
        AudienceNetworkAds.initialize(this);
    }
}
