package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    Button deleteCity;
    Button addCity;
    Button confirmButton;
    EditText cityInput;
    LinearLayout appearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        deleteCity = findViewById(R.id.removeCityButton);
        addCity = findViewById(R.id.addCityButton);
        confirmButton = findViewById(R.id.confirmationButton);
        cityInput = findViewById(R.id.myEditText);
        appearLayout = findViewById(R.id.appearLayout);

        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        appearLayout.setVisibility(View.GONE);

        deleteCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appearLayout.setVisibility(View.VISIBLE);
                confirmButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String cityName = cityInput.getText().toString();
                        if (dataList.contains(cityName)) {
                            dataList.remove(cityName);
                            cityAdapter.notifyDataSetChanged();
                            cityInput.setText("");
                            appearLayout.setVisibility(View.GONE);
                        } else {
                            cityInput.setText("");
                            appearLayout.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        addCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appearLayout.setVisibility(View.VISIBLE);
                confirmButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String cityName = cityInput.getText().toString();
                        dataList.add(cityName);
                        cityAdapter.notifyDataSetChanged();
                        cityInput.setText("");
                        appearLayout.setVisibility(View.GONE);
                    }
                });
            }
        });

    }
}