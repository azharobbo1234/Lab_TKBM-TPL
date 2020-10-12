package com.example.labpertama;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondFragment extends Fragment {
    private TextView nameTextView;
    private TextView descriptionTextView;
    private TextView priceTextView;
    private MainActivityViewModel mainActivityViewModel;
    private Console console;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        nameTextView = (TextView) view.findViewById(R.id.nameTextView);
        descriptionTextView = (TextView) view.findViewById(R.id.descriptionTextView);
        priceTextView = (TextView) view.findViewById(R.id.priceTextView);

        mainActivityViewModel = new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);
        console = mainActivityViewModel.getSelectedConsole();

        nameTextView.setText("Name: " + console.getName());
        descriptionTextView.setText("Description: " + console.getDescription());
        priceTextView.setText("Price: " + console.getPrice());

        return view;
    }
}