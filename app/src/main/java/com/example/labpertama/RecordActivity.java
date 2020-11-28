package com.example.labpertama;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.labpertama.models.Record;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RecordActivity extends AppCompatActivity {

    private RecordAdapter recordAdapter;
    private ArrayList<Record> recordArrayList = new ArrayList<>();
    private ListView listViewRecord;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

//        populateRecordArrayList();

        recordAdapter = new RecordAdapter(this, recordArrayList);
        listViewRecord = findViewById(R.id.listView_record);
        listViewRecord.setAdapter(recordAdapter);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Record record = postSnapshot.getValue(Record.class);
                    recordArrayList.add(record);
                }

                recordAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(RecordActivity.this, "fetch error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateRecordArrayList() {
        recordArrayList.add(new Record("Monday", "access point 1, access point 2, access point 3"));
        recordArrayList.add(new Record("Tuesday", "access point 4, access point 5, access point " +
                "6"));
        recordArrayList.add(new Record("Wednesday", "access point 7, access point 8, access point" +
                " 9"));
    }
}