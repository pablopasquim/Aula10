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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aula10.Models.FolhaPagamento
import com.example.aula10.View.ui.theme.Aula10Theme

class FolhaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutFolha()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutFolha(){

    var name by remember {
        mutableStateOf("")
    }

    var horasTrab by remember {
        mutableStateOf("")
    }

    var valorHora by remember {
        mutableStateOf("")
    }

    var folhaCalculada by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        
        TextField(value = name, 
            onValueChange = { name = it},
            label = { Text(text = "Informe o nome do funcionário")})
        
        Spacer(modifier = Modifier.height(20.dp))

        TextField(value = horasTrab,
            onValueChange = { horasTrab = it},
            label = { Text(text = "Horas trabalhadas no mês")})

        Spacer(modifier = Modifier.height(20.dp))

        TextField(value = valorHora,
            onValueChange = { valorHora= it},
            label = { Text(text = "Informe o valor da horas")})

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            
            // Converter horas e valor em float
            val horasTrabalhadas = horasTrab.toFloatOrNull() ?: 0f
            val valorHoras = valorHora.toFloatOrNull() ?: 0f
            
            // criar objeto FolhaPagamento (models)
            val folha = FolhaPagamento(name, horasTrabalhadas, valorHoras)
            
            folhaCalculada = folha.toString()
            
        }) {
            Text(text = "Calcular a folha de pagamento")
        }

        Spacer(modifier = Modifier.height(20.dp))
        
        Text(text = folhaCalculada, fontSize = 25.sp)
    }
}
@Preview (showBackground = true)
@Composable
fun PreviewFolha(){
    LayoutFolha()
}
