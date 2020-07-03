package com.bored.boredapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bored.boredapp.BR;
import com.bored.boredapp.R;
import com.bored.boredapp.base.BaseFragment;
import com.bored.boredapp.databinding.FragmentDetailBinding;
import com.bored.boredapp.entity.DemoEntity;

/**
 * Created by goldze on 2017/7/17.
 * 详情界面
 */

public class DetailFragment extends BaseFragment<FragmentDetailBinding, DetailViewModel> {

    private DemoEntity.ItemsEntity entity;

    @Override
    public void initParam() {
        //获取列表传入的实体
        Bundle mBundle = getArguments();
        if (mBundle != null) {
            entity = mBundle.getParcelable("entity");
        }
    }

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_detail;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        viewModel.setDemoEntity(entity);
    }
}
