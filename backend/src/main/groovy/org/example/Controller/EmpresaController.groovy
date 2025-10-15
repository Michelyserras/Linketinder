package org.example.Controller


import org.example.Model.Empresa

class EmpresaController {
   static List<Empresa> empresas = []

    public EmpresaController(){
        inicializarEmpresas()
    }

    void cadastrarEmpresa(Empresa pj){
        if(pj.nome.trim().isEmpty() || pj.email.trim().isEmpty() || pj.cep.trim().isEmpty() || pj.estado.trim().isEmpty() || pj.descricao.trim().isEmpty() || pj.cnpj.trim().isEmpty()){
            throw new Exception("Todos os campos devem ser preenchidos corretamente.")
        }
        empresas.add(pj)
    }

    void listarEmpresa() {
        if (empresas.isEmpty()){
            throw new Exception("Nenhuma empresa cadastrada.")
        } else{
            for(Empresa pj : empresas){
                println "--------------------------------"
                println pj.toString()
                println "--------------------------------"
            }
        }
    }

    void inicializarEmpresas(){
        empresas.add(new Empresa("Arroz-Gostoso", "contato@arrozgostoso.com", "Brasil", "SP", "11111-111", "Empresa de alimentos", "12345678000101", ["Java", "Spring Boot"]))
        empresas.add(new Empresa("Império do Boliche", "contato@imperioboliche.com", "Brasil", "RJ", "22222-222", "Entretenimento e lazer", "23456789000102", ["Angular", "React"]))
        empresas.add(new Empresa("Tech Solutions", "contato@techsolutions.com", "Brasil", "MG", "33333-333", "Consultoria de TI", "34567890000103", ["Python", "SQL"]))
        empresas.add(new Empresa("EducaMais", "contato@educamais.com", "Brasil", "RS", "44444-444", "Educação online", "45678901000104", ["Java", "Spring Framework"]))
        empresas.add(new Empresa("Finanças Fáceis", "contato@financasfaceis.com", "Brasil", "BA", "55555-555", "Fintech", "56789012000105", ["Python", "Java"]))
    }
}
