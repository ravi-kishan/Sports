package com.example.ravi.sports;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Ravi on 29-07-2018.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(FragmentManager fm ,Context context) {
        super(fm);
        mContext = context;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.genaral);
        } else   {
            return mContext.getString(R.string.cricket);
        }
    }


    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return new GeneralFragment();
        else
            return new CricketFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }
}
