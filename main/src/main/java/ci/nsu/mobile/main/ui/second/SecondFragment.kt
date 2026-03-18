package ci.nsu.mobile.main.ui.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ci.nsu.mobile.main.R

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val intent = requireActivity().intent
        val receivedText = intent.getStringExtra("EXTRA_TEXT")
        if (receivedText == null) {
            return
        }

        val textView = view.findViewById<TextView>(R.id.message)
        textView.text = "From main activity:\n$receivedText\n\n with Love))"
    }

}