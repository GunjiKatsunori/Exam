package com.example.exam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubsubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subsub);
        // SubActivity からの intent を受け取る
        Intent intentFromSub = getIntent();
        String selectedText = intentFromSub.getStringExtra("Text2");

        TextView textView = findViewById(R.id.textView2);
        textView.setText(selectedText);
    }
}
