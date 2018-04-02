package <%= packageName %>.application

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import <%= packageName %>.R
import <%= packageName %>.support.app
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainScreen {

    private val component by lazy { app.component }

    @Inject lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component.inject(this)
        presenter.bind(this)
    }

    override fun printText(text: String) {
        mainLabel.text = text
    }
}
