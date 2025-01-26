package com.example.homework247_1to247_3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeWork247_2 extends AppCompatActivity {

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work2472);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listView);

        populateData();
        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);
    }

    public void populateData() {
        HashMap<String, String> item1 = new HashMap<>();
        item1.put("image_url", "http://binarybird.xyz/Audio%20Player%20Images/james.jpg");
        item1.put("title", "James");
        item1.put("subtitle", "Audio Songs");
        arrayList.add(item1);

        HashMap<String, String> item2 = new HashMap<>();
        item2.put("image_url", "http://binarybird.xyz/Audio%20Player%20Images/ayub_bacchhu.jpg");
        item2.put("title", "Ayub Bacchhu");
        item2.put("subtitle", "Bangla Audio Songs");
        arrayList.add(item2);

        HashMap<String, String> item3 = new HashMap<>();
        item3.put("image_url", "http://binarybird.xyz/Audio%20Player%20Images/runa_laila.jpg");
        item3.put("title", "Runa Laila");
        item3.put("subtitle", "Bangla Audio Songs");
        arrayList.add(item3);

        HashMap<String, String> item4 = new HashMap<>();
        item4.put("image_url", "http://binarybird.xyz/Audio%20Player%20Images/bappa_mojumdor.jpg");
        item4.put("title", "Bappa Mozumbar");
        item4.put("subtitle", "Best Bangla songs of Bappa Mozumbar");
        arrayList.add(item4);

        HashMap<String, String> item5 = new HashMap<>();
        item5.put("image_url", "http://binarybird.xyz/Audio%20Player%20Images/andrew_kishore.webp");
        item5.put("title", "Andrew Kishore");
        item5.put("subtitle", "Best Bangla Songs of Andrew Kishore");
        arrayList.add(item5);

        HashMap<String, String> item6 = new HashMap<>();
        item6.put("image_url", "http://binarybird.xyz/Audio%20Player%20Images/sabina_yasmin.jpg");
        item6.put("title", "Sabina Yasmin");
        item6.put("subtitle", "Top Listened Bangla Songs of Sabina Yasmin");
        arrayList.add(item6);

        // Add more data...
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
            @SuppressLint("ViewHolder") View myViw = inflater.inflate(R.layout.item_layout, viewGroup, false);

            ImageView itemImage = myViw.findViewById(R.id.itemImage);
            TextView homeWorkTitle = myViw.findViewById(R.id.homeWorkTitle);
            TextView homeWorkSubtitle = myViw.findViewById(R.id.homeWorkSubtitle);
            LinearLayout cardItemView = myViw.findViewById(R.id.cardItemView);

            HashMap<String, String> hashMap = arrayList.get(i);

            String imageUrl = hashMap.get("image_url");
            String title = hashMap.get("title");
            String subtitle = hashMap.get("subtitle");

            Picasso.get().load(imageUrl).placeholder(R.drawable.shaon).into(itemImage);

            homeWorkTitle.setText(title);
            homeWorkSubtitle.setText(subtitle);

            cardItemView.setOnClickListener(v -> {

                String hashMapTitle = arrayList.get(i).get("title");
                String hashMapImageUrl = arrayList.get(i).get("image_url");

                if (i == 0) {

                    Intent intent = new Intent(HomeWork247_2.this, JamesSongsList.class);
                    intent.putExtra("title", hashMapTitle);
                    intent.putExtra("image_url", hashMapImageUrl);
                    startActivity(intent);

                } else if (i == 1) {

                    Intent intent = new Intent(HomeWork247_2.this, AyubBacchhuSongsList.class);
                    intent.putExtra("title", hashMapTitle);
                    intent.putExtra("image_url", hashMapImageUrl);
                    startActivity(intent);


                } else if (i == 2) {
                    Intent intent = new Intent(HomeWork247_2.this, RunaLailaSongsList.class);
                    intent.putExtra("title", hashMapTitle);
                    intent.putExtra("image_url", hashMapImageUrl);
                    startActivity(intent);
                }

            });

            return myViw;
        }
    }
}
