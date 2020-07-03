package com.bored.boredapp.ui;

import android.app.Application;

import com.bored.boredapp.base.BaseViewModel;
import com.bored.boredapp.binding.command.BindingAction;
import com.bored.boredapp.binding.command.BindingCommand;

import androidx.annotation.NonNull;

/**
 * @author weijian.huang 2020/7/3
 * @Package com.bored.boredapp.ui
 * @Title: MainViewModel
 * @Description: (用一句话描述该文件做什么)
 * Copyright (c) 传化公路港物流有限公司版权所有
 * Create DateTime: 2020/7/3
 */
public class MainViewModel extends BaseViewModel {
    public MainViewModel(@NonNull Application application) {
        super(application);
    }
    //网络访问点击事件
    public BindingCommand netWorkClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startContainerActivity(NetWorkFragment.class.getCanonicalName());
        }
    });
}
