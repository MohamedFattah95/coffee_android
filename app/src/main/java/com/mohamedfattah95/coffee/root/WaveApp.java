package com.mohamedfattah95.coffee.root;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

import com.mohamedfattah95.coffee.di.component.ApplicationComponent;
import com.mohamedfattah95.coffee.di.component.DaggerApplicationComponent;
import com.mohamedfattah95.coffee.di.module.ApplicationModule;
import com.mohamedfattah95.coffee.utils.LanguageHelper;

import javax.inject.Inject;

import io.github.inflationx.viewpump.ViewPump;


public class WaveApp extends Application {


    private ApplicationComponent mApplicationComponent;
    @Inject
    ViewPump.Builder mCalligraphyConfig;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);

        ViewPump.init(mCalligraphyConfig.build());

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LanguageHelper.onAttach(base, LanguageHelper.getLanguage(base)));
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LanguageHelper.setLanguage(this, LanguageHelper.getLanguage(this));
    }

}
