package ci.nsu.mobile.main.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _openSecondActivityEvent = MutableLiveData<String?>()
    val openSecondActivityEvent: LiveData<String?> = _openSecondActivityEvent

    fun onButtonClicked(inputText: String = "") {
        Log.d("Lab3", "Button clicked")

        val trimmedText = inputText.trim()

        // TODO: Some logic here
        _openSecondActivityEvent.value = trimmedText.ifEmpty { null }
    }
}