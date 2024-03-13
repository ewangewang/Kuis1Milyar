package com.ewangewang.kuis1milyar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class Menang extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menang);
        Button ulang = findViewById(R.id.ulang);
        Button kembali = findViewById(R.id.kembali);
        Button rateapp = findViewById(R.id.rate);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        rateapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd.setAdListener(new AdListener()
                                                  {
                                                      @Override
                                                      public void onAdClosed() {
                                                          try {
                                                              startActivity(new Intent(Intent.ACTION_VIEW,
                                                                      Uri.parse("market://details?id" + getPackageName())));
                                                          }catch (ActivityNotFoundException e){
                                                              startActivity(new Intent(Intent.ACTION_VIEW,
                                                                      Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                                                          };
                                                      }
                                                  }
                    );

                }else{
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("market://details?id" + getPackageName())));
                    }catch (ActivityNotFoundException e){
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                    };
                }

            }
        });
        ulang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd.setAdListener(new AdListener()
                                                  {
                                                      @Override
                                                      public void onAdClosed() {
                                                          Intent intentul = new Intent(Menang.this,Mulai.class);
                                                          startActivity(intentul);
                                                      }
                                                  }
                    );
                }else{
                    Intent intentul = new Intent(Menang.this,Mulai.class);
                    startActivity(intentul);
                }

            }
        });
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd.setAdListener(new AdListener()
                                                  {
                                                      @Override
                                                      public void onAdClosed() {
                                                          Intent intentkem = new Intent(Menang.this,MainActivity.class);
                                                          startActivity(intentkem);
                                                      }
                                                  }
                    );

                }else{
                    Intent intentkem = new Intent(Menang.this,MainActivity.class);
                    startActivity(intentkem);
                }

            }
        });
    }
}
