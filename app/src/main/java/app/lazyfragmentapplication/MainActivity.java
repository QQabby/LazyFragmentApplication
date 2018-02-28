package app.lazyfragmentapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> titles = new ArrayList<>();

    private List<Fragment> fragments = new ArrayList<>();
    TitleAdapter titleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tablayout = findViewById(R.id.tablayout);
        ViewPager viewpager = findViewById(R.id.viewpager);

        titles.add("android");
        titles.add("ios");
        titles.add("web");
        titles.add("java");

        fragments.add(GankFragment.newInstance("android"));
        fragments.add(GankFragment.newInstance("ios"));
        fragments.add(GankFragment.newInstance("web"));
        fragments.add(GankFragment.newInstance("java"));

        titleAdapter = new TitleAdapter(getSupportFragmentManager(), fragments, titles);
        viewpager.setAdapter(titleAdapter);
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        tablayout.setupWithViewPager(viewpager);
    }
}
