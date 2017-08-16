package com.dd.dd.salrycounter091;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //Parameters
    EditText etSalary;
    TextView tvCounter;
    TextView tvAddInfo;
    Button btnCounter;
    Button btnStop;

    private TextView mTextView;
    private TextView mTextView10;
    private TextView mTextView11;
    private TextView mTextView12;
    private TextView mTextView13;
    private TextView mTextView14;
    private TextView mTextView15;
    private TextView mTextView16;
    private TextView mTextView17;
    private TextView mTextView18;
    private TextView mTextView19;
    private TextView mTextView2;
    private TextView mTextView20;
    private TextView mTextView3;
    private TextView mTextView4;
    private TextView mTextView5;
    private TextView mTextView6;
    private TextView mTextView7;
    private TextView mTextView8;
    private TextView mTextView9;

    //реклама AdMod от Google
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------------------------------------------------------------
        //реклама AdMod от Google
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //------------------------------------------------------------

        initView();

        //findViewById 's
        btnCounter = (Button) findViewById(R.id.btnCounter);
        btnStop = (Button) findViewById(R.id.btnStop);
        etSalary = (EditText) findViewById(R.id.salary);
        tvCounter = (TextView) findViewById(R.id.counter);
        tvAddInfo = (TextView) findViewById(R.id.addInfo);

        btnStop.setVisibility(View.GONE);


        //Creating Thread
        final Thread[] t = new Thread[1];


        //setOnClickListener on Button Stop tvCounter
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Setting Visibility to buttons
                btnStop.setVisibility(View.GONE);
                btnCounter.setVisibility(View.VISIBLE);

                //Interrupt Thread
                t[0].interrupt();

            }

        });

        //setOnClickListener on Button Start tvCounter
        btnCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!TextUtils.isEmpty(etSalary.getText().toString())) {


                    //Setting Visibility to buttons
                    btnStop.setVisibility(View.VISIBLE);
                    btnCounter.setVisibility(View.GONE);

                    //Counting etSalary per second


                    t[0] = new Thread() {


                        @Override
                        public void run() {
                            try {

                                final DecimalFormat df = new DecimalFormat("0.00");
                                final DecimalFormat df2 = new DecimalFormat("###,###,###");
                                final String[] a = new String[1];
                                final int[] seconds = {0};

                                final float b = Float.parseFloat(etSalary.getText().toString()) / 30 / 24 / 60 / 60;

                                final float[] SalaryCounter = {b};

                                //additional information
//                            tvAddInfo(df2, b);

                                runOnUiThread(new Runnable() {
                                    public void run() {
                                        tvAddInfo.setText("Итого заработаешь:");
                                        mTextView.setText("тенге за 1 день");
                                        mTextView2.setText("тенге за  1 неделю");
                                        mTextView3.setText("тенге за  1 месяц");
                                        mTextView4.setText("тенге за  3 месяца");
                                        mTextView5.setText("тенге за  полгода");
                                        mTextView6.setText("тенге за  год");
                                        mTextView7.setText("тенге за  5 лет");
                                        mTextView8.setText("тенге за  10 лет");
                                        mTextView9.setText("тенге за  20 лет");
                                        mTextView10.setText("тенге за  30 лет");

                                        mTextView11.setText(df2.format(b * 60 * 60 * 24));
                                        mTextView12.setText(df2.format(b * 60 * 60 * 24 * 7));
                                        mTextView13.setText(df2.format(b * 60 * 60 * 24 * 30));
                                        mTextView14.setText(df2.format(b * 60 * 60 * 24 * 30 * 3));
                                        mTextView15.setText(df2.format(b * 60 * 60 * 24 * 30 * 6));
                                        mTextView16.setText(df2.format(b * 60 * 60 * 24 * 365));
                                        mTextView17.setText(df2.format(b * 60 * 60 * 24 * 365 * 5));
                                        mTextView18.setText(df2.format(b * 60 * 60 * 24 * 365 * 10));
                                        mTextView19.setText(df2.format(b * 60 * 60 * 24 * 365 * 20));
                                        mTextView20.setText(df2.format(b * 60 * 60 * 24 * 365 * 30));
                                    }
                                });
                                while (!isInterrupted()) {

                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {

                                            // update TextView here!

                                            a[0] = df.format(SalaryCounter[0]);
                                            tvCounter.setText("В течении\n" + seconds[0] + " секунд" + "\n ты заработал\n" + a[0] + " тенге");
                                            SalaryCounter[0] += b;
                                            seconds[0]++;

                                        }
                                    });
                                    Thread.sleep(1000);
                                }

                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    t[0].start();
                }
            }

        });
    }

    private void initView() {
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView2 = (TextView) findViewById(R.id.textView2);
        mTextView3 = (TextView) findViewById(R.id.textView3);
        mTextView4 = (TextView) findViewById(R.id.textView4);
        mTextView5 = (TextView) findViewById(R.id.textView5);
        mTextView6 = (TextView) findViewById(R.id.textView6);
        mTextView7 = (TextView) findViewById(R.id.textView7);
        mTextView8 = (TextView) findViewById(R.id.textView8);
        mTextView9 = (TextView) findViewById(R.id.textView9);
        mTextView10 = (TextView) findViewById(R.id.textView10);
        mTextView11 = (TextView) findViewById(R.id.textView11);
        mTextView12 = (TextView) findViewById(R.id.textView12);
        mTextView13 = (TextView) findViewById(R.id.textView13);
        mTextView14 = (TextView) findViewById(R.id.textView14);
        mTextView15 = (TextView) findViewById(R.id.textView15);
        mTextView16 = (TextView) findViewById(R.id.textView16);
        mTextView17 = (TextView) findViewById(R.id.textView17);
        mTextView18 = (TextView) findViewById(R.id.textView18);
        mTextView19 = (TextView) findViewById(R.id.textView19);
        mTextView20 = (TextView) findViewById(R.id.textView20);

    }


}
