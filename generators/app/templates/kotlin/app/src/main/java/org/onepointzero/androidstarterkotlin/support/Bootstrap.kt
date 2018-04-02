package <%= packageName %>.support

import android.app.Activity
import android.app.Application
import <%= packageName %>.support.di.AppComponent
import <%= packageName %>.support.di.AppModule
import <%= packageName %>.support.di.DaggerAppComponent

class Bootstrap : Application() {

    var component: AppComponent =
            DaggerAppComponent
                    .builder()
                    .appModule(AppModule(this))
                    .build()

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}

val Activity.app: Bootstrap
    get() = application as Bootstrap
