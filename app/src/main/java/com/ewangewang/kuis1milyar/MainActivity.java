package com.ewangewang.kuis1milyar;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    Button mulai,tentang,privacypolicy,bintang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mulai = findViewById(R.id.mulai_btn);
        tentang = findViewById(R.id.tentang);
        privacypolicy = findViewById(R.id.privacypolicy);
        bintang = findViewById(R.id.bintang);

        bintang.setOnClickListener(new View.OnClickListener() {
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
        privacypolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd.setAdListener(new AdListener()
                                                  {
                                                      @Override
                                                      public void onAdClosed() {
                                                          Intent intent_privacy = new Intent(MainActivity.this,PrivacyPolicy.class);
                                                          startActivity(intent_privacy);
                                                      }
                                                  }
                    );

                }else {
                    Intent intent_privacy = new Intent(MainActivity.this,PrivacyPolicy.class);
                    startActivity(intent_privacy);
                }
            }
        });
        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd.setAdListener(new AdListener()
                                                  {
                                                      @Override
                                                      public void onAdClosed() {
                                                          Intent intent_tentang = new Intent(MainActivity.this,Tentang.class);
                                                          startActivity(intent_tentang);
                                                      }
                                                  }
                    );

                }else {
                    Intent intent_tentang = new Intent(MainActivity.this,Tentang.class);
                    startActivity(intent_tentang);
                }
            }
        });
        mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd.setAdListener(new AdListener()
                                                  {
                                                      @Override
                                                      public void onAdClosed() {
                                                          Intent intent_mulai = new Intent(MainActivity.this,Mulai.class);
                                                          startActivity(intent_mulai);
                                                      }
                                                  }
                    );

                }else {
                    Intent intent_mulai = new Intent(MainActivity.this,Mulai.class);
                    startActivity(intent_mulai);
                }
            }
        });
    }
}
