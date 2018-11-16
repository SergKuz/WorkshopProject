package com.example.sergei.workshopproject.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.sergei.workshopproject.R;
import com.example.sergei.workshopproject.databinding.ActivityMainBinding;
import com.example.sergei.workshopproject.model.User;
import com.example.sergei.workshopproject.viewmodel.UserViewModel;

import static android.widget.LinearLayout.VERTICAL;


public class MainActivity extends AppCompatActivity implements MyListAdapter.ListAdapterListener {

    UserViewModel user;
    MyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        user = ViewModelProviders.of(this).get(UserViewModel.class);

        final ActivityMainBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);

        binding.setLifecycleOwner(this);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.addItemDecoration(new DividerItemDecoration(this, VERTICAL));
        binding.recycler.setItemAnimator(new DefaultItemAnimator());

        adapter = new MyListAdapter(user.generateUsersList(), this);
        binding.recycler.setAdapter(adapter);

        // по нажатию кнопки запускаем обновление списка с задержкой
        // так, как бы обновления пришли с сервера
        // можно было бы реализовать всё через обновление livedata переменной,
        // но решил не заморачиваться ради черновика
        binding.refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.clear();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        user.startLoading();
                        adapter.addAll(user.generateUsersList());

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                                user.endedLoading();
                            }
                        });
                    }
                }).start();
            }
        });
    }

    @Override
    public void onItemClicked(User post) {
        Toast.makeText(this, post.getUsername(), Toast.LENGTH_LONG).show();
    }
}
