package com.example.aula10.View

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aula10.Models.Contato
import com.example.aula10.View.ui.theme.Aula10Theme

class ContatoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutContato()
        }
    }
}

@Composable
fun LayoutContato(){

    var name by remember {
        mutableStateOf("")
    }

    var phone by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var cadastro by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Cadastrar Contato",
            fontSize = 25.sp)

        CustomTextField(valor = name,
            onValueChange = { name = it },
            label = "Nome do contato")

        Spacer(modifier = Modifier.height(20.dp))

        CustomTextField(valor = phone,
            onValueChange = { phone = it },
            label = "Telefone do contato")

        Spacer(modifier = Modifier.height(20.dp))

        CustomTextField(valor = email,
            onValueChange = { email = it },
            label = "Email do contato")

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            var contato = Contato(name, phone,email)
            cadastro = "\nContato Salvo: \n$contato"

        }) {
            Text(text = "Salvar o contato")
        }

        Text(text = cadastro, color = Color.Red)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(

    valor: String,
    onValueChange: (String) -> Unit,
    label: String

) {

    TextField(value = valor,
        onValueChange = onValueChange,
        label = { Text(text = label)})
}


