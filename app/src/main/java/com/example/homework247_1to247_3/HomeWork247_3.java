package com.example.homework247_1to247_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class HomeWork247_3 extends AppCompatActivity {

    private final String[] divisions = {"Choose a Division", "Dhaka", "Chattogram", "Rajshahi", "Khulna", "Barishal", "Sylhet", "Rangpur", "Mymensingh"};
    private final String[][] districts = {{}, {"Choose a district", "Dhaka", "Gazipur", "Narayanganj", "Tangail", "Madaripur", "Shariatpur", "Manikganj", "Narsingdi", "Rajbari", "Munshiganj", "Kishoreganj", "Mymensingh", "Faridpur"}, {"Choose a district", "Chattogram", "Cox's Bazar", "Feni", "Bandarban", "Lakshmipur", "Cumilla", "Chandpur", "Noakhali", "Brahmanbaria", "Khagrachhari", "Rangamati"}, {"Choose a district", "Rajshahi", "Bogura", "Naogaon", "Pabna", "Joypurhat", "Chapainawabganj", "Natore", "Sirajganj"}, {"Choose a district", "Khulna", "Jessore", "Kushtia", "Bagerhat", "Chuadanga", "Jhenaidah", "Magura", "Meherpur", "Narail", "Satkhira"}, {"Choose a district", "Barishal", "Bhola", "Patuakhali", "Jhalokathi", "Pirojpur", "Barguna"}, {"Choose a district", "Sylhet", "Moulvibazar", "Sunamganj", "Habiganj"}, {"Choose a district", "Rangpur", "Dinajpur", "Kurigram", "Gaibandha", "Lalmonirhat", "Nilphamari", "Panchagarh", "Thakurgaon"}, {"Choose a district", "Mymensingh", "Jamalpur", "Netrokona", "Sherpur"}};


    private Spinner spinnerDivision, spinnerDistrict;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_work2473);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            v.setPadding(insets.getInsets(WindowInsetsCompat.Type.systemBars()).left, insets.getInsets(WindowInsetsCompat.Type.systemBars()).top, insets.getInsets(WindowInsetsCompat.Type.systemBars()).right, insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
            return insets;
        });

        initializeViews();
        setupMainSpinner();
    }

    private void initializeViews() {
        spinnerDivision = findViewById(R.id.spinnerDivision);
        spinnerDistrict = findViewById(R.id.spinnerDistrict);

        spinnerDistrict.setVisibility(View.GONE);
    }

    private void setupMainSpinner() {
        ArrayAdapter<String> divisionAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, divisions);
        divisionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDivision.setAdapter(divisionAdapter);

        spinnerDivision.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0) {
                    spinnerDistrict.setVisibility(View.GONE);
                } else {
                    setupDistrictSpinner(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                spinnerDistrict.setVisibility(View.GONE);
            }
        });
    }

    private void setupDistrictSpinner(int divisionIndex) {
        spinnerDistrict.setVisibility(View.VISIBLE);
        ArrayAdapter<String> districtAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, districts[divisionIndex]);
        districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDistrict.setAdapter(districtAdapter);

        spinnerDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int districtIndex, long id) {
                if (districtIndex != 0) {
                    String selectedDivision = divisions[divisionIndex];
                    String selectedDistrict = districts[divisionIndex][districtIndex];

                    // Show specific messages based on division and district
                    if (selectedDivision.equals("Dhaka")) {
                        if (selectedDistrict.equals("Dhaka")) {

                            Intent intent = new Intent(getApplicationContext(), FullDistrictInfo.class);
                            intent.putExtra("district_name", selectedDistrict);

                            // Text list (District info items)
                            ArrayList<String> infoList = new ArrayList<>();
                            infoList.add("Police Station");
                            infoList.add("Heritage Place");
                            infoList.add("School");

                            // Corresponding image URLs
                            ArrayList<String> imageList = new ArrayList<>();
                            imageList.add("http://192.168.0.103/HomeWork%20247.2/Images/Other%20Images/natore1.jpg");
                            imageList.add("http://192.168.0.103/HomeWork%20247.2/Images/Other%20Images/rayerbazar.jpg");
                            imageList.add("http://192.168.0.103/HomeWork%20247.2/Images/Other%20Images/natore1.jpg");

                            intent.putStringArrayListExtra("district_info_list", infoList);
                            intent.putStringArrayListExtra("image_urls", imageList);

                            ArrayList<String> infoList2 = new ArrayList<>();
                            infoList2.add("Arnob");
                            infoList2.add("Ayub Bacchu");

                            ArrayList<String> imageList2 = new ArrayList<>();
                            imageList2.add("http://192.168.0.103/HomeWork%20247.2/Images/Arnob.jpg");
                            imageList2.add("http://192.168.0.103/HomeWork%20247.2/Images/Ayub.jpg");

                            intent.putStringArrayListExtra("image_urls2", imageList2);
                            intent.putStringArrayListExtra("district_info_list2", infoList2);

                            startActivity(intent);


//                            Intent intent = new Intent(HomeWork247_3.this, FullDistrictInfo.class);
//                            FullDistrictInfo.DISTRICT_NAME = selectedDistrict;
//                            FullDistrictInfo.IMAGE_URL = "http://192.168.0.103/HomeWork%20247.2/Images/Other%20Images/rayerbazar.jpg";
//                            startActivity(intent);


                        } else if (selectedDistrict.equals("Gazipur")) {

                            Intent intent = new Intent(getApplicationContext(), FullDistrictInfo.class);
                            intent.putExtra("district_name", selectedDistrict);


                            ArrayList<String> infoList2 = new ArrayList<>();
                            infoList2.add("Arnob");
                            infoList2.add("Ayub Bacchu");
                            infoList2.add("Arnob");
                            infoList2.add("Ayub Bacchu");

                            ArrayList<String> imageList2 = new ArrayList<>();
                            imageList2.add("http://192.168.0.103/HomeWork%20247.2/Images/Arnob.jpg");
                            imageList2.add("http://192.168.0.103/HomeWork%20247.2/Images/Ayub.jpg");
                            imageList2.add("http://192.168.0.103/HomeWork%20247.2/Images/Arnob.jpg");
                            imageList2.add("http://192.168.0.103/HomeWork%20247.2/Images/Ayub.jpg");

                            intent.putStringArrayListExtra("image_urls2", imageList2);
                            intent.putStringArrayListExtra("district_info_list2", infoList2);

                            startActivity(intent);

                        } else if (selectedDistrict.equals("Kishoreganj")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Kishoreganj in Dhaka", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Manikganj")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Manikganj in Dhaka", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Madaripur")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Madaripur in Dhaka", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Munshiganj")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Munshiganj in Dhaka", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Narayanganj")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Narayanganj in Dhaka", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Narsingdi")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Narsingdi in Dhaka", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Rajbari")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Rajbari in Dhaka", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Mymensingh")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Mymensingh in Dhaka", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Shariatpur")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Shariatpur in Dhaka", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Tangail")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Tangail in Dhaka", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Faridpur")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Faridpur in Dhaka", Toast.LENGTH_SHORT).show();
                        }
                    } else if (selectedDivision.equals("Chattogram")) {
                        if (selectedDistrict.equals("Bandarban")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Bandarban in Chattogram", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Brahmanbaria")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Brahmanbaria in Chattogram", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Chandpur")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Chandpur in Chattogram", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Chattogram")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Chattogram in Chattogram", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Cox's Bazar")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Cox's Bazar in Chattogram", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Cumilla")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Cumilla in Chattogram", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Feni")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Feni in Chattogram", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Khagrachhari")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Khagrachhari in Chattogram", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Lakshmipur")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Lakshmipur in Chattogram", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Noakhali")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Noakhali in Chattogram", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Rangamati")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Rangamati in Chattogram", Toast.LENGTH_SHORT).show();
                        }
                    } else if (selectedDivision.equals("Rajshahi")) {
                        if (selectedDistrict.equals("Bogura")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Bogura in Rajshahi", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Chapainawabganj")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Chapainawabganj in Rajshahi", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Joypurhat")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Joypurhat in Rajshahi", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Naogaon")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Naogaon in Rajshahi", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Natore")) {

                            Intent intent = new Intent(getApplicationContext(), FullDistrictInfo.class);
                            intent.putExtra("district_name", selectedDistrict);

                            // Text list (District info items)
                            ArrayList<String> infoList = new ArrayList<>();
                            infoList.add("Police Station");
                            infoList.add("Heritage Place");
                            infoList.add("Police Station");
                            infoList.add("Heritage Place");

                            // Corresponding image URLs
                            ArrayList<String> imageList = new ArrayList<>();
                            imageList.add("http://192.168.0.103/HomeWork%20247.2/Images/Other%20Images/natore1.jpg");
                            imageList.add("http://192.168.0.103/HomeWork%20247.2/Images/Other%20Images/rayerbazar.jpg");
                            imageList.add("http://192.168.0.103/HomeWork%20247.2/Images/Other%20Images/natore1.jpg");
                            imageList.add("http://192.168.0.103/HomeWork%20247.2/Images/Other%20Images/rayerbazar.jpg");

                            intent.putStringArrayListExtra("district_info_list", infoList);
                            intent.putStringArrayListExtra("image_urls", imageList);


                            ArrayList<String> infoList2 = new ArrayList<>();
                            infoList2.add("Arnob");
                            infoList2.add("Ayub Bacchu");
                            infoList2.add("Arnob");
                            infoList2.add("Ayub Bacchu");

                            ArrayList<String> imageList2 = new ArrayList<>();
                            imageList2.add("http://192.168.0.103/HomeWork%20247.2/Images/Arnob.jpg");
                            imageList2.add("http://192.168.0.103/HomeWork%20247.2/Images/Ayub.jpg");
                            imageList2.add("http://192.168.0.103/HomeWork%20247.2/Images/Arnob.jpg");
                            imageList2.add("http://192.168.0.103/HomeWork%20247.2/Images/Ayub.jpg");

                            intent.putStringArrayListExtra("image_urls2", imageList2);
                            intent.putStringArrayListExtra("district_info_list2", infoList2);

                            startActivity(intent);


                        } else if (selectedDistrict.equals("Pabna")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Pabna in Rajshahi", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Rajshahi")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Rajshahi in Rajshahi", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Sirajganj")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Sirajganj in Rajshahi", Toast.LENGTH_SHORT).show();
                        }
                    } else if (selectedDivision.equals("Khulna")) {
                        if (selectedDistrict.equals("Bagerhat")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Bagerhat in Khulna", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Chuadanga")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Chuadanga in Khulna", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Jessore")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Jashore in Khulna", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Jhenaidah")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Jhenaidah in Khulna", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Khulna")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Khulna in Khulna", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Kushtia")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Kushtia in Khulna", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Magura")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Magura in Khulna", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Meherpur")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Meherpur in Khulna", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Narail")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Narail in Khulna", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Satkhira")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Satkhira in Khulna", Toast.LENGTH_SHORT).show();
                        }
                    } else if (selectedDivision.equals("Barishal")) {
                        if (selectedDistrict.equals("Barguna")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Barguna in Barishal", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Barishal")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Barishal in Barishal", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Bhola")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Bhola in Barishal", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Jhalokathi")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Jhalokathi in Barishal", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Patuakhali")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Patuakhali in Barishal", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Pirojpur")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Pirojpur in Barishal", Toast.LENGTH_SHORT).show();
                        }
                    } else if (selectedDivision.equals("Sylhet")) {
                        if (selectedDistrict.equals("Habiganj")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Habiganj in Sylhet", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Moulvibazar")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Moulvibazar in Sylhet", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Sunamganj")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Sunamganj in Sylhet", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Sylhet")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Sylhet in Sylhet", Toast.LENGTH_SHORT).show();
                        }
                    } else if (selectedDivision.equals("Rangpur")) {
                        if (selectedDistrict.equals("Dinajpur")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Dinajpur in Rangpur", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Gaibandha")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Gaibandha in Rangpur", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Kurigram")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Kurigram in Rangpur", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Lalmonirhat")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Lalmonirhat in Rangpur", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Nilphamari")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Nilphamari in Rangpur", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Panchagarh")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Panchagarh in Rangpur", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Rangpur")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Rangpur in Rangpur", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Thakurgaon")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Thakurgaon in Rangpur", Toast.LENGTH_SHORT).show();
                        }
                    } else if (selectedDivision.equals("Mymensingh")) {
                        if (selectedDistrict.equals("Jamalpur")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Jamalpur in Mymensingh", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Mymensingh")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Mymensingh in Mymensingh", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Netrokona")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Netraokona in Mymensingh", Toast.LENGTH_SHORT).show();
                        } else if (selectedDistrict.equals("Sherpur")) {
                            Toast.makeText(HomeWork247_3.this, "You have selected Sherpur in Mymensingh", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(HomeWork247_3.this, "Please select a district", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
