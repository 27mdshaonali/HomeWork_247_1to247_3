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
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();

    LinearLayout main;
    CoordinatorLayout coordinatorLayout;
    MaterialToolbar materialToolbar;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
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
        // Adding multiple items to the list
        HashMap<String, Object> item1 = new HashMap<>();
        item1.put("image", R.drawable.shaon); // Direct integer resource ID
        item1.put("title", "Homework 247.1");
        item1.put("subtitle", "Description for Homework 247.1");
        arrayList.add(item1);

        HashMap<String, Object> item2 = new HashMap<>();
        item2.put("image", R.drawable.shaon); // Direct integer resource ID
        item2.put("title", "Homework 247.2");
        item2.put("subtitle", "Description for Homework 247.2");
        arrayList.add(item2);

        HashMap<String, Object> item3 = new HashMap<>();
        item3.put("image", R.drawable.shaon); // Direct integer resource ID
        item3.put("title", "Homework 247.3");
        item3.put("subtitle", "Description for Homework 247.3");
        arrayList.add(item3);
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
            @SuppressLint("ViewHolder") View myView = inflater.inflate(R.layout.item_layout, viewGroup, false);

            ImageView itemImage = myView.findViewById(R.id.itemImage);
            TextView homeWorkTitle = myView.findViewById(R.id.homeWorkTitle);
            TextView homeWorkSubtitle = myView.findViewById(R.id.homeWorkSubtitle);

            // Setting data from the arrayList
            itemImage.setImageResource((int) arrayList.get(i).get("image"));
            homeWorkTitle.setText((String) arrayList.get(i).get("title"));
            homeWorkSubtitle.setText((String) arrayList.get(i).get("subtitle"));

            // Handle click events on the item
            myView.setOnClickListener(v -> {
                Toast.makeText(MainActivity.this, "Item clicked: " + arrayList.get(i).get("title"), Toast.LENGTH_SHORT).show();

                // Conditional actions based on the clicked item
                if (i == 0) {
                    startActivity(new Intent(MainActivity.this, TenHomeWorks.class));
                } else if (i == 1) {
                    startActivity(new Intent(MainActivity.this, HomeWork247_2.class));
                } else {
                    startActivity(new Intent(MainActivity.this, EmergencyHelpApp.class));
                }
            });

            return myView;
        }
    }
}
