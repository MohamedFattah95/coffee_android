package com.mohamedfattah95.coffee.data.network;

import com.mohamedfattah95.coffee.data.network.pojo.ProductResponse;
import com.mohamedfattah95.coffee.data.network.pojo.StoreOrderResponse;

import io.reactivex.Single;

public interface RestApiHelper {
    Single<ProductResponse> getProductApiCall(String id);

    Single<StoreOrderResponse> makeOrderApiCall(String userId,
                                                String productId,
                                                String branchId,
                                                String addIds,
                                                String subAddIds,
                                                String qty);
}
