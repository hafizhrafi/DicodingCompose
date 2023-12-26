package com.example.dicodingcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun DetailScreen(navController: NavController,index: Int) {

    val motorcycleModel: MotorcycleModel = motorcycleListing[index]


    Column {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFF000000), Color(0xFF383D3C)),
                    )
                )
                .padding(16.dp)
        ) {
            item {
                Image(
                    painter = rememberCoilPainter(request = motorcycleModel.image, fadeIn = true),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .height(200.dp)
                        .fillMaxWidth()
                )
            }

//            Spacer(modifier = Modifier.weight(1f))

            item {

                Text(
                    text = motorcycleModel.nama,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 30.sp,
                )
            }

            item {
                Text(
                    text = "\n" + motorcycleModel.merkKendaraan + "\n",
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                )
            }

            item {
                Text(
                    text = motorcycleModel.tahunProduksi + "\n",
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                )
            }

            item {
                Text(
                    text = "About",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 22.sp,
                )
            }

            item {
                Text(
                    text = motorcycleModel.detail,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                )
            }
        }
    }



}