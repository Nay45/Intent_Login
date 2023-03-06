package com.example.ukllagi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class ProfilResult : Fragment() {

    private var comModel: ComModel? = null
    private var txtName: TextView? = null
    private var txtEmail: TextView? = null

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
        txtName = view.findViewById(R.id.textViewName)
        txtEmail = view.findViewById(R.id.textViewEmail)

        comModel!!.name.observe(requireActivity(), Observer{ s -> txtName!!.text = s})
        comModel!!.email.observe(requireActivity(), Observer{ s -> txtEmail!!.text = s})
    }

    companion object {
        fun newInstance(): ProfilResult {
            return ProfilResult()
        }
    }
}