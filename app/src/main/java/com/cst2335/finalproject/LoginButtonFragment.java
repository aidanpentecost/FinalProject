package com.cst2335.finalproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class LoginButtonFragment extends Fragment {
    private OnLoginButtonClickListener callback;
    public interface OnLoginButtonClickListener{
        void onLoginButtonClick();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            callback = (OnLoginButtonClickListener) context;
        }catch(ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement OnRefreshButtonCLickListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_button, container, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button loginButton = view.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> callback.onLoginButtonClick());
        return view;
    }
}
