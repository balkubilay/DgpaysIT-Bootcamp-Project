package com.kubilaybal.dgpaysitbootcampproject;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiService {
    @GET("coins?list=BTC,BCH,BSV,ETH")
    @Headers({"x-rapidapi-host:mineable-coins.p.rapidapi.com", "x-rapidapi-key:48809b7ce1msh0a3ff7c8551d11fp128fb8jsncf4fe9e61134"})
    Observable<List<CoinsResponseModel>> coinList();
}
