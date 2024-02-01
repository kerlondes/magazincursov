package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
    }

    public void goToMain(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void goToProNas(View v){
        Intent intent = new Intent(this, ProNas.class);
        startActivity(intent);
    }
    public void goToYou(View v){
        goToUrl ( "https://www.youtube.com/@gosha_dudar/videos");
    }
    public void goToVk(View v){
        goToUrl ( "https://vk.com/codi999");
    }
    public void goToInsta(View v){
        goToUrl ( "http://instagram.com/gosha_dudar");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}