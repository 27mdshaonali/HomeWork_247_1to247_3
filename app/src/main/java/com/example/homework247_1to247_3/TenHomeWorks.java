package com.example.homework247_1to247_3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

import com.squareup.picasso.Picasso;

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
        item1.put("image", "http://binarybird.xyz/Audio%20Player%20Images/divisible.png");
        item1.put("title", "HomeWork 214.1");
        item1.put("subtitle", "Write a program to check whether a number is divisible by 5 and 11 or not");
        arrayList.add(item1);

        HashMap<String, String> item2 = new HashMap<>();
        item2.put("image", "http://binarybird.xyz/Audio%20Player%20Images/leap_year.png");
        item2.put("title", "HomeWork 214.2");
        item2.put("subtitle", "Write a program to check whether a year is leap year or not");
        arrayList.add(item2);

        HashMap<String, String> item3 = new HashMap<>();
        item3.put("image", "http://binarybird.xyz/Audio%20Player%20Images/number_7.png");
        item3.put("title", "HomeWork 214.3");
        item3.put("subtitle", "Write a program to input week number and output the week day.");
        arrayList.add(item3);

        HashMap<String, String> item4 = new HashMap<>();
        item4.put("image", "http://binarybird.xyz/Audio%20Player%20Images/gpa100.png");
        item4.put("title", "HomeWork 214.4");
        item4.put("subtitle", "Write a program to input marks of five subjects Physics, Chemistry, Biology, Mathematics and Computer");
        arrayList.add(item4);

        HashMap<String, String> item5 = new HashMap<>();
        item5.put("image", "http://binarybird.xyz/Audio%20Player%20Images/electricity_bill.png");
        item5.put("title", "HomeWork 214.5");
        item5.put("subtitle", "Write a program to input electricity unit charges and calculate total electricity bill");
        arrayList.add(item5);

        HashMap<String, String> item6 = new HashMap<>();
        item6.put("image", "http://binarybird.xyz/Audio%20Player%20Images/multiplication2.png");
        item6.put("title", "HomeWork 232.1");
        item6.put("subtitle", "Write a program to display the multiplication table of a given integer");
        arrayList.add(item6);

        HashMap<String, String> item7 = new HashMap<>();
        item7.put("image", "http://binarybird.xyz/Audio%20Player%20Images/even2.png");
        item7.put("title", "HomeWork 232.2");
        item7.put("subtitle", "Write a program to display the N terms of even number and their sum");
        arrayList.add(item7);

        HashMap<String, String> item8 = new HashMap<>();
        item8.put("image", "http://binarybird.xyz/Audio%20Player%20Images/series.png");
        item8.put("title", "HomeWork 232.3");
        item8.put("subtitle", "Write a program to display the sum of the series upto n terms");
        arrayList.add(item8);

        HashMap<String, String> item9 = new HashMap<>();
        item9.put("image", "http://binarybird.xyz/Audio%20Player%20Images/square_root.png");
        item9.put("title", "HomeWork 232.4");
        item9.put("subtitle", "Write a program to display the N terms of square natural number and their sum");
        arrayList.add(item9);

        HashMap<String, String> item10 = new HashMap<>();
        item10.put("image", "http://binarybird.xyz/Audio%20Player%20Images/palindrome.png");
        item10.put("title", "HomeWork 232.5");
        item10.put("subtitle", "Write a program to check whether a number is palindrome or not");
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

            HashMap<String, String> hashMap = arrayList.get(i);

            String imageUrl = hashMap.get("image");
            String title = hashMap.get("title");
            String subtitle = hashMap.get("subtitle");

            Picasso.get().load(imageUrl).placeholder(R.drawable.shaon).into(tenItemImage);

            tenHomeWorkTitle.setText(title);
            tenHomeWorkSubtitle.setText(subtitle);
            //tenHomeWorkSubtitle.setText(arrayList.get(i).get("subtitle"));

            cardItemView.setOnClickListener(v -> {

                if (i == 0) {

                    HomeWork214_1.HW214_1TITLE = arrayList.get(i).get("title");
                    HomeWork214_1.HW214_1SUBTITLE = arrayList.get(i).get("subtitle");

                    Intent intent = new Intent(TenHomeWorks.this, HomeWork214_1.class);
                    startActivity(intent);

                } else if (i == 1) {

                    HomeWork214_2.HW214_2TITLE = arrayList.get(i).get("title");
                    HomeWork214_2.HW214_2SUBTITLE = arrayList.get(i).get("subtitle");

                    startActivity(new Intent(TenHomeWorks.this, HomeWork214_2.class));

                } else if (i == 2) {
                    HomeWork214_3.HW214_3TITLE = arrayList.get(i).get("title");
                    HomeWork214_3.HW214_3SUBTITLE = arrayList.get(i).get("subtitle");

                    startActivity(new Intent(TenHomeWorks.this, HomeWork214_3.class));
                } else if (i == 3) {
                    HomeWork214_4.HW214_4TITLE = arrayList.get(i).get("title");
                    HomeWork214_4.HW214_4SUBTITLE = arrayList.get(i).get("subtitle");

                    startActivity(new Intent(TenHomeWorks.this, HomeWork214_4.class));
                } else if (i == 4) {
                    HomeWork214_5.HW214_5TITLE = arrayList.get(i).get("title");
                    HomeWork214_5.HW214_5SUBTITLE = arrayList.get(i).get("subtitle");

                    startActivity(new Intent(TenHomeWorks.this, HomeWork214_5.class));
                } else if (i == 5) {
                    HomeWork232_1.HW232_1TITLE = arrayList.get(i).get("title");
                    HomeWork232_1.HW232_1SUBTITLE = arrayList.get(i).get("subtitle");

                    startActivity(new Intent(TenHomeWorks.this, HomeWork232_1.class));
                } else if (i == 6) {
                    HomeWork232_2.HW232_2TITLE = arrayList.get(i).get("title");
                    HomeWork232_2.HW232_2SUBTITLE = arrayList.get(i).get("subtitle");

                    startActivity(new Intent(TenHomeWorks.this, HomeWork232_2.class));
                } else if (i == 7) {
                    HomeWork232_3.HW232_3TITLE = arrayList.get(i).get("title");
                    HomeWork232_3.HW232_3SUBTITLE = arrayList.get(i).get("subtitle");

                    startActivity(new Intent(TenHomeWorks.this, HomeWork232_3.class));
                } else if (i == 8) {
                    HomeWork232_4.HW232_4TITLE = arrayList.get(i).get("title");
                    HomeWork232_4.HW232_4SUBTITLE = arrayList.get(i).get("subtitle");

                    startActivity(new Intent(TenHomeWorks.this, HomeWork232_4.class));

                } else {
                    HomeWork232_5.HW232_5TITLE = arrayList.get(i).get("title");
                    HomeWork232_5.HW232_5SUBTITLE = arrayList.get(i).get("subtitle");

                    startActivity(new Intent(TenHomeWorks.this, HomeWork232_5.class));
                }


//                tenItemImage.setImageResource(Integer.parseInt(arrayList.get(i).get("image")));
//                tenHomeWorkTitle.setText(arrayList.get(i).get("title"));
//                tenHomeWorkSubtitle.setText(arrayList.get(i).get("subtitle"));

            });


            return myView;
        }
    }

}