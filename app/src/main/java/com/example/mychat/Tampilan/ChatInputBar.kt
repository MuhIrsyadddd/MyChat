package com.example.mychat.Tampilan

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mychat.ui.theme.MyChatTheme

@Composable
fun ChatInputBar(Message: String,
                 onMessageChange: (String) -> Unit,
                 onSendClick : () -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = Message,
            onValueChange = onMessageChange,
            modifier = Modifier
                .weight(1f)
                .background(MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(24.dp),
            placeholder = { Text("Masukan Pesan Anda.....") },
            maxLines = 5
        )

        Spacer(modifier = Modifier.width(8.dp))

        FloatingActionButton(onClick = onSendClick,
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White,
            shape = CircleShape,
            modifier = Modifier.size(50.dp)
        ) {
            Icon(imageVector = Icons.AutoMirrored.Filled.Send, contentDescription = "Send")
        }
    }
}


@Preview
@Composable
fun CharInputBarPreview() {
    MyChatTheme {
        ChatInputBar(
            Message = "Halo",
            onMessageChange = {},
            onSendClick = {}
        )
    }
}