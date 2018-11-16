package com.example.sergei.workshopproject.instructions;

import android.app.Application;
import android.arch.lifecycle.ViewModelProviders;
import android.support.test.InstrumentationRegistry;

import com.azimolabs.conditionwatcher.Instruction;
import com.example.sergei.workshopproject.view.MainActivity;
import com.example.sergei.workshopproject.viewmodel.UserViewModel;

public class WaitRefreshmentInstruction extends Instruction {

    MainActivity mainActivity;

    public WaitRefreshmentInstruction(){}


    public WaitRefreshmentInstruction(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    public String getDescription() {
        return "Wee have to wait till adapter refresh elements";
    }

    @Override
    public boolean checkCondition() {

        UserViewModel user = ViewModelProviders.of(mainActivity).get(UserViewModel.class);

        while (user.isLoading() == null || user.isLoading()) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // just because of test
            }
        }

        return true;
    }
}
