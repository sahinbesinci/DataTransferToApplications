package com.example.sahin.DataTransferToApplications;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.example.sahin.loginwithinstagram.R;

/**
 * Created by sahin on 28.09.2016.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnW,btnL,btnT,btnF,btnG,btnWC,btnS,btnSC,btnTg,btnWunderList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        install_elements();

    }
    private void install_elements()
    {
        btnW = (Button) findViewById(R.id.btnWhatsapp);
        btnW.setOnClickListener(this);
        btnL = (Button) findViewById(R.id.btnLinkedin);
        btnL.setOnClickListener(this);
        btnT = (Button) findViewById(R.id.btnTwitter);
        btnT.setOnClickListener(this);
        btnF = (Button) findViewById(R.id.btnFacebook);
        btnF.setOnClickListener(this);
        btnG = (Button) findViewById(R.id.btnGooglePlus);
        btnG.setOnClickListener(this);
        btnWC = (Button) findViewById(R.id.btnWeChat);
        btnWC.setOnClickListener(this);
        btnS = (Button) findViewById(R.id.btnSms);
        btnS.setOnClickListener(this);
        btnSC = (Button) findViewById(R.id.btnSnapchat);
        btnSC.setOnClickListener(this);
        btnTg = (Button) findViewById(R.id.btnTelegram);
        btnTg.setOnClickListener(this);
        btnWunderList = (Button) findViewById(R.id.btnWunderList);
        btnWunderList.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");

        switch(v.getId()){
            case R.id.btnWhatsapp:
                sendIntent.setPackage("com.whatsapp");
                break;
            case R.id.btnLinkedin:
                sendIntent.setPackage("com.linkedin.android");
                break;
            case R.id.btnTwitter:
                sendIntent.setPackage("com.twitter.android");
                break;
            case R.id.btnFacebook:
                sendIntent.setPackage("com.facebook.katana");
                break;
            case R.id.btnGooglePlus:
                sendIntent.setPackage("com.google.android.apps.plus");
                break;
            case R.id.btnWeChat:
                sendIntent.setPackage("com.tencent.mm");
                break;
            case R.id.btnSms:
                sendIntent.setPackage("com.facebook.orca");    // --> varsayışan sms uygulaması
                //sendIntent.setPackage("com.android.mms");    //--> varsayılan sms uygulaması değil.
                break;
            case R.id.btnSnapchat:
                sendIntent.setPackage("com.snapchat.android");
                break;
            case R.id.btnTelegram:
                sendIntent.setPackage("org.telegram.messenger");
                break;
            case R.id.btnWunderList:
                sendIntent.setPackage("com.wunderkinder.wunderlistandroid");
                break;
        }

        try {

            startActivity(sendIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(),"Yüklü Değil.",Toast.LENGTH_SHORT).show();
        }
    }
}
