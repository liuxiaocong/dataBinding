package com.example.evanliu.databinder;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.evanliu.databinder.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    User user;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new User();
        user.setAge("12");
        user.setName("xiaocong");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setUser(user);
        binding.setHandler(this);
        ImageView imageView = (ImageView) findViewById(R.id.img);
        Glide.with(this).load("https://cdn-images-1.medium.com/max/1200/1*SUZUVog_MUeoBOCpWmd15w.jpeg").into(imageView);
    }

    public void onClickChange(View view) {
        user.setName(user.getName() + "++");
        user.setAge(user.getAge() + 1);
    }

    public void onClickGoList(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}
