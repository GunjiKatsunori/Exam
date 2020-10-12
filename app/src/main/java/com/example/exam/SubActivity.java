package com.example.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SubActivity extends AppCompatActivity {
    private String[] datasetList = {"AAA", "BBB", "CCC", "DDD", "EEE", "FFF"};
    private ArrayList<String> dataset = new ArrayList<>(Arrays.asList(datasetList));
    ListSubAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // Mainページのデータを受け取るための処理
        Intent intentFromMain = getIntent();

        /* Mainページから文字列を受け取る
        String selectedText = intent.getStringExtra("Text");

        TextView textView = findViewById(R.id.selected_text);
        textView.setText(selectedText);

         */

        // リスト(RecyclerView)
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        // LayoutManagerの設定
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // アダプタの設定
        adapter = new ListSubAdapter(dataset);
        recyclerView.setAdapter(adapter);

        // ドラッグの動作
        ItemTouchHelper mIth = new ItemTouchHelper(
                new SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT) {
                    @Override
                    public boolean onMove(
                            @NonNull RecyclerView recyclerView,
                            @NonNull RecyclerView.ViewHolder viewHolder,
                            @NonNull RecyclerView.ViewHolder target) {
                        final int fromPos = viewHolder.getAdapterPosition();
                        final int toPos = target.getAdapterPosition();
                        adapter.notifyItemMoved(fromPos, toPos);
                        return true;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                        final int fromPos = viewHolder.getAdapterPosition();
                        dataset.remove(fromPos);
                        adapter.notifyItemRemoved(fromPos);
                    }
        });

        mIth.attachToRecyclerView(recyclerView);

    }
}
