package com.kartnap.chandan.photoinsta.Profile;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kartnap.chandan.photoinsta.R;
import com.kartnap.chandan.photoinsta.Utills.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Chandan on 7/3/2017.
 */

public class EditProfileFragment extends Fragment {
    public static final String TAG ="EditProfileFragment";
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_edit_profile,container,false);
        imageView = (ImageView)view.findViewById(R.id.profile_photo);
        setProfileImage();
        ImageView imageView = (ImageView)view.findViewById(R.id.backArrow);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Onclick : Navigating back to profile activity");
                getActivity().finish();
            }
        });
        return view;
    }

    private void setProfileImage(){
        String imgUrl = "https://2.bp.blogspot.com/-WSPrWvuvCvc/WM80F43fu4I/AAAAAAAAGtU/N73vMkriLX8rH-lt1t2cns9YSuJlBHr_wCLcB/s1600/android-o-logo.png";
        UniversalImageLoader.setImage(imgUrl,imageView,null,"");


    }
}
