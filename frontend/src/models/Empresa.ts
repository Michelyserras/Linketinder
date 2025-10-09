import Pessoa from "./Pessoa";

class Empresa extends Pessoa {
    private cnpj: string;
    private pais: string;
    private vagas: string[];

    constructor(id: number, nome: string, email: string, cep: string, estado: string, descricao: string, cnpj: string, pais: string, vagas: string[]) {
        super(id, nome, email, cep, estado, descricao);
        this.cnpj = cnpj;
        this.pais = pais;
        this.vagas = vagas;
    }
    public getCnpj(): string {
        return this.cnpj;
    }

    public setCnpj(cnpj: string): void {
        this.cnpj = cnpj;
    }

    public getPais(): string {
        return this.pais;
    }

    public setPais(pais: string): void {
        this.pais = pais;
    }

    public getVagas(): string[] {
        return this.vagas;
    }

    public setVagas(vagas: string[]): void {
        this.vagas = vagas;
    }



    curtidas(): number {
        return 0;
    }

}

export default Empresa;