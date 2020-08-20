package com.mohamedfattah95.coffee.data;

import android.content.Context;

import com.mohamedfattah95.coffee.data.network.RestApiHelper;
import com.mohamedfattah95.coffee.data.network.pojo.ProductResponse;
import com.mohamedfattah95.coffee.data.network.pojo.StoreOrderResponse;
import com.mohamedfattah95.coffee.di.ApplicationContext;

import javax.inject.Inject;

import io.reactivex.Single;

public class BaseDataManager implements DataManager {
    private static final String TAG = "BaseDataManager";


    private final Context mContext;
    private final RestApiHelper mApiHelper;

    @Inject
    public BaseDataManager(@ApplicationContext Context context,
                           RestApiHelper apiHelper) {
        mContext = context;
        mApiHelper = apiHelper;
    }

    @Override
    public Single<ProductResponse> getProductApiCall(String id) {
        return mApiHelper.getProductApiCall(id);
    }

    @Override
    public Single<StoreOrderResponse> makeOrderApiCall(String userId, String productId, String branchId, String addIds, String subAddIds, String qty) {
        return mApiHelper.makeOrderApiCall(userId, productId, branchId, addIds, subAddIds, qty);
    }
}
