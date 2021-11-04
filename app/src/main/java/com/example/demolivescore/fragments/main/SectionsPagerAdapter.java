package com.example.demolivescore.fragments.main;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.demolivescore.R;
import com.example.demolivescore.fragments.statistic.StatisticFragment;
import com.example.demolivescore.model.MatchDetailData;
/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private String[] tabs = {"Statistic", "Envents"};
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    private boolean getAble;
    private String homeName;
    private String awayName;
    private String score;
    private Integer match_id;

    public Integer getMatch_id() {
        return match_id;
    }

    public void setMatch_id(Integer match_id) {
        this.match_id = match_id;
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
        if(position==0)
            return StatisticFragment.newInstance(match_id,homeName,awayName,score);
        else
            return new Fragment();
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