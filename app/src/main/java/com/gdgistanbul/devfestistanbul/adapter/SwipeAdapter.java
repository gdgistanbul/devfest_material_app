package com.gdgistanbul.devfestistanbul.adapter;


import android.app.Fragment;
import android.app.FragmentManager;


import com.gdgistanbul.devfestistanbul.R;

import android.support.v13.app.FragmentPagerAdapter;
import com.gdgistanbul.devfestistanbul.fragment.TrackFragment;
import com.viewpagerindicator.IconPagerAdapter;

/**
 * Created by myener on 9/21/14.
 */
public class SwipeAdapter extends FragmentPagerAdapter implements IconPagerAdapter {
    protected static final String[] CONTENT = new String[]{"Track 1", "Track 2", "Track 3", "Track 4",};
    protected static final int[] ICONS = new int[]{
            R.drawable.perm_group_camera_selected,
            R.drawable.ic_launcher,
            R.drawable.perm_group_camera_selected,
            R.drawable.ic_launcher
    };

    private static TrackFragment[] fragments=new TrackFragment[4];

    private int mCount = CONTENT.length;

    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments[position]==null) {
            fragments[position] = TrackFragment.getInstance();
            fragments[position].setArguments(position);
        }
        return fragments[position];

    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return SwipeAdapter.CONTENT[position % CONTENT.length];
    }

    @Override
    public int getIconResId(int index) {
        return ICONS[index % ICONS.length];
    }

    public void setCount(int count) {
        if (count > 0 && count <= 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }
}