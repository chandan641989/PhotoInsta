package com.kartnap.chandan.photoinsta.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kartnap.chandan.photoinsta.R;

/**
 * Created by Chandan on 7/3/2017.
 */

public class SignOutFragment extends Fragment {
    public static final String TAG ="SignOutFragment";
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_sign_out,container,false);
        return view;
    }
}
