package com.example.ukllagi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProfilResult : Fragment() {

    private var comModel: ComModel? = null
    private var listMyData: RecyclerView? = null
    private var db: MyDatabase? = null
    private var dao: MyDao? = null
    private var listData: kotlin.collections.List<MyData>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        comModel = ViewModelProviders.of(requireActivity()).get(ComModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        txtName = view.findViewById(R.id.textViewName)
//        txtEmail = view.findViewById(R.id.textViewEmail)
//
//        comModel!!.name.observe(requireActivity(), Observer{ s -> txtName!!.text = s})
//        comModel!!.email.observe(requireActivity(), Observer{ s -> txtEmail!!.text = s})

        initLocalDB()
        initView()
    }

    private fun initView() {
        listMyData = activity?.findViewById(R.id.listMyData)
        ambilData()
    }

    private fun ambilData() {
        listData = ArrayList()
        dao?.ambilData()?.observe(requireActivity()) {
            r -> listData = r
            when {
                listData?.size == 0 -> tampilToast("Belum ada data")
                else -> {
                    tampilData()
                }
            }
        }
    }

    private fun tampilData() {
        listMyData?.layoutManager = LinearLayoutManager(activity)
        listMyData?.adapter = Adapter(requireActivity(), listData!! as ArrayList<MyData>)
    }

    private fun tampilToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }

    private fun initLocalDB() {
        db = MyDatabase.getMyDatabase(requireActivity())
        dao = db?.myDao()
    }

    companion object {
        fun newInstance(): ProfilResult {
            return ProfilResult()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        listMyData = null
    }
}