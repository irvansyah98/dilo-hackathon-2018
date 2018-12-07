package com.example.iervan.tripfella;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class PesanankuActivity extends AppCompatActivity {
    private Toolbar toolbarPesananku;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesananku);

        toolbarPesananku = (Toolbar) findViewById(R.id.toolbarPesananku);
        setSupportActionBar(toolbarPesananku);

//        BottomNavigationView navigationBottom = (BottomNavigationView) findViewById(R.id.navigationViewBottom);

        viewPager = (ViewPager) findViewById(R.id.viewpagerPesananku);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabsPesananku);
        tabLayout.setupWithViewPager(viewPager);

        BottomNavigationView navigationBottom = (BottomNavigationView) findViewById(R.id.navigationViewBottom);

        navigationBottom.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                Intent intent = new Intent(PesanankuActivity.this, HomeActivity.class);
                                startActivity(intent);

                                return true;
                            case R.id.navigation_pesananku:
                                return true;
                            case R.id.navigation_favorit:
                                intent = new Intent(PesanankuActivity.this, FavoritActivity.class);
                                startActivity(intent);
                                return true;
                            case R.id.navigation_profil:
                                intent = new Intent(PesanankuActivity.this, ProfilActivity.class);
                                startActivity(intent);
                                return true;
                        }
                        return false;
                    }
                });
    }

    private void setupViewPager(ViewPager viewPager) {
        PesanankuActivity.ViewPagerAdapter adapter = new PesanankuActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new YangLaluFragment(), "Yang Lalu");
        adapter.addFragment(new HariIniFragment(), "Hari Ini");
        adapter.addFragment(new AkanDatangFragment(), "Yang Akan Datang");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
