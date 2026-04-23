package com.example.uts_tam_agridistri

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Akun Saya", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(32.dp))
        Image(painter = painterResource(id = R.drawable.profile1), contentDescription = null, modifier = Modifier.size(100.dp).clip(CircleShape).background(Color.LightGray))
        Spacer(modifier = Modifier.height(32.dp))
        ProfileInfoRow("Nama", "Pembeli 1")
        ProfileInfoRow("Role", "Pembeli")
        ProfileInfoRow("No. HP", "0812-3456-7890")
        ProfileInfoRow("Email", "pembeli1@email.com")
        Spacer(modifier = Modifier.height(48.dp))
        OutlinedButton(onClick = {}, modifier = Modifier.fillMaxWidth(), border = BorderStroke(1.dp, Color.Red)) {
            Text("Logout", color = Color.Red)
        }
    }
}

@Composable
fun ProfileInfoRow(label: String, value: String) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = label, fontWeight = FontWeight.Bold); Text(text = value, color = Color.Gray)
        }
        HorizontalDivider(modifier = Modifier.padding(top = 8.dp), thickness = 0.5.dp)
    }
}
