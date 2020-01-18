package com.rajes.contact;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter {
    private Context mContext;
    private int mResource;
    private Contact[] mContacts;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull Contact[] contacts) {
        super(context, resource, contacts);

        mContext = context;
        mResource = resource;
        mContacts = contacts;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);

        Contact contact = mContacts[position];
        ImageView ivAvatar = convertView.findViewById(R.id.ivAvatar);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvAdress = convertView.findViewById(R.id.tvAdress);

        ivAvatar.setImageResource(contact.getAvatar());
        tvName.setText(contact.getName());
        tvAdress.setText(contact.getAddress());

        return convertView;

    }
}
