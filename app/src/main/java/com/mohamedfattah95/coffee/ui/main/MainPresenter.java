package com.mohamedfattah95.coffee.ui.main;

import com.mohamedfattah95.coffee.data.DataManager;
import com.mohamedfattah95.coffee.ui.base.BasePresenter;
import com.mohamedfattah95.coffee.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created on : Feb 11, 2019
 * Author     : AndroidWave
 */
public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {
    @Inject
    public MainPresenter(DataManager manager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(manager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void getProduct(String id) {

        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager()
                .getProductApiCall(id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    if (!isViewAttached()) {
                        return;
                    }

                    getMvpView().hideLoading();

                    getMvpView().updateProduct(response.getProduct());


                }, error -> {
                    if (!isViewAttached()) {
                        return;
                    }
                    getMvpView().hideLoading();

                    /**
                     * manage all kind of error in single place
                     */
                    handleApiError(error);
                }));

    }

    @Override
    public void makeOrder(String userId, String productId, String branchId, String additionIds,
                          String subAddIds, String qty) {

        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager()
                .makeOrderApiCall(userId, productId, branchId, additionIds, subAddIds, qty)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    if (!isViewAttached()) {
                        return;
                    }

                    getMvpView().hideLoading();

                    getMvpView().showMessage(response.getStatus());


                }, error -> {
                    if (!isViewAttached()) {
                        return;
                    }
                    getMvpView().hideLoading();

                    /**
                     * manage all kind of error in single place
                     */
                    handleApiError(error);
                }));

    }

}
