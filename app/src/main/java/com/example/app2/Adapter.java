package com.example.app2;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
public class Adapter extends BaseAdapter {
    private ArrayList<Contact> data;
    private LayoutInflater inflater;
    private Context context;

    public Adapter(ArrayList<Contact> data, Context context) {
        this.data = data;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null)
            v = inflater.inflate(R.layout.listcontact, null);  // Lay Layout ben listcontact.xml
        TextView txtName = v.findViewById(R.id.txtName);
        txtName.setText(data.get(position).getName());
        TextView txtPhone = v.findViewById(R.id.txtPhone);
        txtPhone.setText(data.get(position).getPhoneNumber());
        CheckBox cb = v.findViewById(R.id.chbItem);
        cb.setChecked(data.get(position).isStatus());
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.get(position).setStatus(cb.isChecked());
            }
        });
        return v;
    }
}