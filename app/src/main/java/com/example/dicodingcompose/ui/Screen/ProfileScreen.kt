package com.example.dicodingcompose.ui.Screen

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.coil.rememberCoilPainter


@Composable
fun ProfileScreen(navController: NavController) {

    Column {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFF000000), Color(0xFF313131)),
                    )
                )
                .padding(20.dp)
        ) {
            item {
                Image(
                    painter = rememberCoilPainter(request ="https://drive.google.com/uc?id=1q-c71SUuYeNmMcfomrTrhUrmJglNyObm", fadeIn = true),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .height(200.dp)
                        .fillMaxWidth()
                )
            }

            item {
                Text(
                    text = "Hafizh Rafi Ihatra",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
            }

            item {
                Text(
                    text = "Hafizh.silva9@gmail.com",
                    fontWeight = FontWeight.Normal,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center

                )
            }
        }
    }
}


