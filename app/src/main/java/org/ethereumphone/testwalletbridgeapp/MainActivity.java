package org.ethereumphone.testwalletbridgeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclickNode(View view) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        startService();
    }

    public void onClickDestroy(View view) {
        stopService();
    }

    public void startService() throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException {
        //Create Keystore file for secure comm


        Intent serviceIntent = new Intent(this, BridgeService.class);
        serviceIntent.putExtra("inputExtra", "Bridge running in background");
        ContextCompat.startForegroundService(this, serviceIntent);
    }
    public void stopService() {
        Intent serviceIntent = new Intent(this, BridgeService.class);
        stopService(serviceIntent);
    }
}