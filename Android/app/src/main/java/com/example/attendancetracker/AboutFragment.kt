package com.example.attendancetracker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AboutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutFragment : Fragment() {
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
        val root = inflater.inflate(R.layout.fragment_about, container, false)

        val aayushiText: TextView = root.findViewById(R.id.aayushiText)
        val akshatText: TextView = root.findViewById(R.id.akshatText)
        val krishnaText: TextView = root.findViewById(R.id.krishnaText)
        val vaibhavText: TextView = root.findViewById(R.id.vaibhavText)

        aayushiText.setOnClickListener {
            val intent = Intent(android.content.Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.linkedin.com/in/aayushi-sharma-910234216/")
            startActivity(intent)
        }

        akshatText.setOnClickListener {
            val intent = Intent(android.content.Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.linkedin.com/in/akshat-parakh-4a945b236/")
            startActivity(intent)
        }

        krishnaText.setOnClickListener {
            val intent = Intent(android.content.Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.linkedin.com/in/krishna-rathi-539b62200/")
            startActivity(intent)
        }


        vaibhavText.setOnClickListener {
            val intent = Intent(android.content.Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.linkedin.com/in/vaibhav-bairathi/")
            startActivity(intent)
        }

        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AboutFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AboutFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}