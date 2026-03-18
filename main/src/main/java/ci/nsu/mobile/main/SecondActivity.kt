package ci.nsu.mobile.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ci.nsu.mobile.main.ui.main.SecondFragment

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SecondFragment.newInstance())
                .commitNow()
        }
    }
}