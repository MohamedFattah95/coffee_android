package com.mohamedfattah95.coffee.ui.main;


import com.mohamedfattah95.coffee.data.network.pojo.ProductResponse;
import com.mohamedfattah95.coffee.ui.base.MvpView;

import java.util.List;

/**
 * Created on : Feb 11, 2019
 * Author     : AndroidWave
 */
public interface MainMvpView extends MvpView {

    void updateProduct(ProductResponse.ProductBean product);
}
