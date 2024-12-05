package com.example.counterapp

import android.os.Bundle
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
import com.example.counterapp.ui.theme.CounterAppTheme

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.counterapp.ui.theme.CounterAppTheme



class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Define o tema da aplicação
            CounterAppTheme {
                // Define a superfície da tela com a cor de fundo padrão do tema
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFFFE4E1) )
                {
                    CounterApp()
                }
            }
        }
    }
}


// Função composable principal que define a interface do usuário da calculadora
@Composable
fun CounterApp() {
    // Estado para armazenar o resultado das operações
    var result by remember { mutableStateOf(0.0) }
    // Estado para armazenar o valor de entrada do usuário
    var input by remember { mutableStateOf("") }

    // Estrutura em coluna para alinhar elementos verticalmente
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, // Alinhamento horizontal centralizado
        modifier = Modifier
            .fillMaxSize() // Ocupa todo o espaço disponível
            .padding(16.dp), // Adiciona espaçamento nas bordas
        verticalArrangement = Arrangement.Center // Centraliza os elementos verticalmente
    ) {
        // Exibe o resultado atual
        Text(
            text = "Resultado: $result",
            fontSize = 24.sp,
            modifier = Modifier.padding(8.dp)
        )

        // Campo de entrada para número, onde o usuário digita um valor
        OutlinedTextField(
            value = input,
            onValueChange = { input = it }, // Atualiza o valor de input com o valor digitado
            label = { Text("Digite um número") },
            modifier = Modifier.fillMaxWidth() // Ocupa a largura total
        )

        Spacer(modifier = Modifier.height(16.dp)) // Espaço entre o campo de entrada e os botões

        // Linha com os botões de incremento e decremento
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp), // Espaçamento entre os botões
            modifier = Modifier.fillMaxWidth()
        ) {
            // Botão Incrementar
            Button(
                onClick = {
                    result += input.toDoubleOrNull() ?: 0.0 // Adiciona o valor digitado ao resultado
                    input = "" // Limpa o campo de entrada
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFF69B4), // Rosa pink
                ),
                modifier = Modifier.weight(1f) // O botão ocupa metade da linha
            ) {
                Text(
                    text = "Incrementar",
                    color = Color.White // Forçando a cor do texto para branco
                )
            }

            // Botão Decrementar
            Button(
                onClick = {
                    result -= input.toDoubleOrNull() ?: 0.0 // Subtrai o valor digitado do resultado
                    input = "" // Limpa o campo de entrada
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFF69B4), // Rosa pink
                ),
                modifier = Modifier.weight(1f) // O botão ocupa metade da linha
            ) {
                Text(
                    text = "Decrementar",
                    color = Color.White // Forçando a cor do texto para branco
                )

            }
        }

        // Linha com os botões de multiplicação e divisão
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp), // Espaçamento entre os botões
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp) // Espaçamento superior
        ) {
            // Botão Multiplicar
            Button(
                onClick = {
                    result *= input.toDoubleOrNull() ?: 1.0 // Multiplica o resultado pelo valor digitado
                    input = "" // Limpa o campo de entrada
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFF69B4), // Rosa pink
                ),
                modifier = Modifier.weight(1f) // O botão ocupa metade da linha
            ) {
                Text(
                    text = "Multiplicar",
                    color = Color.White // Forçando a cor do texto para branco
                )
            }

            // Botão Dividir
            Button(
                onClick = {
                    val value = input.toDoubleOrNull() ?: 1.0
                    if (value != 0.0) { // Verifica se o valor não é zero para evitar divisão por zero
                        result /= value // Divide o resultado pelo valor digitado
                    }
                    input = "" // Limpa o campo de entrada
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFF69B4), // Rosa pink
                ),
                modifier = Modifier.weight(1f) // O botão ocupa metade da linha
            ) {
                Text(
                    text = "Dividir",
                    color = Color.White // Forçando a cor do texto para branco
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp)) // Espaço antes do botão Limpar

        // Botão Limpar para redefinir o resultado e o campo de entrada
        Button(
            onClick = {
                result = 0.0 // Redefine o resultado para zero
                input = "" // Limpa o campo de entrada
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFFF69B4), // Rosa pink
            ),
            modifier = Modifier.fillMaxWidth() // O botão ocupa a largura total
        ) {
            Text(
                text = "Limpar",
                color = Color.White // Forçando a cor do texto para branco
            )
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
    CounterAppTheme {
        Greeting("Android")
    }
}