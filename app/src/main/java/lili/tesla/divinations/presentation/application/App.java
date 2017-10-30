package lili.tesla.divinations.presentation.application;

import android.app.Application;

import com.facebook.stetho.Stetho;

import lili.tesla.divinations.BuildConfig;
import lili.tesla.divinations.data.database.DatabaseAccess;

/**
 * Created by Лилия on 25.10.2017.
 */

public class App extends Application{

    private static App instance;
    public static DatabaseAccess databaseAccess;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            stethoInit();
        }

        databaseAccess = new DatabaseAccess(this);

    }

    public static App getInstance() {
        return instance;
    }

    //процедура для просмотра базы с компа
    private void stethoInit() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this)).build());
    }

}


