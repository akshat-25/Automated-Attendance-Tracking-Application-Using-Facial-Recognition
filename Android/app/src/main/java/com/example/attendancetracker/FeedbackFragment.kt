package com.example.attendancetracker

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_feedback.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FeedbackFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FeedbackFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_feedback, container, false)

        val sendButton : Button = root.findViewById(R.id.sendButton)

        sendButton.setOnClickListener {
            if (feedbackData.text.toString().isNotEmpty()) {
                val recipient = "krishna2707rathi@gmail.com"
                val subject = "Feedback for Attendance Tracking App"
                val message = feedbackData.text.toString()

                sendEmail(recipient, subject, message)
            } else {
                Toast.makeText(requireContext(), "Enter feedback", Toast.LENGTH_SHORT).show()
            }
        }
        return root
    }

    private fun sendEmail(recipient: String, subject: String, message: String) {

        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"))
            intent.putExtra(Intent.EXTRA_EMAIL,arrayOf(recipient))
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(requireContext(), "Exception", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FeedbackFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FeedbackFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}