package ci.nsu.moble.main

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {
    private val _buttonData = mutableMapOf(
        "Красный" to Color.Red,
        "Синий" to Color.Blue,
        "Зелёный" to Color.Green,
        "Фиолетовый" to Color(0xFF800080) // HEX-цвет
    )
    val buttonData: Map<String, Color> = _buttonData

    // Метод для динамического добавления кнопки (опционально)
    fun addButton(text: String, color: Color) {
        _buttonData[text] = color
    }
}