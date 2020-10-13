package com.example.exam;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class SubsubActivity extends AppCompatActivity {

    ViewPager viewPager;
    TestOpenHelper helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subsub);

        // SubActivity からの intent を受け取る
        Intent intentFromSub = getIntent();
        String selectedText = intentFromSub.getStringExtra("Text2");
        ArrayList<String> dataSet = intentFromSub.getStringArrayListExtra("DataSet");

        // viewpager を adapter でコントロールする
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), dataSet);
        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(adapter);


        //TextView textView = findViewById(R.id.textView2);
        //textView.setText(selectedText);

        final Button button = findViewById(R.id.add_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper = new TestOpenHelper(getApplicationContext());
                db = helper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("name", "abcdefg");
                values.put("value", 231);

                db.insert("test_table", null, values);

                readData(db);
            }
        });
    }

    private void readData(SQLiteDatabase db) {
        Cursor cursor = db.query("test_table", new String[] {"name", "value"}, null, null, null, null, null);
        cursor.moveToFirst();
        String text = cursor.getString(0) + cursor.getInt(1);
        Button button = findViewById(R.id.add_button);
        button.setText(text);
    }
}