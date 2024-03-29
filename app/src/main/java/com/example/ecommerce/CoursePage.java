package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerce.model.Order;

public class CoursePage extends AppCompatActivity {
    public void goToMain(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void goToProNas(View v){
        Intent intent = new Intent(this, ProNas.class);
        startActivity(intent);
    }
    public void goToContacts(View v){
        Intent intent = new Intent(this, Contacts.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        ConstraintLayout courseBg = findViewById(R.id.coursePageBg);
        ImageView courseImage = findViewById(R.id.coursePageImage);
        TextView courseTitle = findViewById(R.id.coursePageTitle);
        TextView courseDate = findViewById(R.id.coursePageDate);
        TextView courseLevel = findViewById(R.id.coursePageLevel);
        TextView courseText = findViewById(R.id.coursePageText);

        courseBg.setBackgroundColor(getIntent().getIntExtra("courseBg", 0 ));
        courseImage.setImageResource(getIntent().getIntExtra("courseImage", 0 ));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        courseDate.setText(getIntent().getStringExtra("courseDate"));
        courseLevel.setText(getIntent().getStringExtra("courseLevel"));
        courseText.setText(getIntent().getStringExtra("courseText"));
    }

    public void addToCart(View v){
        int item_id = getIntent().getIntExtra("courseId",0);
        Order.items_id.add(item_id);
        Toast.makeText(this,"Добавлено!", Toast.LENGTH_LONG).show();
    }
}