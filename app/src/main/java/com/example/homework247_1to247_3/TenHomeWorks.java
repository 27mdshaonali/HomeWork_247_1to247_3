package com.example.homework247_1to247_3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class TenHomeWorks extends AppCompatActivity {

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap = new HashMap<>();

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ten_home_works);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        gridView = findViewById(R.id.gridView);

        populateData();
        MyAdapter myAdapter = new MyAdapter();
        gridView.setAdapter(myAdapter);

    }

    public void populateData() {

        HashMap<String, String> item1 = new HashMap<>();
        item1.put("image", String.valueOf(R.drawable.shaon));
        item1.put("title", "HomeWork 214.1");
        item1.put("subtitle", "Description for Homework 214.1");
        arrayList.add(item1);

        HashMap<String, String> item2 = new HashMap<>();
        item2.put("image", String.valueOf(R.drawable.home));
        item2.put("title", "HomeWork 214.2");
        item2.put("subtitle", "Description for Homework 214.2");
        arrayList.add(item2);

        HashMap<String, String> item3 = new HashMap<>();
        item3.put("image", String.valueOf(R.drawable.shaon));
        item3.put("title", "HomeWork 214.3");
        item3.put("subtitle", "Description for Homework 214.3");
        arrayList.add(item3);

        HashMap<String, String> item4 = new HashMap<>();
        item4.put("image", String.valueOf(R.drawable.home));
        item4.put("title", "HomeWork 214.4");
        item4.put("subtitle", "Description for Homework 214.4");
        arrayList.add(item4);

        HashMap<String, String> item5 = new HashMap<>();
        item5.put("image", String.valueOf(R.drawable.shaon));
        item5.put("title", "HomeWork 214.5");
        item5.put("subtitle", "Description for Homework 214.5");
        arrayList.add(item5);

        HashMap<String, String> item6 = new HashMap<>();
        item6.put("image", String.valueOf(R.drawable.home));
        item6.put("title", "HomeWork 232.1");
        item6.put("subtitle", "Description for Homework 232.1");
        arrayList.add(item6);

        HashMap<String, String> item7 = new HashMap<>();
        item7.put("image", String.valueOf(R.drawable.shaon));
        item7.put("title", "HomeWork 232.2");
        item7.put("subtitle", "Description for Homework 232.2");
        arrayList.add(item7);

        HashMap<String, String> item8 = new HashMap<>();
        item8.put("image", String.valueOf(R.drawable.home));
        item8.put("title", "HomeWork 232.3");
        item8.put("subtitle", "Description for Homework 232.3");
        arrayList.add(item8);

        HashMap<String, String> item9 = new HashMap<>();
        item9.put("image", String.valueOf(R.drawable.shaon));
        item9.put("title", "HomeWork 232.4");
        item9.put("subtitle", "Description for Homework 232.4");
        arrayList.add(item9);

        HashMap<String, String> item10 = new HashMap<>();
        item10.put("image", String.valueOf(R.drawable.home));
        item10.put("title", "HomeWork 232.5");
        item10.put("subtitle", "Description for Homework 232.5");
        arrayList.add(item10);


    }

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder") View myView = inflater.inflate(R.layout.ten_items, viewGroup, false);

            LinearLayout cardItemView = myView.findViewById(R.id.cardItemView);

            ImageView tenItemImage = myView.findViewById(R.id.itemImage);
            TextView tenHomeWorkTitle = myView.findViewById(R.id.homeWorkTitle);
            TextView tenHomeWorkSubtitle = myView.findViewById(R.id.homeWorkSubtitle);

            cardItemView.setOnClickListener(v -> {

                tenItemImage.setImageResource(Integer.parseInt(arrayList.get(i).get("image")));
                tenHomeWorkTitle.setText(arrayList.get(i).get("title"));
                tenHomeWorkSubtitle.setText(arrayList.get(i).get("subtitle"));

            });


            return myView;
        }
    }

}