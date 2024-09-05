package com.example.aula10.Models

class Contato(

    var name: String,
    var email: String,
    var phone: String

) {

    init {

        if (name.isEmpty()){
            name = "Desconhecido"
        }
        if (email.isEmpty()){
            email = "Não informado"
        }
        if (phone.isEmpty()){
            phone = "Não informado"
        }

    }
    override fun toString(): String {
        return     "Nome: $name" +
                "\n Fone: $phone" +
                 "\nE-mail: $email"
    }
}