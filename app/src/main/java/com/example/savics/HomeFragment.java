package com.example.savics;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);


        initViews(view);

        return view;
    }

    private void initViews(final View view) {


        final ArrayList<Parent> parentArrayList= new ArrayList<>();
        final RadioGroup rg = (RadioGroup) view.findViewById(R.id.radioGroup1);
        final EditText name = view.findViewById(R.id.edittext_one);
        final EditText age = view.findViewById(R.id.editText);
        final EditText mail = view.findViewById(R.id.editText2);
        final RecyclerView recyclerView =view.findViewById(R.id.recycler);


        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Parent parent = new Parent();

                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
                {
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch(checkedId){
                            case R.id.radio0:
                                parent.setGender('M');
                                break;
                            case R.id.radio1:
                                parent.setGender('F');
                                break;
                            case R.id.radio2:
                                parent.setGender('O');
                                break;
                        }
                    }
                });

                parent.setFullName(name.getText().toString());
                parent.setAge(Integer.valueOf(age.getText().toString()));
                parent.setMail(mail.getText().toString());

                parentArrayList.add(parent);
                ParentAdapter parentAdapter = new ParentAdapter(parentArrayList);

                parentAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(),parentArrayList.size() + "",Toast.LENGTH_LONG).show();

                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(parentAdapter);
            }
        });



    }
}
