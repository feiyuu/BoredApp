package com.bored.boredapp.ui;

import android.os.Bundle;

import com.bored.boredapp.BR;
import com.bored.boredapp.R;
import com.bored.boredapp.base.BaseActivity;
import com.bored.boredapp.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainViewModel> {


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
