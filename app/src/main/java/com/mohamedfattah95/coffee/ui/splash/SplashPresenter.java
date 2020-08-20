package com.mohamedfattah95.coffee.ui.splash;

import com.mohamedfattah95.coffee.data.DataManager;
import com.mohamedfattah95.coffee.ui.base.BasePresenter;
import com.mohamedfattah95.coffee.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V>
        implements SplashMvpPresenter<V> {
    @Inject
    public SplashPresenter(DataManager manager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(manager, schedulerProvider, compositeDisposable);
    }

}
