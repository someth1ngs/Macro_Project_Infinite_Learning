package com.dicoding.macroproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.TestLooperManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.dicoding.macroproject.task.TodoCretaeCategory
import com.dicoding.macroproject.task.TodoViewAllTask

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Task.newInstance] factory method to
 * create an instance of this fragment.
 */
class Task : Fragment() {
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



    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_task, container, false)

        val createCategoryButton = rootView.findViewById<ImageButton>(R.id.createCategory)
        val viewAllTask = rootView.findViewById<Button>(R.id.viewAllTask)

        createCategoryButton.setOnClickListener {
            val intent = Intent(context, TodoCretaeCategory::class.java)
            startActivity(intent)
        }
        viewAllTask.setOnClickListener {
            val intent = Intent(context, TodoViewAllTask::class.java)
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
         * @return A new instance of fragment Task.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Task().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}