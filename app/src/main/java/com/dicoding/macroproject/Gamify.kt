package com.dicoding.macroproject

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.dicoding.macroproject.gamify.Inventory
import com.dicoding.macroproject.gamify.Social
import com.dicoding.macroproject.task.TodoCretaeCategory
import com.dicoding.macroproject.task.TodoViewAllTask


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Gamify.newInstance] factory method to
 * create an instance of this fragment.
 */
class Gamify : Fragment() {
    // TODO: Rename and change types of parameters
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
        val rootView = inflater.inflate(R.layout.fragment_gamify, container, false)

        val InvenBtn = rootView.findViewById<TextView>(R.id.inventory)
        val SocialBtn = rootView.findViewById<TextView>(R.id.social)


        InvenBtn.setOnClickListener {
            val intent = Intent(context, Inventory::class.java)
            startActivity(intent)
        }

        SocialBtn.setOnClickListener {
            val intent = Intent(context, Social::class.java)
            startActivity(intent)
        }

        // Mengakses elemen dari main.xml
        val mainView = requireActivity().findViewById<View>(R.id.main)
        val fragmentTask = mainView.findViewById<View>(R.id.status)

        // Set visibilitas elemen
        fragmentTask.visibility = View.GONE

        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Habit.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Gamify().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}