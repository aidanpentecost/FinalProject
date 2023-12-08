package com.cst2335.finalproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class BackButtonFragment extends Fragment {
    private OnBackButtonClickListener callback;

    public interface OnBackButtonClickListener{
        void onBackButtonCLick();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            callback = (OnBackButtonClickListener) context;
        }catch(ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement OnRefreshButtonCLickListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.back_button_fragment, container, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button loginButton = view.findViewById(R.id.backButton);
        loginButton.setOnClickListener(v -> callback.onBackButtonCLick());
        return view;
    }
}
