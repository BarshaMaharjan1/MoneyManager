package com.example.moneymanager.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.moneymanager.pojos.Manager;
import com.example.moneymanager.repositorydb.AppRepository;

import java.util.List;

public class AppViewModel extends AndroidViewModel {
    private final AppRepository mAppRepository;

    private LiveData<List<Manager>> mManager;

    public AppViewModel(@NonNull Application application) {
        super(application);
     mAppRepository=new AppRepository(application);
//     mManager=mAppRepository.retrieveManagers();
    }
    public LiveData<List<Manager>> retrieveManager(String type)
    {
        return mAppRepository.retrieveManagers(type);
    }

    public void insertManager(Manager manager) {
        mAppRepository.insert(manager);
    }
}
