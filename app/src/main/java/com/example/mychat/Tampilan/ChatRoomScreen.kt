package com.example.mychat.Tampilan

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mychat.Data.ChatMessage
import com.example.mychat.ui.theme.MyChatTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatRoomScreen(
    onBackClick:() -> Unit
) {
    var CurrentMessage by remember { mutableStateOf("") }
    val DummyMessage = listOf(
        ChatMessage("Halo, Apa Kabar", false, "10.10"),
        ChatMessage("Halo, Apa kamu", false, "10.15"),
        ChatMessage("Baik - Baik Saja", false, "10.30"),
        ChatMessage("Oke Deh", false, "11.00"),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            modifier = Modifier.size(32.dp),
                            shape = CircleShape,
                            color = MaterialTheme.colorScheme.primaryContainer
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text("A")
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Android User", style = MaterialTheme.typography.titleMedium)
                    }
                },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
            )
        },
        bottomBar = {
            ChatInputBar(
                Message = CurrentMessage,
                onMessageChange = {CurrentMessage = it},
                onSendClick = {}
            )
        }
    )
    { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            reverseLayout = false
        ) {
            items(DummyMessage){msg ->
                ChatBubble(Message = msg)
            }
        }
    }
}


@Preview
@Composable
fun ChatRoomScreenPreview() {
    MyChatTheme {
        ChatRoomScreen(onBackClick = {})
    }
}


