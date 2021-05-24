package com.example.moneymanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moneymanager.pojos.Manager;
import com.example.moneymanager.viewmodel.AppViewModel;

import java.util.ArrayList;
import java.util.List;


public class ExpensesActivity extends AppCompatActivity {
    Toolbar toolbarA;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    AppViewModel mAppViweModel;


    public int getDrawableId(Context context, String title) {
        return context.getResources().getIdentifier(title, "drawable", context.getPackageName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);
        recyclerView = findViewById(R.id.recylcerview);
        mAppViweModel = ViewModelProviders.of(this).get(AppViewModel.class);


        mAppViweModel.retrieveManager("expenses").observe(this, new Observer<List<Manager>>() {
            @Override
            public void onChanged(List<Manager> managers) {
                adapter = new RecyclerViewAdapter(ExpensesActivity.this, managers);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(ExpensesActivity.this, 4, GridLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(gridLayoutManager);
                recyclerView.setAdapter(adapter);

            }
        });


        toolbarA = findViewById(R.id.Ctoolbar);
        TextView toolbarTitle = findViewById(R.id.titletxt);
        TextView toolbarCount = findViewById(R.id.titleCount);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (NullPointerException nu) {
            Log.i("Error", "error activity:" + nu.getMessage());
        }

        toolbarA.setTitle("");
        toolbarTitle.setText("Expenses");
        toolbarCount.setText("");
        setSupportActionBar(toolbarA);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.categories_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        switch (item.getItemId()) {
            case R.id.expenses:
                Intent intent = new Intent(this, ExpensesActivity.class);
                startActivity(intent);
                Toast.makeText(this, "Expenses", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.income:
                Intent intent1 = new Intent(this, IncomeActivity.class);
                startActivity(intent1);

                Toast.makeText(this, "Income", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void add(View view) {
        Intent intent = new Intent(ExpensesActivity.this, Categories.class);
        startActivity(intent);
    }
}