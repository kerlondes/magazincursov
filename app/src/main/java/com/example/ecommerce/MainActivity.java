package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.ecommerce.adapters.Category_adapter;
import com.example.ecommerce.adapters.Course_adapter;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler,courseRecycler;
    Category_adapter categoryAdapter;

    static Course_adapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCoursesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Игры"));
        categoryList.add(new Category(2,"Сайты"));
        categoryList.add(new Category(3,"Языки"));
        categoryList.add(new Category(4,"Прочее"));

        setCategoryRecycler(categoryList);

        courseList.add(new Course(1,"javamini2","Профессия Java\nразработчик","1 января","начальный","#000000","test",3));
        courseList.add(new Course(2,"pyton","Профессия Pyton\nразработчик","10 января","начальный","#9FA52D","test",3));
        courseList.add(new Course(3,"unity1","Unity\nразработчик","12 января","начальный","#5bb825","test",1));
        courseList.add(new Course(4,"web1","Web\nразработчик","18 января","начальный","#b82525","test",2));
        courseList.add(new Course(5,"front1","Front-End\nразработчик","2 декабря","начальный","#b8a025","test",4));
        courseList.add(new Course(6,"back1","Back-End\nразработчик","18 марта","начальный","#9825b8","test",4));
        SharedPreferences pref = getSharedPreferences("mypref", MODE_PRIVATE);

        if(pref.getBoolean("firststart", true)){
            // update sharedpreference - another start wont be the first
            SharedPreferences.Editor editor = pref.edit();
            fullCoursesList.addAll(courseList);
            editor.putBoolean("firststart", false);
            editor.commit(); // apply changes

            // first start, show your dialog | first-run code goes here
        }
        setCourseRecycler(courseList);
    }



    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new Course_adapter(this,courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new Category_adapter(this,categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }
    public static void  showCoursesByCategory(int category){
        courseList.clear();
        courseList.addAll(fullCoursesList);
        List<Course> filterCourses = new ArrayList<>();

        for(Course c: courseList){
            if(c.getCategory() == category)
                filterCourses.add(c);
        }

        courseList.clear();
        courseList.addAll(filterCourses);

        courseAdapter.notifyDataSetChanged();

    }
    public void showAllCourse(View v){
        courseList.clear();
        courseList.addAll(fullCoursesList);
        courseAdapter.notifyDataSetChanged();
    }
    public void openShoopingCart(View v){
        Intent intent = new Intent(this, OrderPage.class);
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
}