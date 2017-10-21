package <%= packageName %>.infraestructure

import android.content.Context

import io.reactivex.Single
import <%= packageName %>.R
import <%= packageName %>.domain.StarterData
import <%= packageName %>.domain.StarterDataRepository

class DummyStarterDataRepository(private var context: Context) : StarterDataRepository {

    override fun get(): Single<StarterData> {
        val appName = context.resources.getString(R.string.app_name)

        val data = StarterData("Hello $appName!")
        return Single.just<StarterData>(data)
    }
}
