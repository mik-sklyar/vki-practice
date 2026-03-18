package ci.nsu.mobile.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import ci.nsu.mobile.main.ui.second.ProfileFragment
import ci.nsu.mobile.main.ui.second.SecondFragment
import ci.nsu.mobile.main.ui.second.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class SecondActivity : AppCompatActivity() {

    private val homeFragment = SecondFragment()
    private val profileFragment = ProfileFragment()
    private val settingsFragment = SettingsFragment()

    private var currentFragment: Fragment = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Устанавливаем начальный фрагмент, только если это первое создание активности
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, currentFragment)
                .setTransition(FragmentTransaction.TRANSIT_NONE).commitNow()
        }

        setupActionBar()
        setupBottomBar()
    }

    private fun setupBottomBar() {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> replaceFragment(homeFragment)
                R.id.nav_profile -> replaceFragment(profileFragment)
                R.id.nav_settings -> replaceFragment(settingsFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        // Меняем фрагмент только если он отличается от текущего
        if (currentFragment != fragment) {
            currentFragment = fragment
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_NONE)
                .commit()
        }
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