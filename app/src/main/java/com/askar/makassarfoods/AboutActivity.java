package com.askar.makassarfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

    }

    public void clickIntentEmail(View view) {
        String []email = {"mhmmdaskar11@gmail.com"};
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "Assalamualaikum Askar");
        i.putExtra(Intent.EXTRA_EMAIL, email);
        startActivity(i);
    }
}
