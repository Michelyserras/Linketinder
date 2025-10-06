import org.example.Controller.PessoaFisicaController
import org.example.Model.PessoaFisica
import spock.lang.Specification


class PessoaFisicaControllerTest extends Specification {

    def "testCreateCandidatos"(){
        given: "Controller de Pessoa Fisica (Candidatos)"
        def controller = new PessoaFisicaController()
        controller.candidatos = []
        def candidato = new PessoaFisica("Michely Teste","michely@email.com", "SP", "12345-678",  "Teste de cadastro", "98765432100",  27, ["Java", "Groovy"])

        when: "Cadastrando um novo candidato"
        controller.cadastrarPessoaFisica(candidato)

        then: "Verificando se o candidato foi adicionado"
        controller.candidatos.size() == 1
        controller.candidatos.contains(candidato)

    }




}