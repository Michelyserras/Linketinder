package org.example.view

class MainView {
    Scanner scanner = new Scanner(System.in)
    CandidatoView pessoaFisicaView = new CandidatoView()
    EmpresaView pessoaJuridicaView = new EmpresaView()

    void menu() {
        while (true) {
            println """
            1 - Gerenciar Candidatos
            2 - Gerenciar Empresas
            3 - Sair
            """

            print "Escolha uma opcao: "
            def input = scanner.nextLine().trim()
            int opcao = -1
            try {
                opcao = input.toInteger()
            } catch (Exception e) {
                println "Entrada inválida! Digite um número entre 1 e 3."
                continue
            }

            switch (opcao) {
                case 1:
                    limpaTela()
                    pessoaFisicaView.menuPessoaFisica()
                    break
                case 2:
                    limpaTela()
                    pessoaJuridicaView.menuPessoaJuridica()
                    break
                case 3:
                    limpaTela()
                    println "Saindo..."
                    System.exit(0)
                    break
                default:
                    println "Opcao invalida! Digite 1, 2 ou 3."
            }


        }

    }

    void limpaTela() {
        for(int i = 0; i < 50; i++) {
            println ""
        }
    }
}

