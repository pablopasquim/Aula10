package com.example.aula10.Models

class FolhaPagamento(
    var name: String,
    var horasTrab: Float,
    var valorHora: Float,
    var salarioBru: Float,
    var ir: Float,
    var inss: Float,
    var salarioLiq: Float
) {

    constructor(nome: String, horasTrab: Float, valorHora: Float):
            this(nome, horasTrab, valorHora,0f,0f,0f,0f){

            calSalarioBru()
            calcIR()
            calINSS()
            calSalarioLiq()

            }
    fun calSalarioBru(){
        salarioBru = valorHora * horasTrab
    }

    fun calcIR(){
         ir = salarioBru * 0.08f
    }

    fun calINSS(){
        inss = salarioBru * 0.09f
    }

    fun calSalarioLiq(){
        salarioLiq = salarioBru - inss - ir
    }

    override fun toString(): String {

        return "FOLHA CALCULADA: " +
                "\n Nome do Funcionário: $name" +
                "\n Hora Trabalhadas: $horasTrab" +
                "\n Valor da hora: R$ $valorHora" +
                "\n Salário Bruto: R$ $salarioBru" +
                "\n IR do mês: R$ $ir" +
                "\n INSS do mês: R$ $inss" +
                "\n Salário Líquido: R$ ${String.format("%.2f", salarioLiq)}"
    }
}