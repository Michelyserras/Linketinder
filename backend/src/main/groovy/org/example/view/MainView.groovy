package org.example.view

class MainView {
    Scanner scanner = new Scanner(System.in)
    CandidatoView candidatoView= new CandidatoView()


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
                    candidatoView.menuCandidato()
                    break
//                case 2:
//                    limpaTela()
//                    empresaView.menuEmpresa()
//                    break
                case 2:
                    limpaTela()
                    println "Saindo..."
                    System.exit(0)
                    break
                default:
                    println "Opcao invalida! Digite 1 ou 2."
            }


        }

    }

    void limpaTela() {
        for(int i = 0; i < 50; i++) {
            println ""
        }
    }
}

