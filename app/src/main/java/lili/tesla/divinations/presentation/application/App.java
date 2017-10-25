package lili.tesla.divinations.presentation.application;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Лилия on 25.10.2017.
 */

public class App extends Application{

    //процедура для просмотра базы с компа
    private void stethoInit() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this)).build());
    }

}


