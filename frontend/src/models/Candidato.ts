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

    getCpf(): string {
        return this.cpf;
    }

    setCpf(cpf: string): void {
        this.cpf = cpf;
    }

    getIdade(): number {
        return this.idade;
    }

    setIdade(idade: number): void {
        this.idade = idade;
    }

    getCompetencias(): string[] {
        return this.competencias;
    }

    setCompetencias(competencias: string[]): void {
        this.competencias = competencias;
    }

    curtidas():number{
        return 0;
    }

}

export default Candidato;