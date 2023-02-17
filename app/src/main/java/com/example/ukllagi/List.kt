package com.example.ukllagi

object List {
    private val data = arrayOf(
        arrayOf(
            "Nike",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed faucibus nulla et aliquam eleifend. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nam varius rutrum rhoncus. Praesent in felis purus. Sed cursus augue nec diam finibus, sed dignissim quam imperdiet. Mauris iaculis tincidunt luctus. Etiam vel purus at tellus euismod dictum. Duis lacinia dictum neque vitae tempus. Vivamus euismod congue tellus, in accumsan dui consequat at. Quisque rhoncus aliquet odio quis pretium. Nullam et ipsum enim.",
            "$153.00",
            "https://images.tokopedia.net/img/cache/500-square/VqbcmM/2021/7/26/a1c7954a-8467-41d8-bb46-4e44acf00fc4.jpg"
        ),
        arrayOf(
            "Air Jordan",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed faucibus nulla et aliquam eleifend. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nam varius rutrum rhoncus. Praesent in felis purus. Sed cursus augue nec diam finibus, sed dignissim quam imperdiet. Mauris iaculis tincidunt luctus. Etiam vel purus at tellus euismod dictum. Duis lacinia dictum neque vitae tempus. Vivamus euismod congue tellus, in accumsan dui consequat at. Quisque rhoncus aliquet odio quis pretium. Nullam et ipsum enim.",
            "$347.95",
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