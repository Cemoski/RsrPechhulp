package com.example.kopru.pechhulprsrr;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {

    //Variabelen aanmaken
    Toolbar toolbar1;
    private static final String TAG = "MapActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Check services
        if (isServicesOK()) {
            init();
        }

        //Toolbar customizen
        toolbar1 = (Toolbar) findViewById(R.id.toolbar);
        toolbar1.setTitle("RSR Revalidatieservice");
        toolbar1.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar1);


        //Maken van objecten en deze refereren naar de desbetreffende ID
        Button toMapBtn = (Button) findViewById(R.id.toMapButton);
        ImageView emergencyBTN = (ImageView) findViewById(R.id.emergencyButton);
        ImageButton infoBtn = (ImageButton) findViewById(R.id.infoButton);


        //Maken van een connectie met een intent naar de infoActivity'.
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), InfoActivity.class);
                startActivity(startIntent);
            }


        });
//        //Maken van een connectie met een intent naar de info pagina 'Map'.
//        emergencyBTN.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent startIntent = new Intent(getApplicationContext(), Map.class);
//                startActivity(startIntent);
//            }
//
//        });
//
//        //Maken van een connectie naar de pechhulp pagina 'Map'.
//        toMapBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent startIntent = new Intent(getApplicationContext(), Map.class);
//                startActivity(startIntent);
//            }
//
//        });
    }
    //Methode om naar de Map te gaan
    private void init() {
        Button btnMap = (Button) findViewById(R.id.toMapButton);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Map.class);
                startActivity(intent);
            }
        });
    }


    // Methode om de versie van de Google Services na te gaan.
    public boolean isServicesOK() {
        Log.d(TAG, "IsServiceOK: Checking google services version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
        if (available == ConnectionResult.SUCCESS) {
            //Geen error gedecteerd User kan map request maken
            Log.d(TAG, "isServiceOk: Google play services werkt juist");
            return true;
        } else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            // Error gedecteerd, maar is op te lossen
            Log.d(TAG, "isServiceOk: Error gedecteerd, maar kan opgelost worden");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        } else {
            //Error gedecteerd, maar is niet op te lossen
            Toast.makeText(this, "We kunnen geen map request maken", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
