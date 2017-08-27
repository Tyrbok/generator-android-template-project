package <%= packageName %>.infraestructure;

import android.content.Context;

import <%= packageName %>.R;
import <%= packageName %>.domain.StarterData;
import <%= packageName %>.domain.StarterDataRepository;

import io.reactivex.Single;

public class DummyStarterDataRepository implements StarterDataRepository {

    Context context;

    public DummyStarterDataRepository(Context context) {
        this.context = context;
    }

    @Override
    public Single<StarterData> getStarterData() {

        String appName = context.getResources().getString(R.string.app_name);

        StarterData data = new StarterData("Hello " + appName + "!");
        return Single.just(data);
    }
}
