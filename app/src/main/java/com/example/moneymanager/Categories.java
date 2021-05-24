package com.example.moneymanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Categories extends AppCompatActivity {

    Toolbar toolbarA;
    RecyclerView recyclerView;
    List<String> titles;
    List<Integer> images;
    RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        toolbarA = findViewById(R.id.Ctoolbar);
        setSupportActionBar(toolbarA);
        TextView toolbarTitle = findViewById(R.id.titletxt);
        TextView toolbarCount = findViewById(R.id.titleCount);

        toolbarA.setTitle("");
        toolbarTitle.setText("Add expense category");
        toolbarCount.setText("");
        setSupportActionBar(toolbarA);

        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("food");
        titles.add("bills");
        titles.add("transportation");
        titles.add("home");
        titles.add("car");
        titles.add("entertainment");
        titles.add("shopping");
        titles.add("clothing");
        titles.add("insurance");
        titles.add("tax");
        titles.add("telephone");
        titles.add("cigarette");
        titles.add("health");
        titles.add("sport");
        titles.add("baby");
        titles.add("pet");
        titles.add("baeuty");
        titles.add("electronics");
        titles.add("hamburger");
        titles.add("wine");
        titles.add("vegetables");
        titles.add("snacks");
        titles.add("gift");
        titles.add("social");
        titles.add("travel");
        titles.add("education");
        titles.add("fruits");
        titles.add("book");
        titles.add("office");
        titles.add("pizza");
        titles.add("fish");
        titles.add("ac");
        titles.add("others");
        titles.add("Salary");
        titles.add("Awards");
        titles.add("Grants");
        titles.add("Sale");
        titles.add("Rental");
        titles.add("Refunds");
        titles.add("Coupons");
        titles.add("Lottery");
        titles.add("Dividends");
        titles.add("Investments");
        titles.add("others");
        titles.add("add");


        images.add(R.drawable.food);
        images.add(R.drawable.bills);
        images.add(R.drawable.transportation);
        images.add(R.drawable.home);
        images.add(R.drawable.car);
        images.add(R.drawable.entertainment);
        images.add(R.drawable.shopping);
        images.add(R.drawable.clothing);
        images.add(R.drawable.insurance);
        images.add(R.drawable.tax);
        images.add(R.drawable.telephone);
        images.add(R.drawable.cigarette);
        images.add(R.drawable.health);
        images.add(R.drawable.sport);
        images.add(R.drawable.baby);
        images.add(R.drawable.dog);
        images.add(R.drawable.beauty);
        images.add(R.drawable.electronics);
        images.add(R.drawable.hamburger);
        images.add(R.drawable.wine);
        images.add(R.drawable.vegetable);
        images.add(R.drawable.snack);
        images.add(R.drawable.gift);
        images.add(R.drawable.social);
        images.add(R.drawable.travel);
        images.add(R.drawable.education);
        images.add(R.drawable.fruits);
        images.add(R.drawable.book);
        images.add(R.drawable.office);
        images.add(R.drawable.pizza);
        images.add(R.drawable.fish);
        images.add(R.drawable.ac);
        images.add(R.drawable.others);
        images.add(R.drawable.salary);
        images.add(R.drawable.awards);
        images.add(R.drawable.grants);
        images.add(R.drawable.sale);
        images.add(R.drawable.rental);
        images.add(R.drawable.refunds);
        images.add(R.drawable.coupons);
        images.add(R.drawable.lottery);
        images.add(R.drawable.dividends);
        images.add(R.drawable.investments);
        images.add(R.drawable.others);
        images.add(R.drawable.add);


        recyclerView = findViewById(R.id.recylcerview1);

//        adapter = new RecyclerViewAdapter(this, titles, images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.categories_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.expenses:
//                Intent intent=new Intent(this, ExpensesActivity.class);
//                startActivity(intent);
//                Toast.makeText(this, "Expenses" , Toast.LENGTH_SHORT).show();
//
//                return true;
//
//            case R.id.income:
//              Intent intent1=new Intent(this,IncomeActivity.class);
//              startActivity(intent1);
//
//       Toast.makeText(this, "Income" , Toast.LENGTH_SHORT).show();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}