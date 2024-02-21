package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    protected EditText txtHoten, txtId, txtphone ;

    protected Button btnAdd;
    protected CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtHoten =  findViewById(R.id.edtName);
        txtId = findViewById(R.id.edtId);
        txtphone = findViewById(R.id.edtPhone);
        btnAdd = findViewById(R.id.btnAdd);
        checkBox = findViewById(R.id.checkBox);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //lay du lieu cho main activity
                    int id = Integer.parseInt(txtId.getText().toString());
                    String name = txtHoten.getText().toString();
                    String phone = txtphone.getText().toString();
                    boolean status = checkBox.isChecked();

                    //kiem tra xem cac truong hop co rong khong

                    if (name.isEmpty() || phone.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "du lieu chua du", Toast.LENGTH_SHORT).show();
                    } else {

                        //khai bao intent
                        Intent intent = new Intent();
                        //dong goi du lieu vao bundle
                        Bundle b = new Bundle();
                        b.putInt("Id", id);
                        b.putString("Name", name);
                        b.putString("Phone", phone);
                        b.putBoolean("Status", status);
                        //dua bundle vao intent
                        //intent.putExtra("additem", b);
                        intent.putExtras(b);
                        //khoi dong
                        setResult(150, intent);
                        finish();

                    }
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "du lieu bi sai kieu", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}