package com.example.shareddatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    EditText txt,email,age;
    Button b;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=findViewById(R.id.button);
        t1=findViewById(R.id.textView2);
        txt=findViewById(R.id.t1);
        email=findViewById(R.id.email);
        age=findViewById(R.id.age);
        SharedPreferences sp=getSharedPreferences("pref",MODE_PRIVATE);
        String data=sp.getString("name","No Data");
        String data1=sp.getString("email","No Data");
        String data2=sp.getString("age","No Data");
        t1.setText(data+"\n"+data1+"\n"+data2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("pref",MODE_PRIVATE);
                SharedPreferences.Editor ed=sp.edit();
                String val=txt.getText().toString();
                String a=email.getText().toString();
                String c=age.getText().toString();
                ed.putString("name",val);
                ed.putString("email",a);
                ed.putString("age",c);
                ed.apply();
                t1.setText(val+" \n"+a+" \n"+c);
            }
        });

    }
}