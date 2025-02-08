package com.example.homework247_1to247_3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class ImageDetailActivity extends AppCompatActivity {

    public static String TITLE_NAME = "";
    public static String DIS_NAME = "";
    public static String DIV_NAME = "";
    public static String IMAGE_URL = "";
    public static Bitmap COVER_IMAGE = null;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap = new HashMap<>();
    ListView listView;
    TextView itemName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image_detail);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            v.setPadding(insets.getInsets(WindowInsetsCompat.Type.systemBars()).left, insets.getInsets(WindowInsetsCompat.Type.systemBars()).top, insets.getInsets(WindowInsetsCompat.Type.systemBars()).right, insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
            return insets;
        });
        initializeData();

        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);

        populateData();


    }

    public void initializeData() {
        itemName = findViewById(R.id.itemName);
        listView = findViewById(R.id.listView);

        itemName.setText(TITLE_NAME);


    }

    public void populateData() {
        HashMap<String, String> item1 = new HashMap<>();
        item1.put("image_url", "http://192.168.0.103/HomeWork%20247.2/Images/News/Amardesh.png");
        item1.put("title", "Amardesh");
        item1.put("news_url", "https://www.amardesh.com");
        arrayList.add(item1);

        HashMap<String, String> item2 = new HashMap<>();
        item2.put("image_url", "http://192.168.0.103/HomeWork%20247.2/Images/News/BTV.jpg");
        item2.put("title", "Bangladesh Television");
        item2.put("news_url", "https://btv.gov.bd");
        arrayList.add(item2);

        HashMap<String, String> item3 = new HashMap<>();
        item3.put("image_url", "http://192.168.0.103/HomeWork%20247.2/Images/News/ETV.png");
        item3.put("title", "Ekushey Television");
        item3.put("news_url", "https://www.ekushey-tv.com/");
        arrayList.add(item3);

        HashMap<String, String> item4 = new HashMap<>();
        item4.put("image_url", "http://192.168.0.103/HomeWork%20247.2/Images/News/Independent%20TV.png");
        item4.put("title", "Independent Television");
        item4.put("news_url", "https://www.itvbd.com/");
        arrayList.add(item4);

        HashMap<String, String> item5 = new HashMap<>();
        item5.put("image_url", "http://192.168.0.103/HomeWork%20247.2/Images/News/Inqilab.png");
        item5.put("title", "Daily Inqilab");
        item5.put("news_url", "https://dailyinqilab.com/");
        arrayList.add(item5);

    }

    public void openWebsite(Context context, String url) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setShowTitle(true);
//        builder.setToolbarColor(ContextCompat.getColor(context, R.color.purple_500)); // Customize toolbar color

        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(context, Uri.parse(url));
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
            @SuppressLint({"ViewHolder", "InflateParams"}) View myView = inflater.inflate(R.layout.newspaper_listview, null);

            CardView cardView = myView.findViewById(R.id.cardItemView2);
            TextView itemTV = myView.findViewById(R.id.itemTV);
            RoundedImageView roundedImageView = myView.findViewById(R.id.listViewImage);

            HashMap<String, String> hashMap = arrayList.get(i);

            String imageUrl = hashMap.get("image_url");
            String title = hashMap.get("title");
            //String news_link = hashMap.get("news_url");

            Picasso.get().load(imageUrl).placeholder(R.drawable.shaon).into(roundedImageView);

            roundedImageView.setOnClickListener(v -> {

                String webUrl = hashMap.get("news_url");


                openWebsite(getApplicationContext(), webUrl);

                //hashMap.put("news_url", "https://www.google.com/");


            });

            return myView;
        }
    }

}
