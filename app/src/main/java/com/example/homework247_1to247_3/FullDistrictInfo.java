package com.example.homework247_1to247_3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class FullDistrictInfo extends AppCompatActivity {

    private String districtName;
    private final ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    private TextView districtTV;
    private GridView gridView;

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

        // Get data from Intent
        Intent intent = getIntent();
        districtName = intent.getStringExtra("district_name");
        ArrayList<String> districtInfoList = intent.getStringArrayListExtra("district_info_list");
        ArrayList<String> imageUrls = intent.getStringArrayListExtra("image_urls");

        // Populate data dynamically
        populateData(districtInfoList, imageUrls);

        // Set up the adapter
        MyAdapter myAdapter = new MyAdapter();
        gridView.setAdapter(myAdapter);

        districtTV.setText(districtName);
    }

    private void initializeViews() {
        districtTV = findViewById(R.id.districtTV);
        gridView = findViewById(R.id.gridView);
    }

    private void populateData(ArrayList<String> districtInfoList, ArrayList<String> imageUrls) {
        arrayList.clear(); // Clear previous data to avoid duplication

        if (districtInfoList != null && imageUrls != null && districtInfoList.size() == imageUrls.size()) {
            for (int i = 0; i < districtInfoList.size(); i++) {
                HashMap<String, String> item = new HashMap<>();
                item.put("image_url", imageUrls.get(i)); // Assign image URL
                item.put("info_title", districtInfoList.get(i)); // Individual district info item
                arrayList.add(item);
            }
        }
    }

    static class ViewHolder {
        TextView textView, subTextView;
        ImageView imageView;
        LinearLayout cardItemView;
    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return arrayList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.district_info, parent, false);

                holder = new ViewHolder();
                holder.cardItemView = convertView.findViewById(R.id.cardItemView);
                holder.textView = convertView.findViewById(R.id.homeWorkTitle);
                holder.imageView = convertView.findViewById(R.id.itemImage);
                holder.subTextView = convertView.findViewById(R.id.homeWorkSubtitle);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            HashMap<String, String> item = arrayList.get(i);
            holder.textView.setGravity(Gravity.CENTER);
            holder.textView.setText(item.get("info_title"));
            holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            holder.subTextView.setVisibility(View.GONE);
            Picasso.get().load(item.get("image_url")).placeholder(R.drawable.shaon).into(holder.imageView);
            holder.cardItemView.setOnClickListener(v -> {

                Toast.makeText(getApplicationContext(), item.get("info_title")+" has been Clicked", Toast.LENGTH_SHORT).show();

            });

            return convertView;
        }
    }
}
