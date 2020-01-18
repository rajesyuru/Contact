package com.rajes.contact;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Contact[] mContacts;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        mContacts = new Contact[] {
                new Contact("First", "First St.", "1234567890", R.drawable.avatar1),
                new Contact("Second", "Second St.", "2345678901", R.drawable.avatar2),
                new Contact("Third", "Third St.", "3456789012", R.drawable.avatar3),
                new Contact("Forth", "Forth St.", "4567890123", R.drawable.avatar4),
                new Contact("Fifth", "Fifth St.", "5678901234", R.drawable.avatar5),
                new Contact("Sixth", "Sixth St.", "6789012345", R.drawable.avatar6),
                new Contact("Seventh", "Seventh St.", "7890123456", R.drawable.avatar7),
                new Contact("Eighth", "Eighth St.", "8901234567", R.drawable.avatar8),
                new Contact("Ninth", "Ninth St.", "9012345678", R.drawable.avatar9),
                new Contact("Tenth", "Tenth St.", "0123456789", R.drawable.avatar10),

        };

        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.item_contact, mContacts);

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contacts = mContacts[position];
                showDialog(contacts);
            }
        });
    }

    private void showDialog(Contact contact) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Nomor Telepon: " + contact.getPhone()).setTitle(contact.getName()).setCancelable(false).setPositiveButton("Ok", null);

        AlertDialog dialog = builder.create();

        dialog.show();
    }
}
