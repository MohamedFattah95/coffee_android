package com.mohamedfattah95.coffee.data.network;

import com.mohamedfattah95.coffee.data.network.pojo.ProductResponse;
import com.mohamedfattah95.coffee.data.network.pojo.StoreOrderResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class RestApiManager implements RestApiHelper {

    private NetworkService mService;

    @Inject
    public RestApiManager(NetworkService apiService) {
        mService = apiService;
    }

    @Override
    public Single<ProductResponse> getProductApiCall(String id) {
        return mService.getProductApiCall(id);
    }

    @Override
    public Single<StoreOrderResponse> makeOrderApiCall(String userId, String productId, String branchId, String addIds, String subAddIds, String qty) {
        return mService.makeOrderApiCall(userId, productId, branchId, addIds, subAddIds, qty);
    }
}
