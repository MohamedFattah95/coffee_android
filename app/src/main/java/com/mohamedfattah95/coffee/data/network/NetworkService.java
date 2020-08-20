package com.mohamedfattah95.coffee.data.network;

import com.mohamedfattah95.coffee.data.network.pojo.ProductResponse;
import com.mohamedfattah95.coffee.data.network.pojo.StoreOrderResponse;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface NetworkService {
    /**
     * @return Observable feed response
     */

    @FormUrlEncoded
    @POST("Product")
    Single<ProductResponse> getProductApiCall(@Field("id") String id);

    @FormUrlEncoded
    @POST("store_Order")
    Single<StoreOrderResponse> makeOrderApiCall(@Field("user_id") String userId,
                                                @Field("product_id") String productId,
                                                @Field("brunche_id") String branchId,
                                                @Field("addition") String addIds,
                                                @Field("subadd") String subAddIds,
                                                @Field("count") String qty);

}
