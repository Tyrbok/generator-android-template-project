package <%= packageName %>.application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import <%= packageName %>.R;
import <%= packageName %>.support.Bootstrap;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject MainPresenter presenter;

    @BindView(R.id.label_main)
    TextView labelMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Bootstrap) getApplication()).getComponent().inject(this);

        ButterKnife.bind(this);

        presenter.bind(this);
    }

    @Override
    public void showLabel(String message) {
        labelMain.setText(message);
    }
}
