package ci.nsu.mobile.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
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
        setupActionBar()
    }

    private fun setupActionBar() {
        // Доступ к ActionBar через supportActionBar
        val actionBar = supportActionBar

        actionBar?.apply {
            // Включаем кнопку «Назад» (стрелку)
            setDisplayHomeAsUpEnabled(true)
            // Показываем иконку «Домой» (обычно это логотип приложения)
            setDisplayShowHomeEnabled(true)
            // Устанавливаем заголовок
            title = "Second Activity"
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}