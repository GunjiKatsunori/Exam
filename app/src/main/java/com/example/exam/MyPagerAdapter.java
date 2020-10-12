package com.example.exam;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<String> dataSet;
    int sizeOfData;

    public MyPagerAdapter(FragmentManager fm, ArrayList<String> dataSet) {
        super(fm);
        this.dataSet = dataSet;
        this.sizeOfData = dataSet.size();
    }

    // スワイプしたときにフラグメントを返す
    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new DummyFragment(dataSet.get(i));
        return fragment;
    }

    // ページの総数
    @Override
    public int getCount() {
        return sizeOfData;
    }

    // ページタイトルを文字列で返す
    @Override
    public CharSequence getPageTitle(int position) {
        return position + 1 + "/" + sizeOfData;
    }
}