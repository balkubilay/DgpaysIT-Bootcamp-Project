package com.kubilaybal.dgpaysitbootcampproject;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseViewModel extends ViewModel {
    ApiService apiService;
    public List<CoinsResponseModel> coinList = new ArrayList<>();

    public void getCoins(){
        apiService = RetrofitBuilder.getClient().create(ApiService.class);

        Call<List<CoinsResponseModel>> call = apiService.coinList();

        call.enqueue(new Callback<List<CoinsResponseModel>>() {
            @Override
            public void onResponse(Call<List<CoinsResponseModel>> call, Response<List<CoinsResponseModel>> response) {
                List<CoinsResponseModel> responseModels = new ArrayList<>();

                System.out.println(response);
                responseModels = response.body();
                if (responseModels != null) {
                    for (int i = 0; i<responseModels.size(); i++){
                        System.out.println(""+responseModels.get(i).getCoin());
                        coinList.add(responseModels.get(i));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<CoinsResponseModel>> call, Throwable t) {
                System.out.println(t.getLocalizedMessage());

            }
        });
    }
}
