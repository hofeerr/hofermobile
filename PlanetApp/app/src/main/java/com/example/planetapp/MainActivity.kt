package com.example.planetapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.planetapp.ui.theme.theme.PlanetAppTheme

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.planetapp.navigation.NavGraph
import com.example.planetapp.ui.theme.components.DialogContent
import com.example.planetapp.ui.theme.components.DialogHost
// import com.example.zooapp.ui.components.DialogContent
// import com.example.zooapp.ui.components.DialogHost

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val dialogState = remember { mutableStateOf<DialogContent?>(null) }
            PlanetAppTheme {
                NavGraph(
                    onSettingsClick = {
                        dialogState.value = DialogContent(
                            title = "Configurações",
                            message = "Aqui você pode acessar as configurações do aplicativo."
                        )
                    },
                    onHelpClick = {
                        dialogState.value = DialogContent(
                            title = "Ajuda",
                            message = "Precisa de ajuda? Entre em contato com o suporte ou consulte nosso guia."
                        )
                    }
                )

                DialogHost(dialogState)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PlanetAppTheme {
        Greeting("Android")
    }
}