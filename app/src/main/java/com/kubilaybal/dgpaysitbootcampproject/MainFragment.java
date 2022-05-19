package com.kubilaybal.dgpaysitbootcampproject;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kubilaybal.dgpaysitbootcampproject.databinding.FragmentMainBinding;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    BaseViewModel viewModel;
    NumberFormat formatter = new DecimalFormat("##.##");

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
        Observer<List<CoinsResponseModel>> listObserver = new Observer<List<CoinsResponseModel>>() {
            @Override
            public void onChanged(List<CoinsResponseModel> coinsResponseModels) {
                binding.coinTextView.setText(coinsResponseModels.get(0).getCoin());
                binding.coinTextView1.setText(coinsResponseModels.get(1).getCoin());
                binding.coinTextView2.setText(coinsResponseModels.get(2).getCoin());
                binding.coinTextView3.setText(coinsResponseModels.get(3).getCoin());

                binding.coinLongTextView.setText(coinsResponseModels.get(0).getName());
                binding.coinLongTextView1.setText(coinsResponseModels.get(1).getName());
                binding.coinLongTextView2.setText(coinsResponseModels.get(2).getName());
                binding.coinLongTextView3.setText(coinsResponseModels.get(3).getName());

                binding.amountTextView.setText(String.valueOf(formatter.format(coinsResponseModels.get(0).getPrice())));
                binding.amountTextView1.setText(String.valueOf(formatter.format(coinsResponseModels.get(1).getPrice())));
                binding.amountTextView2.setText(String.valueOf(formatter.format(coinsResponseModels.get(2).getPrice())));
                binding.amountTextView3.setText(String.valueOf(formatter.format(coinsResponseModels.get(3).getPrice())));

                binding.textView.setText(String.valueOf("$" + formatter.format(coinsResponseModels.get(0).getPrice())));
                binding.textView2.setText(String.valueOf("$" + formatter.format(coinsResponseModels.get(1).getPrice())));
                binding.textView3.setText(String.valueOf("$" + formatter.format(coinsResponseModels.get(2).getPrice())));
                binding.textView4.setText(String.valueOf("$" + formatter.format(coinsResponseModels.get(3).getPrice())));

            }
        };
        viewModel.getLiveData().observe(getViewLifecycleOwner(), listObserver);
        return view;
    }

}