package com.ziggeo.pagerDemo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.ziggeo.pagerDemo.BlankFragmentTest1;
import com.ziggeo.pagerDemo.BlankFragmentTest2;
import com.ziggeo.pagerDemo.BlankFragmentTestCamera;


/**
 * Created by Alexander Bedulin on 07-Oct-19.
 * Ziggeo, Inc.
 * alexb@ziggeo.com
 */
public class TestPagerAdapter extends FragmentStatePagerAdapter {

    public TestPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BlankFragmentTestCamera();
            case 1:
                return new BlankFragmentTest1();
            default:
                return new BlankFragmentTest2();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }
}
