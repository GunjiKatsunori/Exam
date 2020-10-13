package com.example.exam;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class SubsubActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subsub);

        // SubActivity からの intent を受け取る
        Intent intentFromSub = getIntent();
        String selectedText = intentFromSub.getStringExtra("Text2");
        ArrayList<String> dataSet = intentFromSub.getStringArrayListExtra("DataSet");

        //
        //TextView textView = findViewById(R.id.textView2);
        //textView.setText(selectedText);

        // フラグメントの呼び出し
        viewPager = findViewById(R.id.pager);
        FragmentPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), dataSet);
        viewPager.setAdapter(adapter);
    }
}
