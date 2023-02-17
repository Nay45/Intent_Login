package com.example.ukllagi

object List {
    private val data = arrayOf(
        arrayOf(
            "Nike",
            "Sepatu ngeten pun 👍",
            "Rp 25.000.000",
            "https://images.tokopedia.net/img/cache/500-square/VqbcmM/2021/7/26/a1c7954a-8467-41d8-bb46-4e44acf00fc4.jpg"
        ),
        arrayOf(
            "Air Jordan",
            "BELIIIIIIIIIII",
            "Rp 37.000.000",
            "https://www.static-src.com/wcsstore/Indraprastha/images/catalog/medium//91/MTA-13462920/air_jordan_nike_aj1_mid_chicago_2020_full01_d4j8lzzs.jpg"
        )
    )

    val listData: ArrayList<Data_Barang>
        get() {
            val list = arrayListOf<Data_Barang>()
            for (aData in data) {
                val dBarang = Data_Barang()
                dBarang.nama = aData[0]
                dBarang.desc = aData[1]
                dBarang.price = aData[2]
                dBarang.photo = aData[3]

                list.add(dBarang)
            }
            return list
        }

}