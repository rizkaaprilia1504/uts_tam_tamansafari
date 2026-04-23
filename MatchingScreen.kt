package com.example.uts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.res.painterResource

@Composable
fun MatchingScreen(navController: NavController, komoditas: String?) {

    val filteredList = if (komoditas != null) {
        MatchingData.matchingList.filter {
            it.komoditas.contains(komoditas, ignoreCase = true)
        }
    } else {
        MatchingData.matchingList
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7))
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Hasil Matching",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {

            itemsIndexed(filteredList){ index, item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 14.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {

                    Row(
                        modifier = Modifier.padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(65.dp)
                                .background(
                                    Color(0xFFF4E8D5),
                                    RoundedCornerShape(14.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = item.image),
                                contentDescription = null,
                                modifier = Modifier.size(45.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = item.komoditas,
                                fontWeight = FontWeight.Bold
                            )

                            Text(text = item.petani)

                            Text(
                                text = "Tersedia: ${item.stok}",
                                color = Color.Gray
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Icon(
                                    Icons.Default.LocationOn,
                                    null,
                                    modifier = Modifier.size(15.dp),
                                    tint = Color.Gray
                                )

                                Text(
                                    text = item.lokasi,
                                    color = Color.Gray
                                )
                            }
                        }

                        Column(
                            horizontalAlignment = Alignment.End
                        ) {

                            Box(
                                modifier = Modifier
                                    .background(
                                        if (item.status == "Cocok")
                                            Color(0xFFD9F7E3)
                                        else
                                            Color(0xFFFFF0C2),
                                        RoundedCornerShape(8.dp)
                                    )
                                    .padding(
                                        horizontal = 10.dp,
                                        vertical = 4.dp
                                    )
                            ) {
                                Text(
                                    text = item.status,
                                    color =
                                        if (item.status == "Cocok")
                                            Color(0xFF0E8A3A)
                                        else
                                            Color(0xFFE69A00)
                                )
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Button(
                                onClick = {
                                    navController.navigate("detailMatching/$index")
                                },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF0E8A3A)
                                )
                            ) {
                                Text("Lihat Detail")
                            }
                        }
                    }
                }
            }
        }
    }
}