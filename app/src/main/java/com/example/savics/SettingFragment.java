package com.example.savics;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;


public class SettingFragment extends Fragment {

    EditText editTextOne, editTwo, editThree;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        editTextOne = view.findViewById(R.id.edittext_one);
        editTwo = view.findViewById(R.id.edittext_two);
        editThree = view.findViewById(R.id.edittext_three);

        initViews(view);

        return view;
    }


    private void initViews(View view) {


        view.findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String one = editTextOne.getText().toString().trim();
                final String two = editTwo.getText().toString().trim();
                final String three = editThree.getText().toString().trim();
                Toast.makeText(getContext(),one+ " " + two + " " + three , Toast.LENGTH_LONG).show();
            }
        });
    }
}
