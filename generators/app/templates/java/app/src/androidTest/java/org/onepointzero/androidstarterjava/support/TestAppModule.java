package <%= packageName %>.support;

import android.content.Context;

import <%= packageName %>.domain.StarterData;
import <%= packageName %>.domain.StarterDataRepository;
import <%= packageName %>.support.config.Configuration;
import <%= packageName %>.support.di.AppModule;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Single;

@Module
public class TestAppModule extends AppModule {
    private String message = "Test App Module Message";

    public void setMessage(String message) {
        this.message = message;
    }

    public TestAppModule(Context context, Configuration configuration) {
        super(context, configuration);
    }

    @Provides
    @Override
    public StarterDataRepository starterDataRepository() {
        return () -> Single.just(new StarterData(message));
    }

}
