package com.example.ukllagi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Activity_2 : AppCompatActivity() {
    private lateinit var txtHello: TextView
    private var email: String? = null

    private val KEY_EMAIL = "EA"

    private lateinit var rvBarang: RecyclerView
    private val list = ArrayList<Data_Barang>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        txtHello = findViewById(R.id.tampil)

        val extras = intent.extras
        email = extras?.getString(KEY_EMAIL)
        txtHello.text = "Hola, $email"

        rvBarang = findViewById(R.id.rv_main)
        rvBarang.setHasFixedSize(true)

        list.addAll(List.listData)
        showCard()
    }

    private fun showCard() {
        rvBarang.layoutManager = LinearLayoutManager(this)
        val cardAdapter = ktCard(list)
        rvBarang.adapter = cardAdapter
    }

    private fun showList() {
        rvBarang.layoutManager = LinearLayoutManager(this)
        val listAdapter = ktList(list)
        rvBarang.adapter = listAdapter

        listAdapter.setOnItemClickCallback(object :ktList.OnItemClickCallback{
            override fun onItemClicked(data: Data_Barang) {
                showSelectedBarang(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_view, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_card -> {
                showCard()
            }
            R.id.action_list -> {
                showList()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSelectedBarang(hero: Data_Barang) {
        Toast.makeText(this, "U choose " + hero.nama, Toast.LENGTH_SHORT).show()
    }

}