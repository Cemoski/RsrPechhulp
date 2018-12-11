package com.example.kopru.pechhulprsrr;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    //Variabelen
    Toolbar toolbar2;
    TextView infoAlinea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Code om je link clickable te maken in de textview
        infoAlinea = (TextView) findViewById(R.id.textView);
        infoAlinea.setMovementMethod(LinkMovementMethod.getInstance());

        //Toolbar customizen
        toolbar2 = (Toolbar) findViewById(R.id.toolbarSecond);
        toolbar2.setTitle("Over RSR");
        toolbar2.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar2);

        //Backbutton creeren naar de home activity in je toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


    }

    //Controle bij click op de backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
