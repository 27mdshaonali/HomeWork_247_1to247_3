package com.example.homework247_1to247_3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.AnimationTypes;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class FullDistrictInfo extends AppCompatActivity {

    private final ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    private String districtName;
    private TextView districtTV;
    private GridView gridView;
    private ArrayList<String> districtInfoList, imageUrls;

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
        districtInfoList = intent.getStringArrayListExtra("district_info_list");
        imageUrls = intent.getStringArrayListExtra("image_urls");

        if (districtInfoList == null || imageUrls == null) {
            Log.e("FullDistrictInfo", "Error: districtInfoList or imageUrls is null.");
            return;
        }

        // Populate GridView data dynamically
        populateData();

        // Set up adapter
        MyAdapter myAdapter = new MyAdapter();
        gridView.setAdapter(myAdapter);

        // Set district name
        districtTV.setText(districtName);
        districtTV.setVisibility(View.GONE);

        // Setup ImageSlider with Clickable Items
        setupImageSlider();
    }

    private void initializeViews() {
        districtTV = findViewById(R.id.districtTV);
        gridView = findViewById(R.id.gridView);
    }

    private void populateData() {
        arrayList.clear();
        if (districtInfoList != null && imageUrls != null && districtInfoList.size() == imageUrls.size()) {
            for (int i = 0; i < districtInfoList.size(); i++) {
                HashMap<String, String> item = new HashMap<>();
                item.put("image_url", imageUrls.get(i));
                item.put("info_title", districtInfoList.get(i));
                arrayList.add(item);
            }
        }
    }

    private void setupImageSlider() {
        ImageSlider imageSlider = findViewById(R.id.image_slider);

        if (imageSlider == null || imageUrls == null || districtInfoList == null) {
            Log.e("FullDistrictInfo", "Error: ImageSlider or data is null.");
            return;
        }

        ArrayList<SlideModel> imageList = new ArrayList<>();

        for (int i = 0; i < imageUrls.size(); i++) {
            imageList.add(new SlideModel(imageUrls.get(i), districtInfoList.get(i), ScaleTypes.CENTER_CROP));
        }

        imageSlider.setImageList(imageList);
        imageSlider.setSlideAnimation(AnimationTypes.TOSS);

        // Store the current image position manually
        final int[] currentPosition = {0};

        // Detect page change (if supported by the library)
        imageSlider.setOnClickListener(v -> {
            // Open detail activity with current image and text
            Intent detailIntent = new Intent(FullDistrictInfo.this, ImageDetailActivity.class);
            detailIntent.putExtra("image_url", imageUrls.get(currentPosition[0]));
            detailIntent.putExtra("text", districtInfoList.get(currentPosition[0]));
            startActivity(detailIntent);
        });
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
                Toast.makeText(getApplicationContext(), "Clicked: " + item.get("info_title"), Toast.LENGTH_SHORT).show();
            });

            return convertView;
        }
    }
}
