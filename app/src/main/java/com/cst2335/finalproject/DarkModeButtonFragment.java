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

    /**
     * @param context
     */
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            callback = (OnDarkModeButtonClickListener) context;
        }catch(ClassCastException e){
            throw new ClassCastException(context.toString());
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
