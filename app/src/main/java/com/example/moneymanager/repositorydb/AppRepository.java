package com.example.moneymanager.repositorydb;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.moneymanager.dao.ManagerDao;
import com.example.moneymanager.db.AppDatabase;
import com.example.moneymanager.dao.CategoryDao;
import com.example.moneymanager.db.Expenses;
import com.example.moneymanager.db.Income;
import com.example.moneymanager.pojos.Manager;

import java.util.List;

public class AppRepository {
    private ManagerDao managerDao;
    public AppRepository(Application application)
    {
        AppDatabase db=AppDatabase.getDatabase(application);
        managerDao=db.managerDao();
       ;
    }

    public LiveData<List<Manager>> retrieveManagers(String type)
    {
        return managerDao.retrieveManagers(type);
    }
    public void  insert(Manager manager)
    {
        managerDao.insertManager(manager);
    }

    public void saveManager(Manager manager)
    {

    }
}
