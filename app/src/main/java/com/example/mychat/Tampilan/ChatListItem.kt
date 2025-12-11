package com.example.mychat.Tampilan

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mychat.Data.ChatUser
import com.example.mychat.ui.theme.MyChatTheme

@Composable
fun ChatListItem(
    User: ChatUser,
    onClick :() -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 10.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Surface(modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = User.Name.first().toString(),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = User.Name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = User.LastMessage,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Text(
            text = User.Time,
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChatListItemPreview() {
    MyChatTheme {
        // 1. Kita buat data palsu (Dummy Data) untuk contoh
        val dummyUser = ChatUser(
            Name = "Budi Santoso",
            LastMessage = "Halo, besok jadi belajar coding?",
            Time = "09:41",
            AvatarUrl = "https://example.com/avatar.jpg"
        )

        // 2. Kita panggil fungsinya dengan memasukkan data palsu tersebut
        ChatListItem(
            User = dummyUser,
            onClick = {} // Kurung kurawal kosong artinya "tidak melakukan apa-apa saat diklik"
        )
    }
}