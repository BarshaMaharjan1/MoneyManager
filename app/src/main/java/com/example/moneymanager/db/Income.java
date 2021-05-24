package com.example.moneymanager.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "tbl_income")
public class Income implements Serializable {


    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @SerializedName("incomeid")
    private int incomeid;

    @SerializedName("name")
    private String name;

    @SerializedName("title")
    private String title;

    public int getId() {
        return id;
    }

    public int getIncomeid() {
        return incomeid;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public Income (int id,int incomeid,String name,String title)
    {
        this.id=id;
        this.incomeid=incomeid;
        this.name=name;
        this.title=title;
    }
}
