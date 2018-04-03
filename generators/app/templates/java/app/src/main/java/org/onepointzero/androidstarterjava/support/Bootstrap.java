package <%= packageName %>.support;

import android.app.Application;

import <%= packageName %>.support.config.Configuration;
import <%= packageName %>.support.config.ProdConfiguration;
import <%= packageName %>.support.di.AppComponent;
import <%= packageName %>.support.di.AppModule;
import <%= packageName %>.support.di.DaggerAppComponent;

public class Bootstrap extends Application {
    AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        AppModule appModule = new AppModule(this.getApplicationContext(), getConfiguration());
        component = DaggerAppComponent.builder().appModule(appModule).build();
    }

    public AppComponent getComponent() {
        return component;
    }

    public void setComponent(AppComponent component) {
        this.component = component;
    }

    public Configuration getConfiguration() {
        return new ProdConfiguration();
    }
}
