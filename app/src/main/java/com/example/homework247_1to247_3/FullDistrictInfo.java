package com.example.homework247_1to247_3;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

    private final ArrayList<HashMap<String, String>> districtData = new ArrayList<>();
    private TextView districtTV, emergencyCall;
    private GridView gridView;
    private ArrayList<String> districtInfoList, imageUrls;
    private ArrayList<String> districtInfoList2, imageUrls2;
    private String districtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_full_district_info);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            v.setPadding(insets.getInsets(WindowInsetsCompat.Type.systemBars()).left, insets.getInsets(WindowInsetsCompat.Type.systemBars()).top, insets.getInsets(WindowInsetsCompat.Type.systemBars()).right, insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
            return insets;
        });

        initializeViews();
        retrieveIntentData();
        handleNullCases();
        populateData();
        setupGridView();
        setupImageSlider();
        emergencyCall();
    }

    private void initializeViews() {
        districtTV = findViewById(R.id.districtTV);
        gridView = findViewById(R.id.gridView);
        emergencyCall = findViewById(R.id.emergencyCall);
    }

    private void emergencyCall() {
        emergencyCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:999"));
            startActivity(intent);
        });
    }

    private void retrieveIntentData() {
        Intent intent = getIntent();
        districtName = intent.getStringExtra("district_name");
        districtInfoList = intent.getStringArrayListExtra("district_info_list");
        imageUrls = intent.getStringArrayListExtra("image_urls");
        districtInfoList2 = intent.getStringArrayListExtra("district_info_list2");
        imageUrls2 = intent.getStringArrayListExtra("image_urls2");

        logIntentData();
    }

    private void logIntentData() {
        Log.d("FullDistrictInfo", "districtName: " + districtName);
        Log.d("FullDistrictInfo", "districtInfoList: " + districtInfoList);
        Log.d("FullDistrictInfo", "imageUrls: " + imageUrls);
        Log.d("FullDistrictInfo", "districtInfoList2: " + districtInfoList2);
        Log.d("FullDistrictInfo", "imageUrls2: " + imageUrls2);
    }

    private void handleNullCases() {
        if (districtInfoList == null) districtInfoList = new ArrayList<>();
        if (imageUrls == null) imageUrls = new ArrayList<>();
        if (districtInfoList2 == null) districtInfoList2 = new ArrayList<>();
        if (imageUrls2 == null) imageUrls2 = new ArrayList<>();
    }

    private void populateData() {
        districtData.clear();
        int dataSize = Math.min(districtInfoList.size(), imageUrls.size());

        for (int i = 0; i < dataSize; i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("image_url", imageUrls.get(i));
            item.put("info_title", districtInfoList.get(i));
            districtData.add(item);
        }


    }

    private void setupGridView() {
        MyAdapter adapter = new MyAdapter();
        gridView.setAdapter(adapter);
        districtTV.setText(districtName);
        districtTV.setVisibility(View.GONE);
    }

    private void setupImageSlider() {
        ImageSlider imageSlider = findViewById(R.id.image_slider);
        if (imageSlider == null) {
            Log.e("FullDistrictInfo", "Error: ImageSlider is null.");
            return;
        }

        if (districtInfoList2 == null || imageUrls2 == null || districtInfoList2.isEmpty() || imageUrls2.isEmpty()) {
            Log.e("FullDistrictInfo", "Error: districtInfoList2 or imageUrls2 is empty.");
            return;
        }

        ArrayList<SlideModel> slideModels = new ArrayList<>();
        int minSize = Math.min(districtInfoList2.size(), imageUrls2.size());

        for (int i = 0; i < minSize; i++) {
            String imageUrl = imageUrls2.get(i);
            String title = districtInfoList2.get(i);

            // Check if the image URL is valid
            if (imageUrl != null && !imageUrl.isEmpty()) {
                slideModels.add(new SlideModel(imageUrl, title, ScaleTypes.FIT));
            } else {
                Log.e("FullDistrictInfo", "Invalid image URL at index " + i);
            }
        }

        if (slideModels.isEmpty()) {
            Log.e("FullDistrictInfo", "No valid slide models created.");
        } else {
            imageSlider.setImageList(slideModels);
            imageSlider.setSlideAnimation(AnimationTypes.TOSS);
        }
    }

    private static class ViewHolder {
        TextView textView, subTextView;
        ImageView imageView;
        LinearLayout cardItemView;
    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return districtData.size();
        }

        @Override
        public Object getItem(int position) {
            return districtData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
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

            HashMap<String, String> item = districtData.get(position);
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
