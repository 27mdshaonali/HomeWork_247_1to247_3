package com.example.homework247_1to247_3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class FullDistrictInfo extends AppCompatActivity {

    public static String DISTRICT_NAME = "";
    public static String IMAGE_URL = "";


    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap = new HashMap<>();
    TextView districtTV;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_full_district_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();

        populateData();
        MyAdapter myAdapter = new MyAdapter();
        gridView.setAdapter(myAdapter);

        districtTV.setText(DISTRICT_NAME);


    }

    public void initializeViews() {
        districtTV = findViewById(R.id.districtTV);
        gridView = findViewById(R.id.gridView);
    }

    public void populateData() {

        HashMap<String, String> item1 = new HashMap<>();
        item1.put("image_url", IMAGE_URL);
        item1.put("districtName", DISTRICT_NAME);
        arrayList.add(item1);

        HashMap<String, String> item2 = new HashMap<>();
        item2.put("image_url", IMAGE_URL);
        item2.put("districtName", DISTRICT_NAME);
        arrayList.add(item2);


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
            @SuppressLint({"ViewHolder", "InflateParams"}) View myView = inflater.inflate(R.layout.ten_items, null);

            TextView textView = myView.findViewById(R.id.homeWorkTitle);
            TextView textView2 = myView.findViewById(R.id.homeWorkSubtitle);
            ImageView imageView = myView.findViewById(R.id.itemImage);

            HashMap<String, String> hashMap = arrayList.get(i);
            textView.setGravity(Gravity.CENTER);
            textView2.setVisibility(View.GONE);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            String imageUrl = hashMap.get("image_url");
            String districtName = hashMap.get("districtName");

            textView.setText(districtName);
            Picasso.get().load(imageUrl).placeholder(R.drawable.shaon).into(imageView);


            return myView;
        }
    }

}