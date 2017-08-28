package com.kartnap.chandan.photoinsta.Search;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.kartnap.chandan.photoinsta.R;
import com.kartnap.chandan.photoinsta.Utills.BottomNavigationViewHelper;

/**
 * Created by Chandan on 6/28/2017.
 */

public class SearchActivity extends AppCompatActivity {
    public static final  String TAG = "SearchActivity";
    private Context mContext = SearchActivity.this;
    private static int ACTIVITY_NUM = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG,"onCreat : Started");
         setUpBottomNavigationView();
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
}
