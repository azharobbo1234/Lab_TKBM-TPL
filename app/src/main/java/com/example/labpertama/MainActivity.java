package com.example.labpertama;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.labpertama.models.Record;
import com.example.labpertama.utilities.StringRandomizer;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int PERMISSION_REQUEST_ACCESS_FINE_LOCATION = 0;
    private WifiAdapter wifiAdapter;
    private ArrayList<String> wifiArrayList = new ArrayList<>();
    private ListView listViewWifi;
    private WifiManager wifiManager;
    private TextView textDateLabel;
    private TextView textDate;
    private Button buttonSave;
    BroadcastReceiver wifiReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            List<ScanResult> result = wifiManager.getScanResults();
            unregisterReceiver(this);

            for (ScanResult scanResult : result) {
                wifiArrayList.add(scanResult.SSID);
                wifiAdapter.notifyDataSetChanged();
            }

            String pattern = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(new Date());
            textDate.setText(date);

            textDateLabel.setVisibility(View.VISIBLE);
            textDate.setVisibility(View.VISIBLE);

            buttonSave.setEnabled(true);
        }
    };
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiAdapter = new WifiAdapter(wifiArrayList, this);
        listViewWifi = findViewById(R.id.listView_wifi);
        listViewWifi.setAdapter(wifiAdapter);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (!wifiManager.isWifiEnabled()) {
            Toast.makeText(this, "Wifi is disabled ... We need to enable it", Toast.LENGTH_SHORT).show();
            wifiManager.setWifiEnabled(true);
        }

        textDateLabel = findViewById(R.id.text_date_label);
        textDate = findViewById(R.id.text_date);
        textDateLabel.setVisibility(View.GONE);
        textDate.setVisibility(View.GONE);

        buttonSave = findViewById(R.id.button_save);
        buttonSave.setEnabled(false);

        firebaseDatabase = FirebaseDatabase.getInstance();
    }

    public void scanWifi(View view) {

        String accessFineLocation = Manifest.permission.ACCESS_FINE_LOCATION;
        int permissionGranted = PackageManager.PERMISSION_GRANTED;
        int permissionDenied = PackageManager.PERMISSION_DENIED;

        if (ActivityCompat.checkSelfPermission(this, accessFineLocation) == permissionGranted) {
            wifiArrayList.clear();
            registerReceiver(wifiReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
            wifiManager.startScan();
        } else if (ActivityCompat.checkSelfPermission(this, accessFineLocation) == permissionDenied) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{accessFineLocation},
                    PERMISSION_REQUEST_ACCESS_FINE_LOCATION
            );
        }
    }

    public void saveRecord(View view) {
        String date = textDate.getText().toString();
        String wifiList = wifiArrayList.toString();
        String randomId = StringRandomizer.generateRandomString();
        DatabaseReference databaseReference = firebaseDatabase.getReference(randomId);
        databaseReference.setValue(new Record(date, wifiList), new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                if (error == null) {
                    Toast.makeText(MainActivity.this, "save success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "save error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_ACCESS_FINE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    wifiArrayList.clear();
                    registerReceiver(wifiReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
                    wifiManager.startScan();
                }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_record:
                Intent intent = new Intent(this, RecordActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}