package ci.nsu.mobile.main.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    fun onButtonClicked() {
        Log.d("Lab3", "Button clicked")
    }
}