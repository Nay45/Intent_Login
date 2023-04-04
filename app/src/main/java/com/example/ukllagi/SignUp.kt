package com.example.ukllagi

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*

class SignUp : Fragment() {

    private var db: MyDatabase? = null
    private var myDao: MyDao? = null

    private var namaInput: String = ""
    private var emailInput: String = ""
    private var dateInput: String = ""

    private var edtName: TextInputEditText? = null
    private var edtEmail: TextInputEditText? = null
    private var edtDate: Button? = null
    private var btnSave: Button? = null

    private var comModel: ComModel? = null

    lateinit var pickDateBtn: Button

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
//        val nameEditText = view.findViewById<TextInputEditText>(R.id.textInputTextName)
//        val emailEditText = view.findViewById<TextInputEditText>(R.id.textInputTextEmail)
//
//        nameEditText.addTextChangedListener(
//            object : TextWatcher {
//                override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
//
//                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
//                    comModel!!.setName(charSequence.toString())
//                }
//
//                override fun afterTextChanged(editable: Editable) {}
//            }
//        )
//
//        emailEditText.addTextChangedListener(
//            object : TextWatcher {
//                override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
//
//                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
//                    comModel!!.setEmail(charSequence.toString())
//                }
//
//                override fun afterTextChanged(editable: Editable) {}
//            }
//        )

        initLocalDB()
        initView()

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

//        Date
        pickDateBtn = view.findViewById(R.id.idBtnPickDate)

        pickDateBtn.setOnClickListener {
            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                requireActivity(),
                { view, year, monthOfYear, dayOfMonth ->
                    pickDateBtn.text =
                        (dayOfMonth.toString() + "\t-\t" + (monthOfYear + 1) + "\t-\t" + year)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
    }

    private fun initView() {
        edtName = activity?.findViewById(R.id.textInputTextName)
        edtEmail = activity?.findViewById(R.id.textInputTextEmail)
        edtDate = activity?.findViewById(R.id.idBtnPickDate)
        btnSave = activity?.findViewById(R.id.btnSave)

        btnSave?.setOnClickListener{
            validasiInput()
        }
    }

    private fun validasiInput() {
        namaInput = edtName?.text.toString()
        emailInput = edtEmail?.text.toString()
        dateInput = edtDate?.text.toString()

        when {
            namaInput.isEmpty() -> edtName?.error = "Nama tidak boleh kosong"
            emailInput.isEmpty() -> edtEmail?.error = "Email tidak boleh kosong"
            dateInput.isEmpty() -> edtDate?.error = "Tanggal tidak boleh kosong"
            else -> {
                val data = MyData(
                    nama = namaInput, email = emailInput, date = dateInput
                )
                tambahData(data)
                Toast.makeText(requireActivity(), "Data Di Simpan", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun tambahData(data: MyData): Job {
        return GlobalScope.launch {
            myDao?.tambahData(data)
        }
    }

    private fun initLocalDB() {
        db = MyDatabase.getMyDatabase(requireActivity())
        myDao = db?.myDao()
    }

    companion object {
        fun newInstance(): SignUp {
            return SignUp()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        db?.close()
        edtName = null
        edtEmail = null
        edtDate = null
    }
}