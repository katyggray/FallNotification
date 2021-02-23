package edu.ucdenver.fallnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onViewSessions(View view) {
        Intent intentViewSessions = new Intent(this, ViewSessions.class);
        startActivity(intentViewSessions);
    }

    public void onViewPatients(View view) {
        Intent intentViewPatients = new Intent(this, ViewPatients.class);
        startActivity(intentViewPatients);
    }

    public void onSetUpSession(View view) {
        Intent intentSetUpSession = new Intent(this, SetUpSession.class);
        startActivity(intentSetUpSession);
    }
}