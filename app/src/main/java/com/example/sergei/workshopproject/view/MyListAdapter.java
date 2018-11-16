package com.example.sergei.workshopproject.view;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergei.workshopproject.R;
import com.example.sergei.workshopproject.databinding.ListItemBinding;
import com.example.sergei.workshopproject.model.User;

import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyViewHolder>{

    private List<User> userList;
    private LayoutInflater layoutInflater;
    private ListAdapterListener listener;


    public MyListAdapter(List<User> userList, ListAdapterListener listener) {
        this.userList = userList;
        this.listener = listener;
    }

    public void addAll(List<User> userList){
        this.userList.addAll(userList);
    }

    public void clear(){
        this.userList.clear();
    }


    @NonNull
    @Override
    public MyListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        ListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item,
                parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.MyViewHolder holder, final int position) {
        holder.binding.setUser(userList.get(position));

        holder.binding.generalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClicked(userList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ListItemBinding binding;

        public MyViewHolder(final ListItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }

    public interface ListAdapterListener {
        void onItemClicked(User post);
    }
}
