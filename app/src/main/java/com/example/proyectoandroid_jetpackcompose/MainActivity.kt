package com.example.proyectoandroid_jetpackcompose

import android.os.Bundle
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableOpenTarget
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectoandroid_jetpackcompose.ui.theme.ProyectoAndroid_JetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoAndroid_JetPackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /*
                    ESTO VENIA POR DEFECTO
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    HolaMundo("Chao mundo", Modifier.padding(innerPadding))
                    */
                    //AQUI SE LE DAN TODAS LAS MODIFICACIONES A LA VARIABLE MODIF APLICADO A_TODO LO QUE LO TENGA
                    Tarjeta(Modifier.padding(innerPadding).background(Color.Magenta).fillMaxWidth())

                }
            }
        }
    }
}
@Composable
// Aqui se crea la funcion que usa Jetpack compose e ingrresa un string y la libreria modifier que
// hay que darle el nombre del dato, el tipo y el valor por defecto que en este caso es Modifier, por
// eso es que sigue funcionando en el preview
fun HolaMundo(texto : String, modif: Modifier = Modifier, col: Color){
    Text(texto,modif, color = col)
}
@Preview(showBackground = true)
@Composable
fun PreviewHolamundo(){
    HolaMundo("Hola lindo dia", col = Color.Green)
}


//TARJETA
@Composable
fun Tarjeta(modif: Modifier = Modifier){
    Row (modif){
        Image(painterResource(R.drawable.perro), "Perro", Modifier.size(100.dp))
        Column {
            Text("Hola juanito", color = Color.Yellow)
            Text("Es un lindo dia para programar", color = Color.Blue)
            HolaMundo("Me hago pipi", col = Color.Cyan)

            var contexto = LocalContext.current
            Button(onClick = {
                Toast.makeText(contexto, "Ha funcionado el boton", Toast.LENGTH_SHORT).show()
            }
            ) {
                Text("Boton Magico")
            }
            MyCard()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun verTarjeta(){
    Tarjeta()
}

//CARD
@Preview(showBackground = true)
@Composable
fun MyCard(){
    Card {
        Column {
            Image(painterResource(R.drawable.ic_launcher_foreground), "Icono Android", Modifier.height(100.dp).fillMaxWidth())
        }
        Column {
            Text("Android")
            Spacer(Modifier.height(5.dp))
            Text("Ocupando JetpackCompose", fontSize = 8.sp)
        }
    }
}

//GREETING
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
    ProyectoAndroid_JetPackComposeTheme {
        Greeting("Android")
    }
}