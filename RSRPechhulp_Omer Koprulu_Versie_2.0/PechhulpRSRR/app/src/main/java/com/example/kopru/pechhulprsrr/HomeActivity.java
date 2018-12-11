/*
This application is a given assignment by DTD Amsterdam and made by Omer Koprulu.
The goal of this test is to create a replica of the live version RSRPechhulp.

In this class the Home activity is created where the main methods are created to make connection
with other activities and make objects functional.
 */

package com.example.kopru.pechhulprsrr;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.kopru.pechhulprsrr.R;
import com.example.kopru.pechhulprsrr.InfoActivity;
import com.example.kopru.pechhulprsrr.MapActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.awt.font.TextAttribute;

public class HomeActivity extends AppCompatActivity {

    //Creating Variables
    Toolbar toolbar1;
    private static final String TAG = "MapActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_rsr);

        //Check services
        if (isServicesOK()) {
            init();
        }

        //Customizing the Toolbar
        toolbar1 = (Toolbar) findViewById(R.id.toolbar);
        toolbar1.setTitle("RSR Revalidatieservice");
        toolbar1.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar1);

        //Creating objects and reference these tho the related ID
        Button toInfoBtn = (Button) findViewById(R.id.toInfoButton);    //Tablet
        ImageButton toInfoImg = (ImageButton) findViewById(R.id.toInfoImage); //Tablet
        ImageView emergencyLogo = (ImageView) findViewById(R.id.emergencyLogo);
        Button btnMap = (Button) findViewById(R.id.toMapButton);

        //Establish a connection with and intent to go to the InfoAtivity)
        toInfoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), InfoActivity.class);
                startActivity(startIntent);
            }
        });

        //Establish a connection with and intent to go to the InfoAtivity)
        toInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), InfoActivity.class);
                startActivity(startIntent);
            }
        });

        //Establish a connection with and intent to go to the InfoActivity
        toInfoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), InfoActivity.class);
                startActivity(startIntent);
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
    }

    /*
    Method to establish a connection to the MapActivity
    */
    private void init() {
        Button btnMap = (Button) findViewById(R.id.toMapButton);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
    }
    /*
    Method to check the version of the Google Services
    */
    public boolean isServicesOK() {
        Log.d(TAG, "IsServiceOK: Checking google services version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(
                HomeActivity.this);
        if (available == ConnectionResult.SUCCESS) {
            //Case if there are no errors. User can make a request.
            Log.d(TAG, "isServiceOk: Google play services werkt juist");
            return true;
        } else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            // Case if there is obtained an error. But it can be fixed
            Log.d(TAG, "isServiceOk: Error gedecteerd, maar kan opgelost worden");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(HomeActivity.
                    this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        } else {
            //Case if there is obtained an error. User can not make a request.
            Toast.makeText(this, "We kunnen geen map request maken", Toast.LENGTH_SHORT)
                    .show();
        }
        return false;
    }
}
