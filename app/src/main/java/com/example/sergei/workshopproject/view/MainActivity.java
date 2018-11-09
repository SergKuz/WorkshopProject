package com.example.sergei.workshopproject.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.sergei.workshopproject.R;
import com.example.sergei.workshopproject.databinding.ActivityMainBinding;
import com.example.sergei.workshopproject.model.User;
import com.example.sergei.workshopproject.viewmodel.UserViewModel;

import static android.widget.LinearLayout.VERTICAL;


public class MainActivity extends AppCompatActivity implements MyListAdapter.ListAdapterListener{

    UserViewModel user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        user = ViewModelProviders.of(this).get(UserViewModel.class);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.addItemDecoration(new DividerItemDecoration(this, VERTICAL));
        binding.recycler.setItemAnimator(new DefaultItemAnimator());
        binding.recycler.setAdapter(new MyListAdapter(user.generateUsersList(),this));

    }

    @Override
    public void onItemClicked(User post) {
        Toast.makeText(this, post.getUsername(), Toast.LENGTH_LONG).show();
    }
}
