package <%= packageName %>.application

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainPresenter(private val getStarterData: GetStarterData) {

    fun bind(screen: MainScreen) {
        getStarterData.execute()

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe {
                    item -> screen.printText(item)
                }

    }
}