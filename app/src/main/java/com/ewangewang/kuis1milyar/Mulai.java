package com.ewangewang.kuis1milyar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Random;

import static android.view.Window.FEATURE_NO_TITLE;

public class Mulai extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    Button Pilihan_1,Pilihan_2,Pilihan_3,Pilihan_4;
    TextView Uang,Soal;

    private Questions mQuestions = new Questions();
    private String mAnswer;
    private int mScore = 0;
    private String nomUang="0";
    private int mQuestionsLength = mQuestions.mQuestion.length;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulai);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        final MediaPlayer benarSound = MediaPlayer.create(this,R.raw.suarabenar);
        final MediaPlayer salahSound = MediaPlayer.create(this,R.raw.suarasalah);
        Button back = findViewById(R.id.kembali);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd.setAdListener(new AdListener()
                                                  {
                                                      @Override
                                                      public void onAdClosed() {
                                                          Intent intent = new Intent(Mulai.this,MainActivity.class);
                                                          startActivity(intent);
                                                      }
                                                  }
                    );

                }
                else{
                    Intent intent = new Intent(Mulai.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        Pilihan_1 = (Button) findViewById(R.id.pilihan_1);
        Pilihan_2 = (Button) findViewById(R.id.pilihan_2);
        Pilihan_3 = (Button) findViewById(R.id.pilihan_3);
        Pilihan_4 = (Button) findViewById(R.id.pilihan_4);
        Uang = (TextView) findViewById(R.id.uang);
        Soal = (TextView) findViewById(R.id.pertanyaan);

        r = new Random();
        updateQuestion(r.nextInt(mQuestionsLength));

        Pilihan_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Pilihan_1.getText() == mAnswer){
                    benarSound.start();
                    Pilihan_1.setBackgroundResource(R.drawable.benar);
                    mScore+=1;
                    scUang(mScore);
                    Uang.setText("Uang Anda : Rp."+nomUang);
                    if(mScore>=30){
                        Intent intent = new Intent(Mulai.this,Menang.class);
                        startActivity(intent);
                    }
                    lanjut();
                }
                else{
                    salahSound.start();
                    Pilihan_1.setBackgroundResource(R.drawable.salah);
                    gameOver();
                }
            }
        });
        Pilihan_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Pilihan_2.getText() == mAnswer){
                    benarSound.start();
                    Pilihan_2.setBackgroundResource(R.drawable.benar);
                    mScore+=1;
                    scUang(mScore);
                    Uang.setText("Uang Anda : Rp."+nomUang);
                    if(mScore>=30){
                        Intent intent = new Intent(Mulai.this,Menang.class);
                        startActivity(intent);
                    }
                    lanjut();

                }
                else{
                    salahSound.start();
                    Pilihan_2.setBackgroundResource(R.drawable.salah);
                    gameOver();
                }
            }
        });
        Pilihan_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Pilihan_3.getText() == mAnswer){
                    benarSound.start();
                    Pilihan_3.setBackgroundResource(R.drawable.benar);
                    mScore+=1;
                    scUang(mScore);
                    Uang.setText("Uang Anda : Rp."+nomUang);
                    if(mScore>=30){
                        Intent intent = new Intent(Mulai.this,Menang.class);
                        startActivity(intent);
                    }
                    lanjut();

                }
                else{
                    salahSound.start();
                    Pilihan_3.setBackgroundResource(R.drawable.salah);
                    gameOver();
                }
            }
        });
        Pilihan_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Pilihan_4.getText() == mAnswer){
                    benarSound.start();
                    Pilihan_4.setBackgroundResource(R.drawable.benar);
                    mScore+=1;
                    scUang(mScore);
                    Uang.setText("Uang Anda : Rp."+nomUang);
                    if(mScore>=30){
                        Intent intent = new Intent(Mulai.this,Menang.class);
                        startActivity(intent);
                    }
                    lanjut();
                }
                else{
                    salahSound.start();
                    Pilihan_4.setBackgroundResource(R.drawable.salah);
                    gameOver();
                }
            }
        });
    }
    private void lanjut(){
        CountDownTimer countDownTimer = new CountDownTimer(2000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                Pilihan_1.setEnabled(false);
                Pilihan_2.setEnabled(false);
                Pilihan_3.setEnabled(false);
                Pilihan_4.setEnabled(false);
            }
            @Override
            public void onFinish() {
                updateQuestion(r.nextInt(mQuestionsLength));
                Pilihan_1.setBackgroundResource(R.drawable.pilihan);
                Pilihan_2.setBackgroundResource(R.drawable.pilihan);
                Pilihan_3.setBackgroundResource(R.drawable.pilihan);
                Pilihan_4.setBackgroundResource(R.drawable.pilihan);
                Pilihan_1.setEnabled(true);
                Pilihan_2.setEnabled(true);
                Pilihan_3.setEnabled(true);
                Pilihan_4.setEnabled(true);

            }
        }.start();
    }
    private void scUang(int x){
        switch (x){
            case 1:nomUang="500";break;
            case 2:nomUang="1.000";break;
            case 3:nomUang="2.500";break;
            case 4:nomUang="5.000";break;
            case 5:nomUang="10.000";break;
            case 6:nomUang="15.000";break;
            case 7:nomUang="25.000";break;
            case 8:nomUang="50.000";break;
            case 9:nomUang="75.000";break;
            case 10:nomUang="100.000";break;
            case 11:nomUang="125.000";break;
            case 12:nomUang="175.000";break;
            case 13:nomUang="250.000";break;
            case 14:nomUang="500.000";break;
            case 15:nomUang="750.000";break;
            case 16:nomUang="1.000.000";break;
            case 17:nomUang="2.500.000";break;
            case 18:nomUang="5.000.000";break;
            case 19:nomUang="7.500.000";break;
            case 20:nomUang="10.000.000";break;
            case 21:nomUang="15.000.000";break;
            case 22:nomUang="25.000.000";break;
            case 23:nomUang="50.000.000";break;
            case 24:nomUang="75.000.000";break;
            case 25:nomUang="100.000.000";break;
            case 26:nomUang="150.000.000";break;
            case 27:nomUang="250.000.000";break;
            case 28:nomUang="500.000.000";break;
            case 29:nomUang="750.000.000";break;
            case 30:nomUang="1.000.000.000";break;
        }
    }
    private void updateQuestion(int num){
        Soal.setText(mQuestions.getQuestion(num));
        Pilihan_1.setText(mQuestions.getChoice1(num));
        Pilihan_2.setText(mQuestions.getChoice2(num));
        Pilihan_3.setText(mQuestions.getChoice3(num));
        Pilihan_4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrectAnswer(num);
    }
    private void gameOver(){
        final Dialog dialog = new Dialog(Mulai.this);
        dialog.setContentView(R.layout.dialog_layout);
        dialog.setCancelable(false);
        TextView hasikakhir = dialog.findViewById(R.id.hasil);
        hasikakhir.setText("Uang Yang Anda Bawa Pulang Senilai Rp."+nomUang);
        dialog.show();
        Button ulang = dialog.findViewById(R.id.ulang);
        Button kembali = dialog.findViewById(R.id.kembali);
        Button rateapp = dialog.findViewById(R.id.rate);
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

                }
                else{
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
                                                          Intent intentul = new Intent(Mulai.this,Mulai.class);
                                                          dialog.dismiss();
                                                          startActivity(intentul);
                                                      }
                                                  }
                    );

                }
                else{
                    Intent intentul = new Intent(Mulai.this,Mulai.class);
                    dialog.dismiss();
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
                                                          Intent intentkem = new Intent(Mulai.this,MainActivity.class);
                                                          dialog.dismiss();
                                                          startActivity(intentkem);
                                                      }
                                                  }
                    );
                }else{
                    Intent intentkem = new Intent(Mulai.this,MainActivity.class);
                    dialog.dismiss();
                    startActivity(intentkem);
                }
            }
        });

    }
}
