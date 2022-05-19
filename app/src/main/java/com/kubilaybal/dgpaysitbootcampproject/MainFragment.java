package com.kubilaybal.dgpaysitbootcampproject;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kubilaybal.dgpaysitbootcampproject.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    BaseViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(BaseViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        View view = binding.getRoot();
        viewModel.getCoins();
        //fillInText();
        return view;
    }

    public void fillInText(){
        System.out.println(viewModel.coinList.size());
        binding.coinTextView.setText(viewModel.coinList.get(0).getCoin());
        binding.coinTextView1.setText(viewModel.coinList.get(1).getCoin());
        binding.coinTextView2.setText(viewModel.coinList.get(2).getCoin());
        binding.coinTextView3.setText(viewModel.coinList.get(3).getCoin());
    }
}