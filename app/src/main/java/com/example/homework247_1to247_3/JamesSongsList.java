package com.example.homework247_1to247_3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.HashMap;

public class JamesSongsList extends AppCompatActivity {

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap = new HashMap<>();

    CoordinatorLayout coordinatorLayout;
    AppBarLayout appBarLayout;
    MaterialToolbar toolBar;
    FrameLayout frameLayout;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_james_songs_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initialize();

        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);

        toolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if (item.getItemId() == R.id.back) {
                    startActivity(new Intent(JamesSongsList.this, HomeWork247_2.class));
                    finish();
                }
                return false;
            }
        });


    }

    public class MyAdapter extends BaseAdapter{
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
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder") View myView = inflater.inflate(R.layout.item_layout, viewGroup, false);

            ImageView itemImage = myView.findViewById(R.id.itemImage);
            TextView homeWorkTitle = myView.findViewById(R.id.homeWorkTitle);
            TextView homeWorkSubtitle = myView.findViewById(R.id.homeWorkSubtitle);

            return myView;
        }
    }

    public void initialize() {

        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        appBarLayout = findViewById(R.id.appBarLayout);
        toolBar = findViewById(R.id.toolBar);
        frameLayout = findViewById(R.id.frameLayout);
        listView = findViewById(R.id.listView);

    }
}