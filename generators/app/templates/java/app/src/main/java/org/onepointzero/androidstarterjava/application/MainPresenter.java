package <%= packageName %>.application;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter {
    private final GetStarterData getStarterData;
    private MainScreen screen;

    public MainPresenter(GetStarterData getStarterData) {
        this.getStarterData = getStarterData;
    }

    void bind(MainScreen screen) {
        this.screen = screen;

        getStarterData.execute()

                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())

                .subscribe(screen::showLabel);
    }
}
