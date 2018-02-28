package app.lazyfragmentapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by xuqianqian on 2018/2/28.
 */

public class TitleAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    private List<String> types;

    public TitleAdapter(FragmentManager fm, List<Fragment> fragments, List<String> types) {
        super(fm);
        this.fragments = fragments;
        this.types = types;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return types.get(position);
    }
}
