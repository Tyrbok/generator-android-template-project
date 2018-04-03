package <%= packageName %>.application;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter {
    private final GetStarterData getStarterData;
    private MainScreen screen;

    private List<Disposable> disposables = new ArrayList<>();

    public MainPresenter(GetStarterData getStarterData) {
        this.getStarterData = getStarterData;
    }

    void bind(MainScreen screen) {
        this.screen = screen;

        Disposable disposable = getStarterData.execute()

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(message -> screen.showLabel(message));

        disposables.add(disposable);
    }

    void unbind() {
        for (Disposable disposable: disposables) {
            disposable.dispose();
        }
    }
}
