package <%= packageName %>.support;

import android.app.Application;

import <%= packageName %>.support.config.Configuration;
import <%= packageName %>.support.config.ProdConfiguration;
import <%= packageName %>.support.di.AppComponent;
import <%= packageName %>.support.di.AppModule;
import <%= packageName %>.support.di.DaggerAppComponent;

public class Bootstrap extends Application {
    public AppComponent getComponent() {
        AppModule appModule = new AppModule(this.getApplicationContext(), getConfiguration());
        return DaggerAppComponent.builder().appModule(appModule).build();
    }

    public Configuration getConfiguration() {
        return new ProdConfiguration();
    }
}
