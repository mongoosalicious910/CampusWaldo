package com.example.campuswaldo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaldoOnlyScreen() {
    var hintText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Waldo Control Panel", style = MaterialTheme.typography.titleLarge)

        Spacer(Modifier.height(12.dp))

        Text("Post a hint:", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = hintText,
            onValueChange = { hintText = it },
            label = { Text("Hint text") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = { hintText = "" },
            enabled = hintText.isNotBlank()
        ) {
            Text("Post hint")
        }

        Spacer(Modifier.height(24.dp))

        Text("Today’s code: CORNELL", style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun WaldoOnlyScreenPreview() {
    WaldoOnlyScreen()
}