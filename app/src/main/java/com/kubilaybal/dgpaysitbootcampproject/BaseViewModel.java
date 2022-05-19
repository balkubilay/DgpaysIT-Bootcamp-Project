package com.kubilaybal.dgpaysitbootcampproject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class BaseViewModel extends ViewModel {
    ApiService apiService;
    private MutableLiveData<List<CoinsResponseModel>> liveDataForCoinList = new MutableLiveData<>();

    public MutableLiveData<List<CoinsResponseModel>> getLiveData() {
        return liveDataForCoinList;
    }

    public void getCoins() {
        apiService = RetrofitBuilder.getClient().create(ApiService.class);
        apiService.coinList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<CoinsResponseModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<CoinsResponseModel> coinsResponseModels) {
                        for (int i = 0; i < coinsResponseModels.size(); i++) {
                            System.out.println(coinsResponseModels.get(i).toString());
                            System.out.println("" + coinsResponseModels.get(i).getCoin());
                            MainActivity.coinList.add(coinsResponseModels.get(i));
                            liveDataForCoinList.postValue(MainActivity.coinList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
