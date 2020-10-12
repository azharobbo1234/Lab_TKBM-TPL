package com.example.labpertama;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {
    private Button firstButton, secondButton, thirdButton;
    private TextView firstTextView, secondTextView, thirdTextView;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment secondFragment;
    private MainActivityViewModel mainActivityViewModel;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        firstButton = (Button) view.findViewById(R.id.firstItemButton);
        secondButton = (Button) view.findViewById(R.id.secondItemButton);
        thirdButton = (Button) view.findViewById(R.id.thirdItemButton);
        firstTextView = (TextView) view.findViewById(R.id.firstItemTextView);
        secondTextView = (TextView) view.findViewById(R.id.secondItemTextView);
        thirdTextView = (TextView) view.findViewById(R.id.thirdItemTextView);
        secondFragment = new SecondFragment();
        mainActivityViewModel = new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);

        firstTextView.setText(mainActivityViewModel.getConsoleName(0));
        secondTextView.setText(mainActivityViewModel.getConsoleName(1));
        thirdTextView.setText(mainActivityViewModel.getConsoleName(2));

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("FirstFragment", "First Button Clicked");
                mainActivityViewModel.setConsole(0);
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, secondFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("FirstFragment", "Second Button Clicked");
                mainActivityViewModel.setConsole(1);
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, secondFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("FirstFragment", "Third Button Clicked");
                mainActivityViewModel.setConsole(2);
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, secondFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}