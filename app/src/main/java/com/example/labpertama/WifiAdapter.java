package com.example.labpertama;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WifiAdapter extends BaseAdapter {

    private ArrayList<String> wifiArrayList;
    private Context context;

    public WifiAdapter(ArrayList<String> wifiArrayList, Context context) {
        this.wifiArrayList = wifiArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return wifiArrayList.size();
    }

    @Override
    public String getItem(int i) {
        return wifiArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.wifi_item, viewGroup, false);
        }

        String selectedWifi = getItem(i);
        TextView textWifi = view.findViewById(R.id.text_wifi);
        textWifi.setText(selectedWifi);

        return view;
    }
}
