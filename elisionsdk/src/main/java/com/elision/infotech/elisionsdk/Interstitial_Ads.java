package com.elision.infotech.elisionsdk;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

public class Interstitial_Ads {

    public void Show_Ads(Activity source_class, Intent intent, final boolean flag) {
        AppPreference preference = new AppPreference(source_class);

        if (!preference.get_Click_Flag().equalsIgnoreCase("on")) {
            if (Constant.IS_TIME_INTERVAL) {
                if (preference.get_Adstyle().equalsIgnoreCase("Normal")) {
                    Interstitial_Ads_Admob_Fb.ShowAd_Full(source_class, intent, flag);
                } else if (preference.get_Adstyle().equalsIgnoreCase("ALT")) {
                    if (Constant.Alt_Cnt_Inter == 2) {
                        Constant.Alt_Cnt_Inter = 1;
                        Interstitial_Ads_Admob_Fb.ShowAd_Full(source_class, intent, flag);
                    } else {
                        Constant.Alt_Cnt_Inter++;
                        Interstitial_Ads_Fb_Admob.ShowAd_FullFb(source_class, intent, flag);
                    }
                } else if (preference.get_Adstyle().equalsIgnoreCase("fb")) {
                    Interstitial_Ads_Facebook.ShowAd_Facebook(source_class, intent, flag);
                } else if (preference.get_Adstyle().equalsIgnoreCase("multiple")) {
                    Interstitial_Ads_Admob_Fb_Qureka_MultipleAds.ShowAd_Full(source_class, intent, flag);
                }
            } else {
                Log.e("time interval", "false");
                if (flag) {
                    source_class.startActivity(intent);
                    source_class.finish();
                } else {
                    source_class.startActivity(intent);
                }
            }
        } else {
            if (Constant.Front_Counter % Integer.parseInt(preference.get_Click_Count()) == 0) {
                if (preference.get_Adstyle().equalsIgnoreCase("Normal")) {
                    Interstitial_Ads_Admob_Fb.ShowAd_Full(source_class, intent, flag);
                } else if (preference.get_Adstyle().equalsIgnoreCase("ALT")) {
                    if (Constant.Alt_Cnt_Inter == 2) {
                        Constant.Alt_Cnt_Inter = 1;
                        Interstitial_Ads_Admob_Fb.ShowAd_Full(source_class, intent, flag);
                    } else {
                        Constant.Alt_Cnt_Inter++;
                        Interstitial_Ads_Fb_Admob.ShowAd_FullFb(source_class, intent, flag);
                    }
                } else if (preference.get_Adstyle().equalsIgnoreCase("fb")) {
                    Interstitial_Ads_Facebook.ShowAd_Facebook(source_class, intent, flag);
                } else if (preference.get_Adstyle().equalsIgnoreCase("multiple")) {
                    Interstitial_Ads_Admob_Fb_Qureka_MultipleAds.ShowAd_Full(source_class, intent, flag);
                }
            } else {
                Constant.Front_Counter++;
                if (flag) {
                    source_class.startActivity(intent);
                    source_class.finish();
                } else {
                    source_class.startActivity(intent);
                }
            }

        }
    }

}
