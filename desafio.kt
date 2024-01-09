// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val name: String, val email: String) {
    // Additional properties and methods can be added here
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, var nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("${usuario.name} foi matriculado na formação $nome.")
        } else {
            println("${usuario.name} já está matriculado na formação $nome.")
        }
    }
}

fun main() {
    val usuario1 = Usuario("Giovandro Fabio dos Santos", "giovandrofabiosantos@hotmail.com")
    val usuario2 = Usuario("Carolina Domingos Pelissari", "carol@hotmail.com")

    val conteudo1 = ConteudoEducacional("Introdução à Programação", 120, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Kotlin", 180, Nivel.BASICO) 

    val formacao = Formacao("Analise e Desenvolvimento de Sistema", listOf(conteudo1, conteudo2)) 

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario1) // Trying to enroll the same user again
    
    println("Inscritos na formação ${formacao.nome}: ${formacao.inscritos.joinToString(", ") { it.name }}")  
}
