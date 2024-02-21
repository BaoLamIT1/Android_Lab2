package com.example.app2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnThem, btnXoa;
    ListView lstViewContact;
    ArrayList<Contact> ContactList;
    Adapter ContactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContactList = new ArrayList<>();
        ContactList.add(new Contact(1,"Mot","34567","@drawable/vol33",false));
        ContactList.add(new Contact(2,"Hai","0987","@drawable/vol33",true));
        ContactList.add(new Contact(1,"Ba","56789","@drawable/vol33",true));
        //Create Adapter
        ContactAdapter = new Adapter(ContactList,this);


        lstViewContact = findViewById(R.id.lstContact);
        lstViewContact.setAdapter(ContactAdapter);
        btnThem = findViewById(R.id.btnThem);
        btnThem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(intent,100);
            }
        });
        btnXoa = findViewById(R.id.btnXoa);
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("do you want delete this item");
                builder.setMessage("delete");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < ContactList.size(); i++) {
                            if(ContactList.get(i).isStatus()) ContactList.remove(i);
                        }
                        ContactAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("no", null);
                builder.create().show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requesCode, int resultCode , @Nullable Intent data){
        super.onActivityResult(requesCode, resultCode, data);
        Bundle b = data.getExtras();
        // Lay du lieu tu Bundle
        int id = b.getInt("Id");
        String name = b.getString("Name");
        String phoneNumber = b.getString("PhoneNumber");
        String image = b.getString("");
        boolean status = b.getBoolean("Status");
        Contact newcontact = new Contact(id, name, phoneNumber,image, false);
        if (requesCode == 100 && resultCode ==150)
        {
            // THEM
        ContactList.add(newcontact);
        ContactAdapter.notifyDataSetChanged();

        }
    }

}