package <%= packageName %>.support.di;

import android.content.Context;

import <%= packageName %>.application.MainPresenter;
import <%= packageName %>.domain.StarterDataRepository;
import <%= packageName %>.infraestructure.DummyStarterDataRepository;
import <%= packageName %>.support.config.Configuration;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    Context context;
    Configuration configuration;

    public AppModule(Context context, Configuration configuration) {
        this.context = context;
        this.configuration = configuration;
    }

    @Provides
    MainPresenter mainPresenter(StarterDataRepository starterDataRepository) {
        return new MainPresenter(starterDataRepository);
    }

    @Provides
    StarterDataRepository starterDataRepository() {
        return new DummyStarterDataRepository(context);
    }
}
