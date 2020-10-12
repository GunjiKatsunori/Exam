package com.example.exam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    static class ViewHolder {
        TextView textView;
    }

    private LayoutInflater inflater;
    private int itemLayoutId;
    private ArrayList<String> titles;

    ListAdapter(Context context, int itemLayoutId, ArrayList<String> titles) {
        super();
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itemLayoutId = itemLayoutId;
        this.titles = titles;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        // 最初だけViewをinflateしてそれを再利用
        if (convertView == null) {
            convertView = inflater.inflate(itemLayoutId, parent, false);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        }
        // holderを使って再利用
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(titles.get(position));

        return convertView;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
