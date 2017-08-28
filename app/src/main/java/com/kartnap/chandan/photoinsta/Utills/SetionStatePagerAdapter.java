package com.kartnap.chandan.photoinsta.Utills;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Chandan on 7/3/2017.
 */

public class SetionStatePagerAdapter  extends FragmentStatePagerAdapter{
    private final List<Fragment> mfregmentList = new ArrayList<>();
    private HashMap<Fragment,Integer> mfragments = new HashMap<>();
    private HashMap<String, Integer> mFragmentNumbers = new HashMap<>();
    private final HashMap<Integer,String> mFragmentNames = new HashMap<>();


    public SetionStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mfregmentList.get(position);
    }

    @Override
    public int getCount() {
        return mfregmentList.size();
    }
    public void addFragment(Fragment fragment,String fragmentName){
        mfregmentList.add(fragment);
        mfragments.put(fragment,mfregmentList.size()-1);
        mFragmentNumbers.put(fragmentName,mfregmentList.size()-1);
        mFragmentNames.put(mfregmentList.size()-1,fragmentName);

    }

    /**
     * returns the fragment with name @param
     * @param fragmentName
     * @return
     */
    public Integer getFragmentNumber(String fragmentName){
        if (mFragmentNumbers.containsKey(fragmentName)){
            return mFragmentNumbers.get(fragmentName);

        }else {
            return null;

        }


    }
    /**
     * returns the fragment with name @param
     * @param fragment
     * @return
     */
    public Integer getFragmentNumber(Fragment fragment){
        if (mFragmentNumbers.containsKey(fragment)){
            return mFragmentNumbers.get(fragment);
        }else {
            return null;
        }
    }
    /**
     * returns the fragment with name @param
     * @param fragmentNumber
     * @return
     */
    public String getFragmentName(Integer fragmentNumber){
        if (mFragmentNames.containsKey(fragmentNumber)){
            return mFragmentNames.get(fragmentNumber);
        }else {
            return null;
        }
    }
}
