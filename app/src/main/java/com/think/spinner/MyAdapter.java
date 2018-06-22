package com.think.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by think on 2018/1/7.
 */

public class MyAdapter extends BaseAdapter {

    private List<Person> mPersons;

    public MyAdapter(Context context, List<Person> persons) {
        mPersons = persons;
    }

    @Override
    public int getCount() {
        return mPersons == null ? 0 : mPersons.size();
    }

    @Override
    public Object getItem(int position) {
        return mPersons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_spinner_person, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvName.setText(mPersons.get(position).getName());
        viewHolder.tvCity.setText(mPersons.get(position).getCity());
        return convertView;
    }

    static class ViewHolder {
        protected TextView tvName;
        protected TextView tvCity;

        ViewHolder(View rootView) {

            initView(rootView);
        }

        private void initView(View rootView) {
            tvName = (TextView) rootView.findViewById(R.id.tv_name);
            tvCity = (TextView) rootView.findViewById(R.id.tv_city);
        }
    }
}
