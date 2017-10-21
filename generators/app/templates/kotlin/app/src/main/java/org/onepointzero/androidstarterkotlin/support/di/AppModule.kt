package <%= packageName %>.support.di

import dagger.Module
import dagger.Provides
import <%= packageName %>.application.GetStarterData
import <%= packageName %>.application.MainPresenter
import <%= packageName %>.domain.StarterDataRepository
import <%= packageName %>.infraestructure.DummyStarterDataRepository
import <%= packageName %>.support.Bootstrap
import javax.inject.Singleton

@Module
@Singleton
class AppModule(val app: Bootstrap) {

    @Provides @Singleton fun provideApp() = app

    @Provides fun mainPresenter(getStarterData: GetStarterData)
            = MainPresenter(getStarterData)

    @Provides fun starterDataRepository(): StarterDataRepository
            = DummyStarterDataRepository(app.applicationContext)

    @Provides fun getStarterData(mainRepository: StarterDataRepository)
            = GetStarterData(mainRepository)
}