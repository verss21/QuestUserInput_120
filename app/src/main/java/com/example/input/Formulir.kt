package com.example.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormulirPendaftaran(modifier: Modifier) {
    // State input
    var nama by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    // State hasil submit
    var submittedNama by remember { mutableStateOf("") }
    var submittedJK by remember { mutableStateOf("") }
    var submittedStatus by remember { mutableStateOf("") }
    var submittedAlamat by remember { mutableStateOf("") }

    val genderList = listOf("Laki-laki", "Perempuan")
    val statusList = listOf("Janda", "Lajang", "Duda")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Header gradien
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFF9C27B0), Color(0xFFE1BEE7))
                    )
                )
                .padding(vertical = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Formulir Pendaftaran",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Isi form
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            // Nama Lengkap
            Text(text = "NAMA LENGKAP", fontWeight = FontWeight.Bold)
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Isian nama lengkap") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(Modifier.height(12.dp))

            // Jenis Kelamin
            Text(text = "JENIS KELAMIN", fontWeight = FontWeight.Bold)
            genderList.forEach { item ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = jenisKelamin == item,
                            onClick = { jenisKelamin = item }
                        )
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = jenisKelamin == item, onClick = { jenisKelamin = item })
                    Text(text = item)
                }
            }

            Spacer(Modifier.height(12.dp))

            // Status Perkawinan
            Text(text = "STATUS PERKAWINAN", fontWeight = FontWeight.Bold)
            statusList.forEach { item ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = status == item,
                            onClick = { status = item }
                        )
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = status == item, onClick = { status = item })
                    Text(text = item)
                }
            }

            Spacer(Modifier.height(12.dp))

            // Alamat
            Text(text = "ALAMAT", fontWeight = FontWeight.Bold)
            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                label = { Text("Alamat") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(Modifier.height(16.dp))

            // Tombol Submit
            Button(
                onClick = {
                    submittedNama = nama
                    submittedJK = jenisKelamin
                    submittedStatus = status
                    submittedAlamat = alamat
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9C27B0)),
                enabled = nama.isNotEmpty() && alamat.isNotEmpty()
            ) {
                Text(text = "Submit", color = Color.White, fontWeight = FontWeight.Bold)
            }

            Spacer(Modifier.height(24.dp))

            // Tampilkan hasil input
            if (submittedNama.isNotEmpty()) {
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Black),
                    modifier = Modifier
                        .heightIn(min = 100.dp)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 15.dp)
                    ) {
                        Text(text = "Nama: $submittedNama", color = Color.White)
                        Text(text = "Gender: $submittedJK", color = Color.White)
                        Text(text = "Status: $submittedStatus", color = Color.White)
                        Text(text = "Alamat: $submittedAlamat", color = Color.White)
                    }
                }
            }
        }
    }
}
