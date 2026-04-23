package com.example.uts_tam_agridistri

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.uts_tam_agridistri.ui.theme.Transaction

@Composable
fun StatusScreen() {
    val transactions = listOf(
        Transaction("Beras", "50 kg", "Petani A", "21 Mei 2025", "Diproses", R.drawable.nasi),
        Transaction("Jagung", "30 kg", "Petani C", "20 Mei 2025", "Disetujui", R.drawable.ic_launcher_background),
        Transaction("Singkong", "40 kg", "Petani D", "18 Mei 2025", "Selesai", R.drawable.ic_launcher_background)
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Status Transaksi", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Semua", color = Color(0xFF4CAF50), fontWeight = FontWeight.Bold)
            Text("Diproses", color = Color.Gray); Text("Disetujui", color = Color.Gray); Text("Selesai", color = Color.Gray)
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), color = Color(0xFF4CAF50), thickness = 2.dp)
        LazyColumn {
            items(transactions) { item ->
                TransactionItem(item)
            }
        }
    }
}

@Composable
fun TransactionItem(item: Transaction) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = item.iconRes), contentDescription = null, modifier = Modifier.size(50.dp).clip(RoundedCornerShape(8.dp)))
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "${item.product} - ${item.weight}", fontWeight = FontWeight.Bold)
                Text(text = item.farmer, color = Color.Gray, fontSize = 12.sp)
                Text(text = item.date, color = Color.Gray, fontSize = 10.sp)
            }
            StatusBadge(item.status)
        }
    }
}

@Composable
fun StatusBadge(status: String) {
    val bgColor = if (status == "Diproses") Color(0xFFE3F2FD) else if (status == "Disetujui") Color(0xFFFFF3E0) else Color(0xFFE8F5E9)
    val textColor = if (status == "Diproses") Color(0xFF2196F3) else if (status == "Disetujui") Color(0xFFFF9800) else Color(0xFF4CAF50)
    Surface(color = bgColor, shape = RoundedCornerShape(8.dp)) {
        Text(text = status, color = textColor, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp), fontSize = 10.sp)
    }
}
