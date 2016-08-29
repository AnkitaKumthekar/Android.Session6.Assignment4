package com.example.akcreation.contextmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ankita Jounjal on 14-08-2016.
 */
public class Custom_List_Adapter extends BaseAdapter {
    private ArrayList<Global_Values> listData;
    private LayoutInflater layoutInflater;

    public Custom_List_Adapter(Context mContext, ArrayList<Global_Values> listData){
        this.listData = listData;
        layoutInflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int i) {
        return listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_row_layout, null);
            holder = new ViewHolder();
            holder.nameView = (TextView) convertView.findViewById(R.id.name);
            holder.contactNumberView = (TextView) convertView.findViewById(R.id.contact_number);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.nameView.setText(listData.get(position).getName());
        holder.contactNumberView.setText(listData.get(position).getContact_number());
        return convertView;
    }

    static class ViewHolder {
        TextView nameView;
        TextView contactNumberView;
    }
}
