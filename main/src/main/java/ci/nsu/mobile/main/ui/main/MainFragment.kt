package ci.nsu.mobile.main.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ci.nsu.mobile.main.R
import ci.nsu.mobile.main.SecondActivity

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editText = view.findViewById<EditText>(R.id.edit_text_text)
        val button = view.findViewById<Button>(R.id.button_open_second)

        button.setOnClickListener {
            viewModel.onButtonClicked(editText.text.toString())
        }

        viewModel.openSecondActivityEvent.observe(viewLifecycleOwner) { text ->
            text?.let { validText ->
                openSecondActivity(validText)
            }
        }
    }

    fun showError() {
        Toast.makeText(requireContext(), "Поле не должно быть пустым!", Toast.LENGTH_SHORT).show()
    }

    private fun openSecondActivity(text: String) {
        if (text.isEmpty()) {
            showError()
            return
        }

        val context = requireContext()

        val intent = Intent(context, SecondActivity::class.java)
        intent.putExtra("EXTRA_TEXT", text)
        context.startActivity(intent)
    }
}