package com.example.sergei.workshopproject.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.sergei.workshopproject.model.User;

import java.util.LinkedList;
import java.util.List;

public class UserViewModel extends ViewModel {

    public MutableLiveData<User> rooms = new MutableLiveData<>();
    public MutableLiveData<User> user = new MutableLiveData<>();

    public List<User> generateUsersList() {
        List<User> result = new LinkedList<>();

        for (int i= 0; i < 20; i++) {
            result.add(new User("User ".concat(String.valueOf(i)), "Google", i%3 == 0));
        }

        return result;
    }
}
