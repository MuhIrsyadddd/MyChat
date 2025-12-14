package com.example.mychat

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mychat.Tampilan.ChatRoomScreen
import com.example.mychat.ui.theme.MyChatTheme

@Composable
fun AppNavigation() {
    val NavController = rememberNavController()

    NavHost(navController = NavController, startDestination = "home_screen") {

        // RUTE 1: Halaman Home (Sementara isinya cuma tombol)
        composable("home_screen") {
            DummyHomeScreen(
                onChatClick = {
                    // Perintah pindah ke halaman chat
                    NavController.navigate("chat_room")
                }
            )
        }

        composable("chat_room") {
            ChatRoomScreen(
                onBackClick = {
                    // Perintah kembali ke halaman sebelumnya
                    NavController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun DummyHomeScreen(onChatClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = onChatClick) {
            Text(text = "Buka Chat Anda Sekarang")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppNavigationPreview() {
    MyChatTheme {
        AppNavigation()
    }

}