package com.example.labpertama;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.labpertama.models.Record;

import java.util.ArrayList;

public class RecordAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Record> recordArrayList;

    public RecordAdapter(Context context, ArrayList<Record> recordArrayList) {
        this.context = context;
        this.recordArrayList = recordArrayList;
    }

    @Override
    public int getCount() {
        return recordArrayList.size();
    }

    @Override
    public Record getItem(int i) {
        return recordArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.record_item, viewGroup, false);
        }

        Record selectedRecord = getItem(i);

        TextView textDate = view.findViewById(R.id.record_text_date);
        textDate.setText(selectedRecord.getDate());

        TextView textWifi = view.findViewById(R.id.record_text_wifi);
        textWifi.setText(selectedRecord.getWifiList());

        return view;
    }
}
