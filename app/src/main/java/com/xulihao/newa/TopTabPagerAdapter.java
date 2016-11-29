package com.xulihao.newa;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 濠 on 2016/10/29.
 */

public class TopTabPagerAdapter extends FragmentPagerAdapter {
    List<String> title;
    public TopTabPagerAdapter(FragmentManager fm,List<String> list) {
        super(fm);
        title =list;
    }

    @Override
    public Fragment getItem(int position) {
        return TabFragmentFactory.CreateTabFragment(position);
    }

    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
