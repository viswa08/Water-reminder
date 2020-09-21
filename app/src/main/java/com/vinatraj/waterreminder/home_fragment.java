package com.vinatraj.waterreminder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home_fragment extends Fragment {
    private int waterProgLevel = 0;
    ProgressBar prog;
    Button incButton;
    Button decButton;
    TextView waterLevelTextView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public home_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static home_fragment newInstance(String param1, String param2) {
        home_fragment fragment = new home_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home_fragment, container, false);
        prog = rootView.findViewById(R.id.water_progress);
        incButton = (Button) rootView.findViewById(R.id.incButton);
        decButton = (Button) rootView.findViewById(R.id.decButton);
        waterLevelTextView = rootView.findViewById(R.id.water_progress_text);
        incButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(waterProgLevel <= 90) {
                    waterProgLevel += 10;
                    Toast.makeText(getContext(),"Level = " + waterProgLevel, Toast.LENGTH_SHORT).show();
                    waterProgressAction();
                    //prog.setProgress(90);
                }
            }
        });

        decButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(waterProgLevel >= 10){
                    waterProgLevel -= 10;
                    Toast.makeText(getContext(),"Level = " + waterProgLevel, Toast.LENGTH_SHORT).show();
                    waterProgressAction();
                    //prog.setProgress(10);
                }
            }
        });

        //prog.setProgress(60);
        return rootView;
    }


    public void waterProgressAction() {
        prog.setProgress(waterProgLevel);
        waterLevelTextView.setText(Integer.toString(waterProgLevel) + "%");
    }

}