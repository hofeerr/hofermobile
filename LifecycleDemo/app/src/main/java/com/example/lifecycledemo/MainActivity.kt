package com.example.lifecycledemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lifecycledemo.ui.theme.LifecycleDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LifecycleDemoTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()

        // Mensagem de log e Toast para onStart
        Log.d("LifecycleDemo", "onStart chamado")
        Toast.makeText(this, "onStart chamado", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()

        // Mensagem de log e Toast para onResume
        Log.d("LifecycleDemo", "onResume chamado")
        Toast.makeText(this, "onResume chamado", Toast.LENGTH_SHORT).show()
    }


    override fun onPause() {
        super.onPause()

        // Mensagem de log e Toast para onPause
        Log.d("LifecycleDemo", "onPause chamado")
        Toast.makeText(this, "onPause chamado", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()

        // Mensagem de log e Toast para onStop
        Log.d("LifecycleDemo", "onStop chamado")
        Toast.makeText(this, "onStop chamado", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()

        // Mensagem de log e Toast para onDestroy
        Log.d("LifecycleDemo", "onDestroy chamado")
        Toast.makeText(this, "onDestroy chamado", Toast.LENGTH_SHORT).show()
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
    LifecycleDemoTheme {
        Greeting("Android")
    }
}


