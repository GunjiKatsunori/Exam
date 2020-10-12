package com.example.exam;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListSubAdapter extends RecyclerView.Adapter<ListSubAdapter.ViewHolder> {
    private ArrayList<String> dataset = new ArrayList<String>();

    // 複数のアイテムを管理する
    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView mTextView;

        // コンストラクター
        ViewHolder(View v) {
            super(v);
            linearLayout = (LinearLayout)v.findViewById(R.id.activity_sub);
            mTextView = (TextView)v.findViewById(R.id.text_view_sub);
        }
    }

    // コンストラクター
    ListSubAdapter(ArrayList<String> dataset) {
        this.dataset = dataset;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_sub, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        // ビューのサイズ、幅、余白、その他レイアウトのパラメータの設定を記述

        // クリックイベントのリスナー
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // position のデータ取得
                final int position = holder.getAdapterPosition();
                String selectedText = dataset.get(position);

                Context context = parent.getContext();
                Intent intent = new Intent(context, SubsubActivity.class);
                intent.putExtra("Text2", selectedText);

                context.startActivity(intent);
            }

        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 並び順を更新
        holder.mTextView.setText(dataset.get(position));
    }

    // アイテム数を返す
    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
