package com.example.asonbom.data.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.asonbom.R;

import java.util.ArrayList;

public class RowListAdapter extends ArrayAdapter<RowInfo> {
    private static final String TAG = "Row ListAdapter.";
    private Context mContext;

    int mResource;

    public RowListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<RowInfo> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //get the row information
        String title = getItem(position).getTitle();
        String info = getItem(position).getInfo();

        //Create the row object with the information
        RowInfo rowInfo = new RowInfo(title,info);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent,false);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.text_name);
        TextView tvInfo = (TextView) convertView.findViewById(R.id.text_info);

        tvTitle.setText(title);
        tvInfo.setText(info);

        return  convertView;
    }
}
