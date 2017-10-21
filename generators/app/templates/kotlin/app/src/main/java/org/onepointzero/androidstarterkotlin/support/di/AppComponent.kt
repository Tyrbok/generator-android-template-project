package <%= packageName %>.support.di

import <%= packageName %>.application.MainActivity

import dagger.Component
import <%= packageName %>.support.Bootstrap

@Component(modules = arrayOf(AppModule::class)) interface AppComponent {
    fun inject(app: Bootstrap)
    fun inject(activity: MainActivity)
}
