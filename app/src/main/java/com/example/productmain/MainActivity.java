package com.example.productmain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Product> productList = new ArrayList<>();

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
        initData();
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
                String name = username.getText().toString();
                int intPrice = Integer.parseInt(price.getText().toString());
                productList.add(new Product(name,intPrice));
               ProductAdapter productAdapter = new ProductAdapter(this,productList);
               ListView listView  = findViewById(R.id.lisProduct);
               listView.setAdapter(productAdapter);
               // Show thông báo thành công
               Toast.makeText(this, "Lưu thành công sản phẩm" + username,Toast.LENGTH_LONG).show();
//               Intent intent = new Intent(this,ListProductActivity.class);
//               intent.putExtra("username",username.getText().toString());
//               intent.putExtra("price",price.getText().toString());
//               startActivity(intent);
           }
       }
    }

    private void initData() {
        productList.add(new Product( "Asus", 1000000));
        productList.add(new Product( "Dell", 2000000));
        productList.add(new Product( "Lenovo", 3000000));
        productList.add(new Product( "MSI", 4000000));
    }
}