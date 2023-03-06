package com.example.ukllagi

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputEditText

class SignUp : Fragment() {

    private var comModel: ComModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        comModel = ViewModelProviders.of(requireActivity()).get(ComModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameEditText = view.findViewById<TextInputEditText>(R.id.textInputTextName)
        val emailEditText = view.findViewById<TextInputEditText>(R.id.textInputTextEmail)

        nameEditText.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                    comModel!!.setName(charSequence.toString())
                }

                override fun afterTextChanged(editable: Editable) {}
            }
        )

        emailEditText.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                    comModel!!.setEmail(charSequence.toString())
                }

                override fun afterTextChanged(editable: Editable) {}
            }
        )

//        CheckBox
        val ShowPass = view.findViewById<CheckBox>(R.id.showpass)
        val pass = view.findViewById<TextInputEditText>(R.id.textInputTextPass)

        ShowPass.setOnClickListener {
            if (ShowPass.isChecked) {
                pass.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                pass.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }
    }

    companion object {
        fun newInstance(): SignUp {
            return SignUp()
        }
    }
}