package com.mohamedfattah95.coffee.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mohamedfattah95.coffee.di.ActivityContext;
import com.mohamedfattah95.coffee.di.PerActivity;
import com.mohamedfattah95.coffee.ui.main.AdditionsAdapter;
import com.mohamedfattah95.coffee.ui.main.MainMvpPresenter;
import com.mohamedfattah95.coffee.ui.main.MainMvpView;
import com.mohamedfattah95.coffee.ui.main.MainPresenter;
import com.mohamedfattah95.coffee.ui.main.SubAdditionsAdapter;
import com.mohamedfattah95.coffee.ui.splash.SplashMvpPresenter;
import com.mohamedfattah95.coffee.ui.splash.SplashMvpView;
import com.mohamedfattah95.coffee.ui.splash.SplashPresenter;
import com.mohamedfattah95.coffee.utils.rx.AppSchedulerProvider;
import com.mohamedfattah95.coffee.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }


    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    AdditionsAdapter provideAdditionAdapter(){
        return new AdditionsAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(mActivity);
    }

}