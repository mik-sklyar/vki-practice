package ci.nsu.mobile.main.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _openSecondActivityEvent = MutableLiveData<String?>()
    val openSecondActivityEvent: LiveData<String?> get() = _openSecondActivityEvent

    private val _showEmptyTextFieldErrorEvent = MutableLiveData<Unit>()
    val showEmptyTextFieldErrorEvent: LiveData<Unit> get() = _showEmptyTextFieldErrorEvent

    fun onButtonClicked(inputText: String = "") {
        Log.d("Lab3", "Button clicked")

        // TODO: Some logic here to process text
        val processedText = inputText.trim()

        if (processedText.isNotEmpty()) {
            _openSecondActivityEvent.value = processedText
        } else {
            _showEmptyTextFieldErrorEvent.value = Unit
        }
    }
}