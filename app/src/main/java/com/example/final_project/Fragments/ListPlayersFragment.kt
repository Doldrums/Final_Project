package com.example.final_project.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.final_project.Adapter
import com.example.final_project.MainActivity
import com.example.final_project.R
import com.example.final_project.RecyclerItemClickListener
import kotlinx.android.synthetic.main.listplayerfragment_layout.*


class ListPlayersFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.listplayerfragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("FRAG","Fragment ListFragment started")

        val playerId = mutableListOf<String>()
        playerId.add("Id1234567890")
        playerId.add("Id1234567890")
        playerId.add("Id1234567890")
        playerId.add("Id1234567890")
        playerId.add("Id1234567890")


        my_recycler_view.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        my_recycler_view.adapter = Adapter(playerId)

        my_recycler_view.addOnItemTouchListener(
            RecyclerItemClickListener(this@ListPlayersFragment.activity!!, my_recycler_view, object : RecyclerItemClickListener.OnItemClickListener {
                override fun onItemClick(view: View, position: Int) {
                    //Переходим во фрагмент с подробной статистикой об игроке
//                    Toast.makeText(
//                        this@ListPlayersFragment.activity,
//                        "Короткое нажатие",
//                        Toast.LENGTH_LONG
//                    ).show()
                    val ma = this@ListPlayersFragment.activity as MainActivity
                    ma.changeFragment(2)

                }

                override fun onLongItemClick(view: View?, position: Int) {
                    Toast.makeText(
                        this@ListPlayersFragment.activity,
                        "Длинное нажатие",
                        Toast.LENGTH_LONG
                    ).show()
                    // do whatever
                }
            })
        )

        btn_exit.setOnClickListener {
            val ma = this@ListPlayersFragment.activity as MainActivity
            ma.changeFragment(3)
        }



    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ListPlayersFragment().apply {
            }
    }


}
