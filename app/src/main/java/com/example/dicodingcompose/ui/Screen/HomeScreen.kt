package com.example.dicodingcompose.ui.Screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.google.accompanist.insets.navigationBarsPadding

@Composable
fun HomeScreen(navController: NavController){

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        item {
            Button(
                onClick = {
                    navController.navigate("profile")
                },
                modifier = Modifier
                    .padding(8.dp, 24.dp)
                    .fillMaxWidth()
            ) {

                Text(text = "Profile")

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    imageVector = Icons.Filled.PermIdentity,
                    contentDescription = ""
                )

            }
        }

        itemsIndexed(motorcycleListing) { position, data ->
            MotorcycleItem(motorcycleModel = data,navController = navController)
        }

        item {
            Spacer(modifier = Modifier.navigationBarsPadding())
        }
    }
}

data class MotorcycleModel(
    val image: String,
    val nama: String,
    val merkKendaraan: String,
    val tahunProduksi: String,
    val detail: String
)

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MotorcycleItem(motorcycleModel: MotorcycleModel, navController: NavController) {

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF6DAAA3)
        ),
        modifier = Modifier
            .padding(4.dp)
            .padding(6.dp)
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    "index",
                    motorcycleListing.indexOf(motorcycleModel)
                )
                navController.navigate("detail")
            }

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {

            GlideImage(
                model = motorcycleModel.image,
                contentDescription = "Banner",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .clip(RoundedCornerShape(percent = 10))
                    .height(250.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = motorcycleModel.nama,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                lineHeight = 24.sp
            )
            }
        }
    }


val motorcycleListing = listOf<MotorcycleModel>(
    MotorcycleModel(
        "https://imgx.gridoto.com/crop/83x13:911x513/700x465/photo/2022/06/12/449jpg-20220612102302.jpg",
        "W175",
        "Kawasaki",
        "2021",
        "kiwkiw"
    ),
    MotorcycleModel(
        "https://www.royalenfield.com/content/dam/royal-enfield/indonesia/motorcycles/classic-350/timeless-classic.jpg",
        "Classic 350",
        "Royal Enfield",
        "2021",
        "All-New Classic 350 terus mewujudkan tradisi dan keahlian masa lalu saat dilahirkan kembali. Terinspirasi oleh model G2 pasca perang, yang pertama kali lahir pada tahun 1950-an, All New Classic 350 terus menjadi bukti desain abadi yang membawa dunia sepeda motor dengan kekaguman kembali pada masa kejayaan sepeda motor Inggris. Tangki bahan bakar Classic teardrop, dentuman khas dan lampu depan casquette ciri khas - semuanya selaras menjadi satu, bergembira dalam mahakarya Royal Enfield Classic yang tak lekang oleh waktu."
    ),
    MotorcycleModel(
        "https://juraganwp.sgp1.cdn.digitaloceanspaces.com/monkeymotoblog/wp-content/uploads/2020/01/11224056/wpid-wp3-11.jpg",
        "W650",
        "Kawasaki",
        "2021",
        "Kawasaki W series, bisa dibilang sebagai varian retro yang bener-bener retro dari Kawasaki. Motor ini asli dah, kagak ada fitur canggihnya. Lah, jangankan fitur canggih, wong indikator bensin aja seringkali kagak ada masbro. nah, kembali lagi ke topik, Kawasaki W650, motor ini udah lumayan sering muncul di forum jual beli Moge, nampaknya bakalan dan sedang naik daun nih!"
    ),
    MotorcycleModel(
        "https://imgcdnblog.carbay.com/wp-content/uploads/2019/02/28042203/Benelli-Motobi-250-Patagonian-Eagle-002.jpg",
        "Phentagonian Eagle",
        "Benneli",
        "2021",
        "Patagonian Eagle merupakan jenis motor cruiser dari Benelli yang dijual di Indonesia selain Motobi 200. Dia memiliki tampilan seperti kuda besi kustom era 60-70 an. Mengusung mesin dua silinder segaris berkapasitas 251,8 cc karburator dan pakai oil cooler. Bisa dibilang, dirinya termasuk motor seperempat liter dengan harga paling terjangkau di tanah air. "
    ),
    MotorcycleModel(
        "https://imgx.gridoto.com/crop/379x237:2040x1300/700x465/photo/2023/01/23/modifikasiyamahagrandfilano-1jp-20230123095824.jpg",
        "Filano",
        "Yamaha",
        "2023",
        "Kami suguhkan lagi referensi modifikasi Yamaha Grand Filano Hybrid Connected dari Likit Racing. Workshop asal Thailand ini nampak cukup rajin memamerkan ragam modifikasi Yamaha Grand Filano Hybrid Connected di akun media sosialnya. Kekinian ada sebuah Yamaha Grand Filano warna white pearl yang dipasok sederet part aftermarket hedon.\n" +
                "\n" +
                "Artikel ini telah tayang di https://www.gridoto.com dengan judul \"Yamaha Grand Filano Hybrid Connected Dimodif Lebih Mahal Dari Harganya\".\n" +
                "\n" +
                "Gridoto+ baca berita tanpa iklan: https://plus.grid.id/gridoto\n"
    ),
    MotorcycleModel(
        "https://i.ytimg.com/vi/sB0w-PFzeW4/maxresdefault.jpg",
        "Fazio",
        "Yamaha",
        "2023",
        "Full digital speedometer dengan desain modern yang informatif, dengan indikator Electric Power Assist Start, baterai smartphone, notifikasi pesan & telepon, serta jam digital."
    ),
    MotorcycleModel(
        "https://asset.kompas.com/crops/scDb0gmrfhA_hdrEAVFeOf6czX4=/65x28:976x635/1200x800/data/photo/2019/01/24/1960687181.jpg",
        "Beat",
        "Honda",
        "2021",
        "Kesan sporty Honda BeAT eSP, ditojolkan melalui balutan grafis bertema sporty fashion untuk tipe CW dan CBS, serta sporty advanced untuk tipe CBS-ISS. Honda juga menawarkan grafis baru dan dua kelir kombinasi pada BeAT eSP CBS-ISS yang menemawi warna Fusion Magenta Black, yakni Electro Blue Black dan Soul Red Black.\n" +
                "\n" +
                "Artikel ini telah tayang di Kompas.com dengan judul \"Honda Bikin BeAT Lebih Segar di 2019\", Klik untuk baca: https://otomotif.kompas.com/read/2019/01/24/180725715/honda-bikin-beat-lebih-segar-di-2019.\n" +
                "\n" +
                "\n" +
                "Kompascom+ baca berita tanpa iklan: https://kmp.im/plus6\n" +
                "Download aplikasi: https://kmp.im/app6"
    ),
    MotorcycleModel(
        "https://motostylerz.com/wp-content/uploads/2021/08/Ninja-SS-Fashion-Style-by-OHS-Modification.jpg",
        "Ninja ss",
        "Kawasaki",
        "2021",
        "motor 2 tak ini "
    ),
    MotorcycleModel(
        "https://imgx.gridoto.com/crop/0x0:0x0/700x465/photo/2019/06/13/179607001.jpg",
        "Spotster",
        "Harley davidson",
        "2021",
        "Dengan kapasitas 1202 cc dengan menghasilkan suara yang bikin mmelting"
    ),
    MotorcycleModel(
        "https://asset.kompas.com/crops/M4TUEPQutii55qyGLtYOeqOrcIg=/0x63:1076x781/1200x800/data/photo/2022/10/16/634b6ea45516b.jpg",
        "Ninja RR",
        "Kawasaki",
        "2018",
        "Motor ninja dengan 2 tak"
    ),

    )