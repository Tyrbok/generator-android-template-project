package <%= packageName %>.support.di;

import android.content.Context;

import <%= packageName %>.application.GetStarterData;
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
    MainPresenter mainPresenter(GetStarterData getStarterData) {
        return new MainPresenter(getStarterData);
    }

    @Provides
    StarterDataRepository starterDataRepository() {
        return new DummyStarterDataRepository(context);
    }

    @Provides
    GetStarterData getStarterData(StarterDataRepository starterDataRepository) {
        return new GetStarterData(starterDataRepository);
    }
}
