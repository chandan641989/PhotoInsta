package com.kartnap.chandan.photoinsta.Utills;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.kartnap.chandan.photoinsta.Home.HomeActivity;
import com.kartnap.chandan.photoinsta.Likes.LikesActivity;
import com.kartnap.chandan.photoinsta.Login.RegisterActivity;
import com.kartnap.chandan.photoinsta.Profile.ProfileActivity;
import com.kartnap.chandan.photoinsta.R;
import com.kartnap.chandan.photoinsta.Search.SearchActivity;
import com.kartnap.chandan.photoinsta.Share.ShareActivity;

/**
 * Created by Chandan on 6/28/2017.
 */

public class BottomNavigationViewHelper {
    public static final String TAG = "BottomNavigationViewHelper";
    public static void setupBottomNativationView(BottomNavigationViewEx bottomNavigationViewEx){
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);

    }
    public static void enableNavigation(final Context context,BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_house:
                        Intent in1 = new Intent(context, HomeActivity.class);
                        context.startActivity(in1);
                        break;

                    case R.id.ic_alert:
                        Intent intent3 = new Intent(context, ProfileActivity.class);
                        context.startActivity(intent3);
                        break;
                    case R.id.ic_android:
                        Intent intent5 = new Intent(context, LikesActivity.class);
                        context.startActivity(intent5);
                        break;
                    case R.id.ic_search:
                        Intent in2 = new Intent(context, RegisterActivity.class);
                        context.startActivity(in2);
                        break;
                    case R.id.ic_circle:
                        Intent intent4 = new Intent(context, ShareActivity.class);
                        context.startActivity(intent4);
                        break;
                }

                return false;
            }
        });

    }
}
