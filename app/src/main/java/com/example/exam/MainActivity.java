package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static String[] li = {
            "aaa",
            "bbb",
            "ccc",
            "ddd",
            "eee"
    };
    private static ArrayList<String> titles = new ArrayList<>(Arrays.asList(li));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListView と Adapter のインスタンスを生成
        // list.xml の繰り返し表示
        ListView listView = findViewById(R.id.listView);
        BaseAdapter adapter = new ListAdapter(
                this.getApplicationContext(), R.layout.list, titles);
        listView.setAdapter(adapter);

        // クリック時のアクション
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        Intent intent = new Intent(this.getApplicationContext(), SubActivity.class);

        String selectedText = titles.get(position);

        intent.putExtra("Text", selectedText);

        startActivity(intent);
    }
}