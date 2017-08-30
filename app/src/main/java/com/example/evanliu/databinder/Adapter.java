package com.example.evanliu.databinder;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.evanliu.databinder.databinding.ListItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoconglau on 30/08/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<User> data = new ArrayList<>();
    Activity activity;

    public Adapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        ListItemBinding itemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false);
        return new ViewHolder(itemBinding);
    }

    public void setData(List<User> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = data.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ListItemBinding itemBinding;

        public ViewHolder(ListItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        public void bind(User user) {
            itemBinding.setUser(user);
            itemBinding.setHandler(this);
            itemBinding.executePendingBindings();
        }

        public void onClickRoot(User user) {
            Toast.makeText(activity, user.getName(), Toast.LENGTH_LONG).show();
        }
    }

//    @BindingAdapter("imageUrl")
//    public static void setImageUrl(ImageView imageView, String url) {
//        Glide.with(imageView.getContext()).load(url).into(imageView);
//    }
}
