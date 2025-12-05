package com.example.campuswaldo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.campuswaldo.ui.viewmodels.CodeStatus

@Composable
fun CodeEntryScreen(
    code: String,
    codeStatus: CodeStatus,
    onCodeChange: (String) -> Unit,
    onSubmit: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Enter Today's Waldo Code",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = code,
            onValueChange = onCodeChange,
            label = { Text("Enter code") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onSubmit,
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text("Submit")
        }

        Spacer(modifier = Modifier.height(24.dp))

        when (codeStatus) {
            CodeStatus.SUCCESS -> Text(
                "Correct! You found Waldo!",
                color = MaterialTheme.colorScheme.primary
            )
            CodeStatus.ERROR -> Text(
                "Incorrect code. Try again!",
                color = MaterialTheme.colorScheme.error
            )
            else -> {}
        }
    }
}
