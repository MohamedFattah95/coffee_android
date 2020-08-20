package com.mohamedfattah95.coffee.di.module;

import android.app.Application;
import android.content.Context;

import com.mohamedfattah95.coffee.BuildConfig;
import com.mohamedfattah95.coffee.R;
import com.mohamedfattah95.coffee.data.BaseDataManager;
import com.mohamedfattah95.coffee.data.DataManager;
import com.mohamedfattah95.coffee.data.network.NetworkService;
import com.mohamedfattah95.coffee.data.network.RestApiHelper;
import com.mohamedfattah95.coffee.data.network.RestApiManager;
import com.mohamedfattah95.coffee.di.ApiInfo;
import com.mohamedfattah95.coffee.di.ApplicationContext;
import com.mohamedfattah95.coffee.di.DatabaseInfo;
import com.mohamedfattah95.coffee.di.PreferenceInfo;
import com.mohamedfattah95.coffee.root.AppConstant;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application) {
        this.mApplication = application;
    }


    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstant.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstant.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(BaseDataManager mDataManager) {
        return mDataManager;
    }


    @Provides
    @Singleton
    RestApiHelper provideRestApiHelper(RestApiManager restApiManager) {
        return restApiManager;
    }

//
//    /**
//     * @return HTTTP Client
//     */
//    @Provides
//    public OkHttpClient provideClient() {
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//
//        String token = mApplication.getSharedPreferences(providePreferenceName(), Context.MODE_PRIVATE).getString(PreferencesManager.PREF_KEY_ACCESS_TOKEN, "guest");
//        Log.i("token", token);
//
//        return new OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(chain -> {
//            Request original = chain.request();
//
//            Request request = original.newBuilder()
//                    .header("Authorization", "Bearer " + token)
//                    .header("Accept", "application/json")
//                    .method(original.method(), original.body())
//                    .build();
//
//            return chain.proceed(request);
//        }).build();
//    }

    /**
     * @return HTTTP Client
     */
    @Provides
    public OkHttpClient provideClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(chain -> {
            Request.Builder requestBuilder = chain.request().newBuilder();
            return chain.proceed(requestBuilder.build());
        }).build();
    }

    /**
     * provide Retrofit instances
     *
     * @param baseURL base url for api calling
     * @param client  OkHttp client
     * @return Retrofit instances
     */

    @Provides
    public Retrofit provideRetrofit(String baseURL, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Provide Api service
     *
     * @return ApiService instances
     */
    @Provides
    public NetworkService provideApiService() {
        return provideRetrofit(BuildConfig.BASE_URL, provideClient()).create(NetworkService.class);
    }

    @Provides
    @Singleton
    ViewPump.Builder provideCalligraphyDefaultConfig() {
        return ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/avenir_regular.otf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()));

    }

}
