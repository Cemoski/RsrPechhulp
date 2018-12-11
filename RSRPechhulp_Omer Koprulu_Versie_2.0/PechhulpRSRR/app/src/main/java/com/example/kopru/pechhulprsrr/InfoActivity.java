/*
In this activity the textview is made clickable to a link. It also obtains methods for the buttons.
 */

package com.example.kopru.pechhulprsrr;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    //Creating variables
    Toolbar toolbar2;
    TextView infoAlinea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //Making your link clickable in the textview
        infoAlinea = (TextView) findViewById(R.id.textView);
        infoAlinea.setMovementMethod(LinkMovementMethod.getInstance());

        //Customizing Toolbar
        toolbar2 = (Toolbar) findViewById(R.id.toolbarSecond);
        toolbar2.setTitle("Over RSR");
        toolbar2.setTitleTextColor(Color.WHITE);
        toolbar2.setNavigationIcon(R.drawable.menu_arrow);

        setSupportActionBar(toolbar2);

        //Creating Backbutton in the toolbar to go to your homescreen
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    /*
    Checking if screen goes back by clicking the backbutton
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
