package com.example.zooapp

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
import com.example.zooapp.models.Animal
import com.example.zooapp.ui.theme.theme.ZooAppTheme

import androidx.compose.material3.ExperimentalMaterial3Api
import navigation.NavGraph

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavGraph()
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
    ZooAppTheme {
        Greeting("Android")
    }
}

val animalList = listOf(
    Animal(
        id = 1,
        name = "Garfield",
        species = "Felis catus",
        imageRes = R.drawable.garfield, // Substitua por uma imagem de Garfield
        description = "Garfield é um gato preguiçoso e adora lasanha.",
        curiosities = "Garfield detesta segunda-feira e ama dormir."
    ),
    Animal(
        id = 2,
        name = "Snoopy",
        species = "Canis lupus familiaris",
        imageRes = R.drawable.snoopy, // Substitua por uma imagem de Snoopy
        description = "Snoopy é um beagle e o fiel companheiro de Charlie Brown.",
        curiosities = "Snoopy tem uma rica imaginação e adora se fantasiar."
    ),
    Animal(
        id = 3,
        name = "Tom",
        species = "Felis catus",
        imageRes = R.drawable.tom, // Substitua por uma imagem de Tom
        description = "Tom é o gato da famosa dupla de desenhos Tom e Jerry.",
        curiosities = "Tom sempre tenta pegar Jerry, mas raramente tem sucesso."
    ),
    Animal(
        id = 4,
        name = "Jerry",
        species = "Mus musculus",
        imageRes = R.drawable.jerry, // Substitua por uma imagem de Jerry
        description = "Jerry é o rato esperto que sempre engana Tom.",
        curiosities = "Jerry é muito rápido e inteligente, sempre escapando de Tom."
    ),
    Animal(
        id = 5,
        name = "Simba",
        species = "Panthera leo",
        imageRes = R.drawable.simba, // Substitua por uma imagem de Simba
        description = "Simba é o protagonista de 'O Rei Leão' e um jovem leão que se torna rei.",
        curiosities = "Simba tem que enfrentar seu destino para se tornar o rei da savana."
    ),
    Animal(
        id = 6,
        name = "Squirrel (Scrat)",
        species = "Sciuridae",
        imageRes = R.drawable.scrat, // Substitua por uma imagem do Scrat
        description = "Scrat é o esquilo de 'Era do Gelo' que sempre persegue uma noz.",
        curiosities = "Scrat nunca consegue pegar sua noz, sempre causando grandes desastres."
    )
)

