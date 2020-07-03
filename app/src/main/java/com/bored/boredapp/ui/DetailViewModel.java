package com.bored.boredapp.ui;

import android.app.Application;

import com.bored.boredapp.base.BaseViewModel;
import com.bored.boredapp.entity.DemoEntity;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

/**
 * Created by goldze on 2017/7/17.
 */

public class DetailViewModel extends BaseViewModel {
    public ObservableField<DemoEntity.ItemsEntity> entity = new ObservableField<>();

    public DetailViewModel(@NonNull Application application) {
        super(application);
    }

    public void setDemoEntity(DemoEntity.ItemsEntity entity) {
        this.entity.set(entity);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        entity = null;
    }
}
