package com.mohamedfattah95.coffee.ui.main;


import com.mohamedfattah95.coffee.ui.base.MvpPresenter;

import java.util.List;

/**
 * Created on : Feb 11, 2019
 * Author     : AndroidWave
 */
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void getProduct(String id);

    void makeOrder(String userId, String productId, String branchId, String additionIds, String subAddIds, String qty);
}
