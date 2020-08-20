package com.mohamedfattah95.coffee.di.component;


import com.mohamedfattah95.coffee.di.PerActivity;
import com.mohamedfattah95.coffee.di.module.ActivityModule;
import com.mohamedfattah95.coffee.ui.main.MainActivity;
import com.mohamedfattah95.coffee.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(SplashActivity activity);

}