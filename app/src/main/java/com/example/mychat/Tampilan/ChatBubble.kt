package com.example.mychat.Tampilan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mychat.Data.ChatMessage
import com.example.mychat.ui.theme.MyChatTheme

@Composable
fun ChatBubble(Message : ChatMessage) {
    val BubbleColor = if (Message.IsFromMe){
        MaterialTheme.colorScheme.primary
    }else{
        MaterialTheme.colorScheme.surfaceVariant
    }

    val textColor = if (Message.IsFromMe) Color.White else Color.Black
    val alignment = if (Message.IsFromMe) Alignment.End else Alignment.Start

    val BubbleShape = if (Message.IsFromMe){
        RoundedCornerShape(topStart = 16.dp, topEnd = 0.dp, bottomStart = 16.dp, bottomEnd = 16.dp)
    }else{
        RoundedCornerShape(topStart = 0.dp, topEnd = 16.dp, bottomStart = 16.dp, bottomEnd = 16.dp)
    }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalAlignment = alignment
    ) {
        Surface(color = BubbleColor,
            shape = BubbleShape,
            shadowElevation = 2.dp
        ){
            Text(
                text = Message.Text,
                modifier = Modifier.padding(12.dp),
                color = textColor,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Text(
            text = Message.Time,
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ChatBubblePreview() {
    MyChatTheme {
        val DummyMessage = ChatMessage(
            Text = "Selamat Malam",
            Time = "23.47",
            IsFromMe = true
        )


        ChatBubble(Message = DummyMessage)
    }
}