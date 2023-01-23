package com.elision.infotech.elisionsdk;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Random;

public class Interstitial_Qureka_Predchamp {

    public static void Show_Qureka_Predchamp_Ads(Activity source_class, Intent intent, final boolean flag) {
        AppPreference preference = new AppPreference(source_class);
        if (preference.get_Ad_Status().equalsIgnoreCase("on")) {
            if (preference.get_Qureka_Flag().equalsIgnoreCase("qureka")) {
                final Dialog dialog = new Dialog(source_class, R.style.transparent_dialog);
                dialog.setContentView(R.layout.custome_interstitial);
                dialog.setCancelable(true);
                dialog.setCanceledOnTouchOutside(true);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                Random r = new Random();
                int i1 = r.nextInt(4 + 1);
                Glide.with(source_class).load(Constant.qureka_icon[i1]).into(((ImageView) dialog.findViewById(R.id.img_icon)));
                Glide.with(source_class).load(Constant.qureka_native[i1]).into(((ImageView) dialog.findViewById(R.id.img_banner)));
                ((TextView) dialog.findViewById(R.id.txt_main_title)).setText("Qureka Lite/Play Game");
                ((TextView) dialog.findViewById(R.id.txt_title)).setText(Constant.qureka_header[i1]);
                ((TextView) dialog.findViewById(R.id.txt_description)).setText(Constant.qureka_description[i1]);
                dialog.setOnDismissListener(dialog1 -> {
                    if (flag) {
                        source_class.startActivity(intent);
                        source_class.finish();
                    } else {
                        source_class.startActivity(intent);
                    }
                });
                dialog.findViewById(R.id.img_close).setOnClickListener(v -> dialog.dismiss());
                dialog.findViewById(R.id.btn_install).setOnClickListener(v -> Constant.Open_Qureka(source_class));
                dialog.show();
            } else if (preference.get_Qureka_Flag().equalsIgnoreCase("predchamp")) {
                final Dialog dialog = new Dialog(source_class, R.style.transparent_dialog);
                dialog.setContentView(R.layout.custome_interstitial);
                dialog.setCancelable(true);
                dialog.setCanceledOnTouchOutside(true);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                Random r = new Random();
                int i1 = r.nextInt(4 + 1);
                Glide.with(source_class).load(Constant.predchamp_icon[i1]).into(((ImageView) dialog.findViewById(R.id.img_icon)));
                Glide.with(source_class).load(Constant.predchamp_native[i1]).into(((ImageView) dialog.findViewById(R.id.img_banner)));
                ((TextView) dialog.findViewById(R.id.txt_main_title)).setText("Predchamp/Play Game");
                ((TextView) dialog.findViewById(R.id.txt_title)).setText(Constant.predchamp_header[i1]);
                ((TextView) dialog.findViewById(R.id.txt_description)).setText(Constant.predchamp_description[i1]);
                dialog.setOnDismissListener(dialog12 -> {
                    if (flag) {
                        source_class.startActivity(intent);
                        source_class.finish();
                    } else {
                        source_class.startActivity(intent);
                    }
                });
                dialog.findViewById(R.id.img_close).setOnClickListener(v -> dialog.dismiss());
                dialog.findViewById(R.id.btn_install).setOnClickListener(v -> Constant.Open_Qureka(source_class));
                dialog.show();
            } else {
                if (flag) {
                    source_class.startActivity(intent);
                    source_class.finish();
                } else {
                    source_class.startActivity(intent);
                }
            }
        } else {
            if (flag) {
                source_class.startActivity(intent);
                source_class.finish();
            } else {
                source_class.startActivity(intent);
            }
        }
    }

    public static void Show_Qureka_Predchamp_Ads(Activity source_class) {
        AppPreference preference = new AppPreference(source_class);
        if (preference.get_Ad_Status().equalsIgnoreCase("on")) {
            if (preference.get_Qureka_Flag().equalsIgnoreCase("qureka")) {
                Dialog dialog = new Dialog(source_class, R.style.transparent_dialog);
                dialog.setContentView(R.layout.custome_interstitial);
                dialog.setCancelable(true);
                dialog.setCanceledOnTouchOutside(true);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                Random r = new Random();
                int i1 = r.nextInt(4 + 1);
                Glide.with(source_class).load(Constant.qureka_icon[i1]).into(((ImageView) dialog.findViewById(R.id.img_icon)));
                Glide.with(source_class).load(Constant.qureka_native[i1]).into(((ImageView) dialog.findViewById(R.id.img_banner)));
                ((TextView) dialog.findViewById(R.id.txt_main_title)).setText("Qureka Lite/Play Game");
                ((TextView) dialog.findViewById(R.id.txt_title)).setText(Constant.qureka_header[i1]);
                ((TextView) dialog.findViewById(R.id.txt_description)).setText(Constant.qureka_description[i1]);
                dialog.setOnDismissListener(dialog12 -> {

                });
                dialog.findViewById(R.id.img_close).setOnClickListener(v -> dialog.dismiss());
                dialog.findViewById(R.id.btn_install).setOnClickListener(v -> Constant.Open_Qureka(source_class));
                dialog.show();
            } else if (preference.get_Qureka_Flag().equalsIgnoreCase("predchamp")) {
                Dialog dialog = new Dialog(source_class, R.style.transparent_dialog);
                dialog.setContentView(R.layout.custome_interstitial);
                dialog.setCancelable(true);
                dialog.setCanceledOnTouchOutside(true);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                Random r = new Random();
                int i1 = r.nextInt(4 + 1);
                Glide.with(source_class).load(Constant.predchamp_icon[i1]).into(((ImageView) dialog.findViewById(R.id.img_icon)));
                Glide.with(source_class).load(Constant.predchamp_native[i1]).into(((ImageView) dialog.findViewById(R.id.img_banner)));
                ((TextView) dialog.findViewById(R.id.txt_main_title)).setText("Predchamp/Play Game");
                ((TextView) dialog.findViewById(R.id.txt_title)).setText(Constant.predchamp_header[i1]);
                ((TextView) dialog.findViewById(R.id.txt_description)).setText(Constant.predchamp_description[i1]);
                dialog.setOnDismissListener(dialog1 -> {

                });
                dialog.findViewById(R.id.img_close).setOnClickListener(v -> dialog.dismiss());
                dialog.findViewById(R.id.btn_install).setOnClickListener(v -> Constant.Open_Qureka(source_class));
                dialog.show();
            }
        }

    }

}
