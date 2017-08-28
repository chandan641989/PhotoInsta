package com.kartnap.chandan.photoinsta.Profile;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.kartnap.chandan.photoinsta.R;
import com.kartnap.chandan.photoinsta.Utills.BottomNavigationViewHelper;
import com.kartnap.chandan.photoinsta.Utills.GridImageAdapter;
import com.kartnap.chandan.photoinsta.Utills.UniversalImageLoader;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    private static final int NUM_OF_COL =3;
    private Context mContext = ProfileActivity.this;
    private static int ACTIVITY_NUM = 1;
    ImageView profileImage;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG,"onCreat : Starting");

        setUpBottomNavigationView();
        setupToolbar();
        setupActivityWidgets();
        setProfileImage();
        tempGridsetup();
    }
    private void tempGridsetup(){
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("http://i.imgur.com/KB4JPdv.png");
        imgURLs.add("http://i.imgur.com/Wxx99PW.jpg");
        imgURLs.add("http://i.imgur.com/whw2q0r.jpg");
        imgURLs.add("http://i.imgur.com/ZtBsWDj.jpg");
        imgURLs.add("http://i.imgur.com/Vs3m8ey.jpg");
        imgURLs.add("http://i.imgur.com/ZNoCJFQ.png");
        imgURLs.add("http://i.imgur.com/DENaWLw.jpg");
        imgURLs.add("http://i.imgur.com/RSCBEKp.jpg");
        imgURLs.add("http://i.imgur.com/WgPqbDZ.jpg");
        imgURLs.add("http://i.imgur.com/6daocg9.jpg");
        imgURLs.add("http://i.imgur.com/Xv6gGXv.jpg");
        imgURLs.add("http://i.imgur.com/mwR4POb.jpg");
        imgURLs.add("http://i.imgur.com/0nLkqzQ.jpg");
        setupImageGrid(imgURLs);
    }
    private void setupImageGrid(ArrayList<String> imgUrls){
        GridView gridView = (GridView)findViewById(R.id.gridView);
        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth/NUM_OF_COL;
        gridView.setColumnWidth(imageWidth);
        GridImageAdapter adapter = new GridImageAdapter(mContext,R.layout.layout_image_grid,"",imgUrls);
        gridView.setAdapter(adapter);


    }
    private void setProfileImage(){
        String imgUrl = "https://2.bp.blogspot.com/-WSPrWvuvCvc/WM80F43fu4I/AAAAAAAAGtU/N73vMkriLX8rH-lt1t2cns9YSuJlBHr_wCLcB/s1600/android-o-logo.png";

        UniversalImageLoader.setImage(imgUrl,profileImage,progressBar,"");

    }
    private void setupActivityWidgets(){
        progressBar = (ProgressBar)findViewById(R.id.profileProgressBar);
        progressBar.setVisibility(View.GONE);
        profileImage = (ImageView)findViewById(R.id.profile_photo);


    }
    private  void setupToolbar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);
        ImageView profileMenu = (ImageView)findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick :  Navigating to Account Settings");
                Intent intent = new Intent(mContext, AccountSettingActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setUpBottomNavigationView(){
        Log.d(TAG,"setupBottomNav starting BottomNavigation");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx)findViewById(R.id.bottomNavigationViewBar);
        BottomNavigationViewHelper.setupBottomNativationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.profile_menu, menu);
//        return true;
//    }
}
