package com.example.demolivescore.ui.main;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.demolivescore.R;
import com.example.demolivescore.model.MatchDetailData;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private String[] tabs = {"Statistic", "Ranking"};
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    private boolean getAble;
    private String homeName;
    private String awayName;
    private String score;
    private MatchDetailData data;

    public MatchDetailData getData() {
        return data;
    }

    public void setData(MatchDetailData data) {
        this.data = data;
    }

    public boolean isGetAble() {
        return getAble;
    }

    public void setGetAble(boolean getAble) {
        this.getAble = getAble;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAwayName() {
        return awayName;
    }

    public void setAwayName(String awayName) {
        this.awayName = awayName;
    }

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
//        return PlaceholderFragment.newInstance(position + 1);
        Log.d("check create", "created");
        return PlaceholderFragment.newInstance(position, homeName, awayName, score, data);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
//        return mContext.getResources().getString(TAB_TITLES[position]);
        return tabs[position];
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}