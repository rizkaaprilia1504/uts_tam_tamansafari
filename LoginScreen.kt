package com.example.uts_tam_teori

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uts_tam_teori.ui.theme.GreenPrimary
import com.example.uts_tam_teori.ui.theme.UTS_TAM_TEORITheme

@Composable
fun LoginScreen(onRegisterClick: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_kebun),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.45f)
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.FillWidth,
            alpha = 0.85f
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 35.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            Image(
                painter = painterResource(id = R.drawable.logo_daun),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .height(200.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                text = "Platform Distribusi Hasil Pertanian",
                fontSize = 14.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.offset(y = (-40).dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            CustomInputField(
                value = email,
                onValueChange = { email = it },
                placeholder = "Email atau Username",
                icon = Icons.Default.Person
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomInputField(
                value = password,
                onValueChange = { password = it },
                placeholder = "Password",
                icon = Icons.Default.Lock,
                isPassword = true
            )

            Spacer(modifier = Modifier.height(35.dp))

            Button(
                onClick = { /* Aksi Login */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary)
            ) {
                Text("Login", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Lupa Password?",
                color = Color(0xFF1B8E3B),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }

        Text(
            text = "Belum punya akun? Daftar di sini",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 100.dp)
                .clickable { onRegisterClick() },
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    UTS_TAM_TEORITheme {
        LoginScreen({})
    }
}
