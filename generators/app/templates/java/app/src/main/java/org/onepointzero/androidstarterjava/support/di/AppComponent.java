package <%= packageName %>.support.di;

import <%= packageName %>.application.MainActivity;

import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity activity);
}
