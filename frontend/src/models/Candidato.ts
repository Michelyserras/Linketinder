import Pessoa from "./Pessoa";

class Candidato extends Pessoa {
    cpf: string;
    idade: number;
    competencias: string[];

    constructor(id: number, nome: string, email: string, cep: string, estado: string, descricao: string, cpf: string, idade: number, competencias: string[]) {
        super(id, nome, email, cep, estado, descricao);
        this.cpf = cpf;
        this.idade = idade;
        this.competencias = competencias;
    }

    curtidas():number{
        return 0;
    }

}

export default Candidato;