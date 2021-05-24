package com.example.moneymanager.dao;

import android.view.View;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.moneymanager.db.Expenses;
import com.example.moneymanager.db.Income;

import java.util.List;

@Dao
public interface CategoryDao {

    @Query("select * from tbl_expenses")
    List<Expenses> getAllExpenses();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertExpenses(Expenses expenses);

    @Delete
    void deleteExpenses(Expenses expenses);

    @Update
    void updateExpenses(Expenses expenses);

    @Query("select * from tbl_income")
    List<Income> getAllIncome();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertIncome(Income income);

    @Delete
    void deleteIncome(Income income);

    @Update
    void updateIncome(Income income);


}
