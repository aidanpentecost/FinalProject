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

    //interface used as onClickListener
    public interface OnBackButtonClickListener{
        void onBackButtonCLick();
    }

    /**
     * @param context
     */
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            callback = (OnBackButtonClickListener) context;
        }catch(ClassCastException e) {
            //Exception if the object does not implement the right interface
            throw new ClassCastException(context.toString() +
                    "must implement OnRefreshButtonCLickListener");
        }
    }

    /**
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //creates the view containing the backButton
        View view = inflater.inflate(R.layout.back_button_fragment, container, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button loginButton = view.findViewById(R.id.backButton);
        loginButton.setOnClickListener(v -> callback.onBackButtonCLick());

        return view;
    }
}
