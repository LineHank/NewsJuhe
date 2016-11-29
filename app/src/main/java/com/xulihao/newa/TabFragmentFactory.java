package com.xulihao.newa;


import android.support.v4.app.Fragment;

/**
 * Created by 濠 on 2016/10/28.
 */

public class TabFragmentFactory {
    public static final int FRAGMENTONE = 0;
    public static final int FRAGMENTTWO = 1;
    public static final int FRAGMENTTHREE = 2;

    public static Fragment CreateTabFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case FRAGMENTONE:
                fragment = new OneFragment();

                break;
            case FRAGMENTTWO:
                fragment = new TwoFragment();
                break;
            case FRAGMENTTHREE:
                fragment = new ThreeFragment();
                break;
            default:
                break;
        }
        return fragment;
    }
}
