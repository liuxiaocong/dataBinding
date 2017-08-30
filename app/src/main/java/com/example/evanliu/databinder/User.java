package com.example.evanliu.databinder;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by xiaoconglau on 30/08/2017.
 */

public class User extends BaseObservable {
    private String name;
    private String age;
    private String avatar;

    @Bindable
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
        notifyPropertyChanged(BR.avatar);
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setAge(String age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
}
