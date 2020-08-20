package com.mohamedfattah95.coffee.di.component;

import android.app.Application;
import android.content.Context;

import com.mohamedfattah95.coffee.data.DataManager;
import com.mohamedfattah95.coffee.di.ApplicationContext;
import com.mohamedfattah95.coffee.di.module.ApplicationModule;
import com.mohamedfattah95.coffee.root.WaveApp;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(WaveApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
//    @Component.Builder
//    interface Builder {
//        ApplicationComponent build();
//
//        Builder applicationModule(ApplicationModule applicationModule);
//
//        DataManager getDataManager();
//    }


}
