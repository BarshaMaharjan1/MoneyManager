package com.example.moneymanager.pojos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "image")
public class Icon {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image;
}
