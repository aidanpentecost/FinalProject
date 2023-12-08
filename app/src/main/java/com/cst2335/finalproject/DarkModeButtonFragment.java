package com.cst2335.finalproject;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

import androidx.fragment.app.Fragment;

public class DarkModeButtonFragment extends Fragment {
    private OnDarkModeButtonClickListener callback;

    public interface OnDarkModeButtonClickListener{
        void onDarkModeButtonClick();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            callback = (OnDarkModeButtonClickListener) context;
        }catch(ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.dark_mode_button_fragment,
                container,
                false);
        Button lightSwitch = view.findViewById(R.id.lightSwitch);
        lightSwitch.setOnClickListener(v -> callback.onDarkModeButtonClick());

        return view;
    }
}
