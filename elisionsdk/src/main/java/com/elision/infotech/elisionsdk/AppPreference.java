package com.elision.infotech.elisionsdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class AppPreference {

    public String USER_PREFS = "USER PREFS";
    public Editor prefEditor;
    public SharedPreferences appSharedPref;

    String Base_Url = "Base_Url";

    String Ad_Status = "Ad_Status";
    String Adstyle = "Adstyle";
    String Ad_Flag = "Ad_Flag";
    String Qureka_Flag = "Qureka_Flag";
    String Slider_Qureka = "Slider_Qureka";
    String Reward_Counter = "Reward_Counter";
    String Click_Flag = "Click_Flag";
    String Click_Count = "Click_Count";

    String Qureka_Link = "Qureka_Link";
    String Ad_Time_Interval = "Ad_Time_Interval";
    String Account = "Account";
    String Privacy_Policy = "Privacy_Policy";

    String Splash_Interstitial_Id = "Splash_Interstitial_Id";

    String Admob_Interstitial_Id1 = "Admob_Interstitial_Id1";
    String Admob_Interstitial_Id2 = "Admob_Interstitial_Id2";
    String Admob_Interstitial_Id3 = "Admob_Interstitial_Id3";
    String Admob_Native_Id1 = "Admob_Native_Id1";
    String Admob_Native_Id2 = "Admob_Native_Id2";
    String Admob_Native_Id3 = "Admob_Native_Id3";
    String Admob_Banner_Id1 = "Admob_Banner_Id1";
    String Admob_Banner_Id2 = "Admob_Banner_Id2";
    String Admob_Banner_Id3 = "Admob_Banner_Id3";
    String Admob_OpenApp_Id1 = "Admob_OpenApp_Id1";
    String Admob_OpenApp_Id2 = "Admob_OpenApp_Id2";
    String Admob_OpenApp_Id3 = "Admob_OpenApp_Id3";
    String Admob_Rewarded_Id = "Admob_Rewarded_Id";

    String Facebook_Interstitial = "Facebook_Interstitial";
    String Facebook_Native = "Facebook_Native";
    String Facebook_Banner = "Facebook_Banner";
    String adbtcolor = "Adbtcolor";
    Context contexts;

    String splash_flag = "splash_flag";
    String Splash_OpenApp_Id = "Splash_OpenApp_Id";
    String textColor = "textColor";
    String backColor = "backColor";
    String backflag = "backflag";
    String backclick = "backclick";
    String native_type_list = "native_type_list";
    String native_type_othe = "native_type_othe";
    public static boolean isFullScreenShow = false;

    public AppPreference(Context context) {
        this.appSharedPref = context.getSharedPreferences(this.USER_PREFS, 0);
        this.prefEditor = this.appSharedPref.edit();
        contexts = context;
    }

    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) contexts.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }

    public String get_splash_flag() {
        return this.appSharedPref.getString(this.splash_flag, "");
    }

    public void set_splash_flag(String str) {
        this.prefEditor.putString(this.splash_flag, str).commit();
    }

    public String get_Splash_OpenApp_Id() {
        return this.appSharedPref.getString(this.Splash_OpenApp_Id, "");
    }

    public void set_Splash_OpenApp_Id(String str) {
        this.prefEditor.putString(this.Splash_OpenApp_Id, str).commit();
    }

    public void StoreAllDataFromJSON(String response) throws JSONException {
        JSONObject object = new JSONObject(response);
        JSONArray jsonArray = new JSONArray(new JSONObject(object.getString("json_data")).getString("Data"));
        set_Ad_Flag(jsonArray.getJSONObject(0).optString("Adflag"));
        set_Ad_Time_Interval(jsonArray.getJSONObject(0).optString("Adtime"));
        set_Adstyle(jsonArray.getJSONObject(0).optString("Adstyle"));
        set_Ad_Status(jsonArray.getJSONObject(0).optString("Adstatus"));
        set_Account(jsonArray.getJSONObject(0).optString("account"));
        set_Privacy_Policy(jsonArray.getJSONObject(0).optString("pp"));
        set_Qureka_Flag(jsonArray.getJSONObject(0).optString("qureka"));
        set_Qureka_Link(jsonArray.getJSONObject(0).optString("qureka-link"));
        set_Splash_Interstitial_Id(jsonArray.getJSONObject(0).optString("admob-splash"));
        set_Admob_Interstitial_Id1(jsonArray.getJSONObject(0).optString("admob-full1"));
        set_Admob_Interstitial_Id2(jsonArray.getJSONObject(0).optString("admob-full2"));
        set_Admob_Interstitial_Id3(jsonArray.getJSONObject(0).optString("admob-full3"));
        set_Admob_Native_Id1(jsonArray.getJSONObject(0).optString("admob-native1"));
        set_Admob_Native_Id2(jsonArray.getJSONObject(0).optString("admob-native2"));
        set_Admob_Native_Id3(jsonArray.getJSONObject(0).optString("admob-native3"));
        set_Admob_Banner_Id1(jsonArray.getJSONObject(0).optString("admob-banner1"));
        set_Admob_Banner_Id2(jsonArray.getJSONObject(0).optString("admob-banner2"));
        set_Admob_Banner_Id3(jsonArray.getJSONObject(0).optString("admob-banner3"));
        set_Admob_OpenApp_Id1(jsonArray.getJSONObject(0).optString("admob-open1"));
        set_Admob_OpenApp_Id2(jsonArray.getJSONObject(0).optString("admob-open2"));
        set_Admob_OpenApp_Id3(jsonArray.getJSONObject(0).optString("admob-open3"));
        set_Click_Flag(jsonArray.getJSONObject(0).optString("clickflag"));
        set_Click_Count(jsonArray.getJSONObject(0).optString("click"));
        set_Splash_OpenApp_Id(jsonArray.getJSONObject(0).optString("admob-splash-open"));
        set_splash_flag(jsonArray.getJSONObject(0).optString("splash"));
        set_Facebook_Interstitial(jsonArray.getJSONObject(0).optString("fb-full"));
        set_Facebook_Native(jsonArray.getJSONObject(0).optString("fb-native"));
        set_Facebook_Banner(jsonArray.getJSONObject(0).optString("fb-banner"));
        setAdbtcolor(jsonArray.getJSONObject(0).optString("adbtclr"));
        setBackflag(jsonArray.getJSONObject(0).optString("backflag"));
        setBackclick(jsonArray.getJSONObject(0).optString("backclick"));
        setNativeTypeList(jsonArray.getJSONObject(0).optString("native_type_list"));
        setNativeTypeOther(jsonArray.getJSONObject(0).optString("native_type_other"));
        setBackcolor(jsonArray.getJSONObject(0).optString("backcolor", "ffffff"));
        setTextColor(jsonArray.getJSONObject(0).optString("textcolor", "000000"));
    }

    public String getBackflag() {
        return this.appSharedPref.getString(this.backflag, "");
    }

    public void setBackflag(String backflag) {
        this.prefEditor.putString(this.backflag, backflag).commit();
    }

    public String getBackclick() {
        return this.appSharedPref.getString(this.backclick, "");
    }

    public void setBackclick(String backclick) {
        this.prefEditor.putString(this.backclick, backclick).commit();
    }

    public void setNativeTypeOther(String type) {
        this.prefEditor.putString(this.native_type_othe, type).commit();
    }

    public String getNativeTypeList() {
        return this.appSharedPref.getString(this.native_type_list, "");
    }

    public void setNativeTypeList(String type) {
        this.prefEditor.putString(this.native_type_list, type).commit();
    }

    public String getNativeTypeOther() {
        return this.appSharedPref.getString(this.native_type_othe, "");
    }

    public String getBackColor() {
        return this.appSharedPref.getString(this.backColor, "");
    }

    public void setBackcolor(String str) {
        this.prefEditor.putString(this.backColor, str).commit();
    }

    public String getTextColor() {
        return this.appSharedPref.getString(this.textColor, "");
    }

    public void setTextColor(String str) {
        this.prefEditor.putString(this.textColor, str).commit();
    }

    public String get_Base_Url() {
        return this.appSharedPref.getString(this.Base_Url, "");
    }

    public void set_Base_Url(String str) {
        this.prefEditor.putString(this.Base_Url, str).commit();
    }

    public String get_Click_Flag() {
        return this.appSharedPref.getString(this.Click_Flag, "");
    }

    public void set_Click_Flag(String str) {
        this.prefEditor.putString(this.Click_Flag, str).commit();
    }

    public String get_Click_Count() {
        return this.appSharedPref.getString(this.Click_Count, "");
    }

    public void set_Click_Count(String str) {
        this.prefEditor.putString(this.Click_Count, str).commit();
    }

    public String get_Admob_Rewarded_Id() {
        return this.appSharedPref.getString(this.Admob_Rewarded_Id, "");
    }

    public void set_Admob_Rewarded_Id(String str) {
        this.prefEditor.putString(this.Admob_Rewarded_Id, str).commit();
    }

    public String get_Ad_Status() {
        return this.appSharedPref.getString(this.Ad_Status, "");
    }

    public void set_Ad_Status(String str) {
        this.prefEditor.putString(this.Ad_Status, str).commit();
    }

    public String get_Adstyle() {
        return this.appSharedPref.getString(this.Adstyle, "");
    }

    public void set_Adstyle(String str) {
        this.prefEditor.putString(this.Adstyle, str).commit();
    }

    public String get_Slider_Qureka() {
        return this.appSharedPref.getString(this.Slider_Qureka, "");
    }

    public void set_Slider_Qureka(String str) {
        this.prefEditor.putString(this.Slider_Qureka, str).commit();
    }

    public String get_Qureka_Flag() {
        return this.appSharedPref.getString(this.Qureka_Flag, "");
    }

    public void set_Qureka_Flag(String str) {
        this.prefEditor.putString(this.Qureka_Flag, str).commit();
    }

    public String get_Ad_Flag() {
        return this.appSharedPref.getString(this.Ad_Flag, "");
    }

    public void set_Ad_Flag(String str) {
        this.prefEditor.putString(this.Ad_Flag, str).commit();
    }

    public String get_Reward_Counter() {
        return this.appSharedPref.getString(this.Reward_Counter, "");
    }

    public void set_Reward_Counter(String str) {
        this.prefEditor.putString(this.Reward_Counter, str).commit();
    }

    public String get_Ad_Time_Interval() {
        return this.appSharedPref.getString(this.Ad_Time_Interval, "");
    }

    public void set_Ad_Time_Interval(String str) {
        this.prefEditor.putString(this.Ad_Time_Interval, str).commit();
    }

    public String get_Qureka_Link() {
        return this.appSharedPref.getString(this.Qureka_Link, "");
    }

    public void set_Qureka_Link(String str) {
        this.prefEditor.putString(this.Qureka_Link, str).commit();
    }

    public String get_Account() {
        return this.appSharedPref.getString(this.Account, "");
    }

    public void set_Account(String str) {
        this.prefEditor.putString(this.Account, str).commit();
    }

    public String get_Privacy_Policy() {
        return this.appSharedPref.getString(this.Privacy_Policy, "");
    }

    public void set_Privacy_Policy(String str) {
        this.prefEditor.putString(this.Privacy_Policy, str).commit();
    }

    public String get_Splash_Interstitial_Id() {
        return this.appSharedPref.getString(this.Splash_Interstitial_Id, "");
    }

    public void set_Splash_Interstitial_Id(String str) {
        this.prefEditor.putString(this.Splash_Interstitial_Id, str).commit();
    }

    public String get_Admob_Interstitial_Id1() {
        return this.appSharedPref.getString(this.Admob_Interstitial_Id1, "");
    }

    public void set_Admob_Interstitial_Id1(String str) {
        this.prefEditor.putString(this.Admob_Interstitial_Id1, str).commit();
    }

    public String get_Admob_Interstitial_Id2() {
        return this.appSharedPref.getString(this.Admob_Interstitial_Id2, "");
    }

    public void set_Admob_Interstitial_Id2(String str) {
        this.prefEditor.putString(this.Admob_Interstitial_Id2, str).commit();
    }

    public String get_Admob_Interstitial_Id3() {
        return this.appSharedPref.getString(this.Admob_Interstitial_Id3, "");
    }

    public void set_Admob_Interstitial_Id3(String str) {
        this.prefEditor.putString(this.Admob_Interstitial_Id3, str).commit();
    }

    public String get_Admob_Native_Id1() {
        return this.appSharedPref.getString(this.Admob_Native_Id1, "");
    }

    public void set_Admob_Native_Id1(String str) {
        this.prefEditor.putString(this.Admob_Native_Id1, str).commit();
    }

    public String get_Admob_Native_Id2() {
        return this.appSharedPref.getString(this.Admob_Native_Id2, "");
    }

    public void set_Admob_Native_Id2(String str) {
        this.prefEditor.putString(this.Admob_Native_Id2, str).commit();
    }

    public String get_Admob_Native_Id3() {
        return this.appSharedPref.getString(this.Admob_Native_Id3, "");
    }

    public void set_Admob_Native_Id3(String str) {
        this.prefEditor.putString(this.Admob_Native_Id3, str).commit();
    }

    public String get_Admob_Banner_Id1() {
        return this.appSharedPref.getString(this.Admob_Banner_Id1, "");
    }

    public void set_Admob_Banner_Id1(String str) {
        this.prefEditor.putString(this.Admob_Banner_Id1, str).commit();
    }

    public String get_Admob_Banner_Id2() {
        return this.appSharedPref.getString(this.Admob_Banner_Id2, "");
    }

    public void set_Admob_Banner_Id2(String str) {
        this.prefEditor.putString(this.Admob_Banner_Id2, str).commit();
    }

    public String get_Admob_Banner_Id3() {
        return this.appSharedPref.getString(this.Admob_Banner_Id3, "");
    }

    public void set_Admob_Banner_Id3(String str) {
        this.prefEditor.putString(this.Admob_Banner_Id3, str).commit();
    }

    public String get_Admob_OpenApp_Id1() {
        return this.appSharedPref.getString(this.Admob_OpenApp_Id1, "");
    }

    public void set_Admob_OpenApp_Id1(String str) {
        this.prefEditor.putString(this.Admob_OpenApp_Id1, str).commit();
    }

    public String get_Admob_OpenApp_Id2() {
        return this.appSharedPref.getString(this.Admob_OpenApp_Id2, "");
    }

    public void set_Admob_OpenApp_Id2(String str) {
        this.prefEditor.putString(this.Admob_OpenApp_Id2, str).commit();
    }

    public String get_Admob_OpenApp_Id3() {
        return this.appSharedPref.getString(this.Admob_OpenApp_Id3, "");
    }

    public void set_Admob_OpenApp_Id3(String str) {
        this.prefEditor.putString(this.Admob_OpenApp_Id3, str).commit();
    }
    /*public String get_Final_OpenApp_Id() {
        return get_Admob_OpenApp_Id();
    }*/

    public String get_Facebook_Interstitial() {
        return this.appSharedPref.getString(this.Facebook_Interstitial, "");
    }

    public void set_Facebook_Interstitial(String str) {
        this.prefEditor.putString(this.Facebook_Interstitial, str).commit();
    }

    public String get_Facebook_Native() {
        return this.appSharedPref.getString(this.Facebook_Native, "");
    }

    public void set_Facebook_Native(String str) {
        this.prefEditor.putString(this.Facebook_Native, str).commit();
    }

    public String get_Facebook_Banner() {
        return this.appSharedPref.getString(this.Facebook_Banner, "");
    }

    public void set_Facebook_Banner(String str) {
        this.prefEditor.putString(this.Facebook_Banner, str).commit();
    }

    public String getAdbtcolor() {
        return this.appSharedPref.getString(this.adbtcolor, "");
    }

    public void setAdbtcolor(String str) {
        this.prefEditor.putString(this.adbtcolor, str).commit();
    }
}