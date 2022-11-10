package com.example.productmain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username;
    private EditText price;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        price  = findViewById(R.id.price);
        save = findViewById(R.id.save);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       if (v.getId() == R.id.save){
           if (username.getText().toString().isEmpty()
                   && price.getText().toString().isEmpty()){
               Toast toast =  Toast.makeText(MainActivity.this,"Bạn chưa nhập u/p", Toast.LENGTH_LONG);
               toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,0,0);
               toast.show();
           }else {
               Intent intent = new Intent(this,ListProductActivity.class);
               intent.putExtra("username",username.getText().toString());
               intent.putExtra("price",price.getText().toString());
               startActivity(intent);
           }
       }
    }
}