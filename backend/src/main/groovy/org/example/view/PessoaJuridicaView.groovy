package org.example.view

import org.example.Controller.EmpresaController
import org.example.Model.Empresa

class PessoaJuridicaView {
    private EmpresaController pessoaJuridicaController = new EmpresaController()
    static scanner = new Scanner(System.in)

    void menuPessoaJuridica() {
        Scanner scanner = new Scanner(System.in)

        while (true) {
            println """
        1 - Cadastrar Pessoa Juridica
        2 - Listar Pessoas Juridicas
        3 - Voltar
        """

            print "Escolha uma opcao: "
            def input = scanner.nextLine().trim()
            int opcao = -1
            try {
                opcao = input.toInteger()
            } catch (Exception e) {
                println "Entrada inválida! Digite um número de 1 a 3."
                continue
            }

            switch (opcao) {
                case 1:
                    limpaTela()
                    cadastrarEmpresa()
                    break
                case 2:
                    limpaTela()
                    listarEmpresas()
                    break
                case 3:
                    limpaTela()
                    return
                default:
                    println "Opcao invalida! Digite 1, 2 ou 3."
            }
        }
    }


    void cadastrarEmpresa(){
        String nome, descricao, cnpj, pais, email,  cep, estado
        List<String> competencias = new ArrayList<>()

        println "Digite o nome: "
        nome = scanner.nextLine()
        println "Digite o email: "
        email = scanner.nextLine()
        println "Digite o cep: "
        cep = scanner.nextLine()
        println "Digite o estado: "
        estado = scanner.nextLine()
        println "Digite a descricao: "
        descricao = scanner.nextLine()
        println "Digite o cnpj: "
        cnpj = scanner.nextLine()
        println "Digite o pais: "
        pais = scanner.nextLine()
        for(int i = 0; i < 3; i++){
            println "Digite a competencia ${i+1}: "
            String competencia = scanner.nextLine()
            competencias.add(competencia)
        }

        Empresa pessoaJuridica =  new Empresa(nome, email, cep, estado, descricao, cnpj, pais, competencias)
        try {
            pessoaJuridicaController.cadastrarPessoaJuridica(pessoaJuridica)
            println "Pessoa Juridica cadastrada com sucesso!"
        } catch (Exception e) {
            println "Erro ao cadastrar Pessoa Juridica: ${e.message}"
        }
    }

    void listarEmpresas(){
        try{
             pessoaJuridicaController.listarPessoaJuridica()
        } catch (Exception e) {
            println "Erro ao listar Pessoas Juridicas: ${e.message}"
        }
    }

    void limpaTela(){
        for(int i = 0; i < 50; i++){
            println ""
        }
    }


}
