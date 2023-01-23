package com.elision.infotech.elisionsdk;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class Interstitial_Ads_Splash {
    private InterstitialAd mInterstitialAd_admob;

    public void Show_Ads(Activity source_class, Intent intent, final boolean flag) {
        AppPreference preference = new AppPreference(source_class);
        if (preference.get_Ad_Status().equalsIgnoreCase("on") && preference.isConnected()) {
            AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(source_class, preference.get_Splash_Interstitial_Id(), adRequest, new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                    mInterstitialAd_admob = interstitialAd;
                    mInterstitialAd_admob.show(source_class);
                    mInterstitialAd_admob.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                            super.onAdFailedToShowFullScreenContent(adError);
                            mInterstitialAd_admob = null;
                            if (flag) {
                                source_class.startActivity(intent);
                                source_class.finish();
                            } else {
                                source_class.startActivity(intent);
                            }
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            super.onAdShowedFullScreenContent();
                            mInterstitialAd_admob = null;
                        }

                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            if (flag) {
                                source_class.startActivity(intent);
                                source_class.finish();
                            } else {
                                source_class.startActivity(intent);
                            }
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
                    if (flag) {
                        source_class.startActivity(intent);
                        source_class.finish();
                    } else {
                        source_class.startActivity(intent);
                    }
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
