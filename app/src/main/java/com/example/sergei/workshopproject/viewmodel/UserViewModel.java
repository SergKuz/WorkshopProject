package com.example.sergei.workshopproject.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.sergei.workshopproject.model.User;

import java.util.LinkedList;
import java.util.List;

public class UserViewModel extends ViewModel {

    private int startWith = 0;
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public List<User> generateUsersList() {
        List<User> result = new LinkedList<>();

        if (startWith > 0) { // чтоб убедиться что вызовется только при втором вызове метода
            try {
                // создаем впечатление позднего ответа сервера
                Thread.sleep(3000);
            } catch (Exception e) {
                // just for test empty
            }
        }

        for (int i = 0; i < 20; i++, startWith++) {
            result.add(new User(startWith, i % 3 == 0));
        }

        return result;
    }

    public void startLoading() {
        this.isLoading.postValue(true);
    }

    public void endedLoading(){
        this.isLoading.postValue(false);
    }

    public Boolean isLoading(){
        return this.isLoading.getValue();
    }
}
