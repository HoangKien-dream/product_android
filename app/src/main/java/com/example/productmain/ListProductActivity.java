package com.example.productmain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListProductActivity extends AppCompatActivity {

    private List<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        int price = Integer.parseInt(intent.getStringExtra("price"));
        // Tạo dữ liễu mẫu
        initData();
        // Add dữ liệu mới vừa thêm vào
        productList.add(new Product(username,price));
        // Truyền dữ liệu vào view
        ProductAdapter productAdapter = new ProductAdapter(this,productList);
        ListView listView  = findViewById(R.id.lisProduct);
        listView.setAdapter(productAdapter);
        // Show thông báo thành công
        Toast.makeText(this, "Lưu thành công sản phẩm" + username,Toast.LENGTH_LONG).show();
    }

    private void initData() {
        productList.add(new Product( "Asus", 1000000));
        productList.add(new Product( "Dell", 2000000));
        productList.add(new Product( "Lenovo", 3000000));
        productList.add(new Product( "MSI", 4000000));
    }
}