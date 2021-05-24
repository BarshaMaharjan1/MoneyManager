package com.example.moneymanager.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "tbl_expenses")
public class Expenses implements Serializable {

    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("title")
    private String title;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public Expenses(int id,String name,String title)
    {
        this.id=id;
        this.name=name;
        this.title=title;
    }
}
