package com.kartnap.chandan.photoinsta.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.kartnap.chandan.photoinsta.R;
import com.kartnap.chandan.photoinsta.Utills.BottomNavigationViewHelper;
import com.kartnap.chandan.photoinsta.Utills.SetionStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Chandan on 6/30/2017.
 */

public class AccountSettingActivity extends AppCompatActivity {

    private static final String TAG = "AccountSettingActivity";
    private Context context;
    private SetionStatePagerAdapter pagerAdapter;
    private ViewPager mViewPager;
    private static int ACTIVITY_NUM = 2;

    private RelativeLayout mRelativeLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
        context = AccountSettingActivity.this;
        Log.d(TAG,"onCreate :  Started");
        mViewPager = (ViewPager)findViewById(R.id.container);
        mRelativeLayout = (RelativeLayout)findViewById(R.id.relLayout1);

        setupSettingsList();
        setUpBottomNavigationView();
        setupFragments();
        //setup backarrow nativating to profile activity
        ImageView arrow = (ImageView)findViewById(R.id.backArrow);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onCreate: navigating back to profile activity");
                finish();
            }
        });

    }

    private void setupFragments(){
        pagerAdapter = new SetionStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile));
        pagerAdapter.addFragment(new SignOutFragment(),getString(R.string.sign_out));


    }

    private void setupSettingsList(){
        Log.d(TAG,"setupSettingsList initializing and creating list");
        ListView listView = (ListView)findViewById(R.id.listView);
        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile));
        options.add(getString(R.string.sign_out));
        ArrayAdapter adapter = new ArrayAdapter(context,android.R.layout.simple_list_item_1,options);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,"onItemClick : Navigating to fragment : "+position);
                setViewPager(position);
            }
        });
    }
    private void setViewPager(Integer fragmentNumber){
        mRelativeLayout.setVisibility(View.GONE);
        Log.d(TAG,"setViewPager: navigating to fragment number: "+fragmentNumber);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setCurrentItem(fragmentNumber);


    }
    public void setUpBottomNavigationView(){
        Log.d(TAG,"setupBottomNav starting BottomNavigation");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx)findViewById(R.id.bottomNavigationViewBar);
        BottomNavigationViewHelper.setupBottomNativationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(context,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
