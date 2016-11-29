package com.xulihao.newa;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        title = new ArrayList<>();
        String[] array = this.getResources().getStringArray(R.array.tabtitle);
        for (int i = 0; i < array.length; i++) {
            title.add(array[i]);
        }
        mViewPager.setAdapter(new TopTabPagerAdapter(getSupportFragmentManager(),title ));
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);
        mTabLayout.getTabAt(1).setIcon(R.mipmap.ic_launcher);
        mTabLayout.getTabAt(2).setIcon(R.mipmap.ic_launcher);
       // mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}
