package ci.nsu.moble.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    private val defaultColor = Color.LightGray
    val colorsMap: Map<String, Color> = mapOf(
        "Red" to Color.Red,
        "Blue" to Color.Blue,
        "Green" to Color.Green,
        "Yellow" to Color.Yellow,
        "Magenta" to Color.Magenta,
    )
    private val normMap = colorsMap.mapKeys { it.key.lowercase() }
    private val _colorInput = mutableStateOf("")
    val colorInput: MutableState<String> = _colorInput

    private val _buttonColor = mutableStateOf(defaultColor)
    val buttonColor: MutableState<Color> = _buttonColor

    private fun applyColor(color: Color) {
        _buttonColor.value = color
    }

    fun updateColorInput(newText: String) {
        _colorInput.value = newText
    }

    fun submitColor() {
        val input = _colorInput.value.lowercase().trim()
        if (input.isBlank()) {
            Log.w("ColorInput", "TextField is empty")
            return
        }

        val color = normMap[input]
        if (color != null) {
            applyColor(color)
            Log.d("ColorInput", "Applied color: $input")
        } else {
            applyColor(defaultColor)
            Log.d("ColorInput", "incorrect input")
        }
    }

    fun logColor(name: String) {
        Log.d("ColorMap", "Color: $name")
    }
}