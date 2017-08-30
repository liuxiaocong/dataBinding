package com.example.evanliu.databinder;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoconglau on 30/08/2017.
 */

public class ListActivity extends AppCompatActivity {
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            User user = new User();
            user.setName("name" + i);
            user.setAge(20 + i + "");
            if(i % 2 == 0)
            {
                user.setAvatar("https://cdn-images-1.medium.com/max/1200/1*SUZUVog_MUeoBOCpWmd15w.jpeg");
            }else {
                user.setAvatar("https://lh6.ggpht.com/9SZhHdv4URtBzRmXpnWxZcYhkgTQurFuuQ8OR7WZ3R7fyTmha77dYkVvcuqMu3DLvMQ=w300");
            }
            list.add(user);
        }
        adapter = new Adapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setData(list);

    }
}
