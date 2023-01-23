package com.elision.infotech.elisionsdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.Arrays;
import java.util.List;

public class Interstitial_Ads_Admob_Fb {
    public static InterstitialAd mInterstitialAd_admob;

    public static void ShowAd_Full(Activity source_class, Intent intent, final boolean flag) {
        AppPreference preference = new AppPreference(source_class);
        if (preference.get_Ad_Status().equalsIgnoreCase("on")) {
            Constant.Front_Counter++;
            if (Constant.Front_Counter > 2) {
                Constant.Front_Counter = 0;
            }
            final CustomProgressDialog customProgressDialog = new CustomProgressDialog(source_class, "Showing Ad...");
            customProgressDialog.setCancelable(false);
            customProgressDialog.show();
            AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(source_class, new AppPreference(source_class).get_Admob_Interstitial_Id1(), adRequest, new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                    mInterstitialAd_admob = interstitialAd;
                    mInterstitialAd_admob.show(source_class);
                    mInterstitialAd_admob.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                            super.onAdFailedToShowFullScreenContent(adError);
                            mInterstitialAd_admob = null;
                            if (customProgressDialog.isShowing()) {
                                customProgressDialog.dismiss();
                            }
                            if (flag) {
                                source_class.startActivity(intent);
                                source_class.finish();
                            } else {
                                source_class.startActivity(intent);
                            }
                            Constant.IS_TIME_INTERVAL = false;
                            new Handler().postDelayed(() -> Constant.IS_TIME_INTERVAL = true, Long.parseLong(String.valueOf(preference.get_Ad_Time_Interval())) * 1000);
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            super.onAdShowedFullScreenContent();
                            mInterstitialAd_admob = null;
                        }

                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            if (customProgressDialog.isShowing()) {
                                customProgressDialog.dismiss();
                            }
                            if (flag) {
                                source_class.startActivity(intent);
                                source_class.finish();
                            } else {
                                source_class.startActivity(intent);
                            }
                            Constant.IS_TIME_INTERVAL = false;
                            new Handler().postDelayed(() -> Constant.IS_TIME_INTERVAL = true, Long.parseLong(String.valueOf(preference.get_Ad_Time_Interval())) * 1000);
                        }

                        @Override
                        public void onAdImpression() {
                            super.onAdImpression();
                        }
                    });
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    mInterstitialAd_admob = null;
                    com.facebook.ads.InterstitialAd fb_interstitial = new com.facebook.ads.InterstitialAd(source_class, preference.get_Facebook_Interstitial());
                    fb_interstitial.loadAd(
                            fb_interstitial.buildLoadAdConfig()
                                    .withAdListener(new InterstitialAdListener() {
                                        @Override
                                        public void onInterstitialDisplayed(Ad ad) {
                                        }

                                        @Override
                                        public void onInterstitialDismissed(Ad ad) {
                                            if (customProgressDialog.isShowing()) {
                                                customProgressDialog.dismiss();
                                            }
                                            if (flag) {
                                                source_class.startActivity(intent);
                                                source_class.finish();
                                            } else {
                                                source_class.startActivity(intent);
                                            }
                                            Constant.IS_TIME_INTERVAL = false;
                                            new Handler().postDelayed(() -> Constant.IS_TIME_INTERVAL = true, Long.parseLong(String.valueOf(preference.get_Ad_Time_Interval())) * 1000);
                                        }

                                        @Override
                                        public void onError(Ad ad, AdError adError) {
                                            Log.e("TAG", "onError: " + adError.getErrorCode());
                                            if (customProgressDialog.isShowing()) {
                                                customProgressDialog.dismiss();
                                            }
                                            Interstitial_Qureka_Predchamp.Show_Qureka_Predchamp_Ads(source_class, intent, flag);
                                            Constant.IS_TIME_INTERVAL = false;
                                            new Handler().postDelayed(() -> Constant.IS_TIME_INTERVAL = true, Long.parseLong(String.valueOf(preference.get_Ad_Time_Interval())) * 1000);
                                        }

                                        @Override
                                        public void onAdLoaded(Ad ad) {
                                            if (!fb_interstitial.isAdLoaded()) {
                                                return;
                                            }
                                            if (fb_interstitial.isAdInvalidated()) {
                                                return;
                                            }
                                            fb_interstitial.show();
                                        }

                                        @Override
                                        public void onAdClicked(Ad ad) {

                                        }

                                        @Override
                                        public void onLoggingImpression(Ad ad) {

                                        }
                                    })
                                    .build());
                }
            });
        } else {
            if (flag) {
                source_class.startActivity(intent);
                source_class.finish();
            } else {
                source_class.startActivity(intent);
            }
        }

    }
}
