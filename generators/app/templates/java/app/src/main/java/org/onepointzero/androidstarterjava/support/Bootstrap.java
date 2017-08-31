package <%= packageName %>.support;

import android.app.Application;

import <%= packageName %>.support.config.Configuration;
import <%= packageName %>.support.config.ProdConfiguration;
import <%= packageName %>.support.di.AppComponent;
import <%= packageName %>.support.di.AppModule;
import <%= packageName %>.support.di.DaggerAppComponent;

public class Bootstrap extends Application {
    AppModule appModule;

    @Override
    public void onCreate() {
        super.onCreate();

        appModule = new AppModule(this.getApplicationContext(), getConfiguration());
    }

    public AppComponent getComponent() {
        return DaggerAppComponent.builder().appModule(appModule).build();
    }

    public Configuration getConfiguration() {
        return new ProdConfiguration();
    }
}
