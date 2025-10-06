
abstract class Pessoa {
    id: number;
    nome: string;
    email: string;
    cep: string;
    estado: string;
    descricao: string;

    constructor(id: number, nome: string, email: string, cep: string, estado: string, descricao: string) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cep = cep;
        this.estado = estado;
        this.descricao = descricao;
    }

    get Id(): number {
        return this.id;
    }
    set Id(value: number) {
        this.id = value;
    }

    get Nome(): string {
        return this.nome;
    }
    set Nome(value: string) {
        this.nome = value;
    }

    get Email(): string {
        return this.email;
    }
    set Email(value: string) {
        this.email = value;
    }

    get Cep(): string {
        return this.cep;
    }
    set Cep(value: string) {
        this.cep = value;
    }

    get Estado(): string {
        return this.estado;
    }
    set Estado(value: string) {
        this.estado = value;
    }

    get Descricao(): string {
        return this.descricao;
    }
    set Descricao(value: string) {
        this.descricao = value;
    }

    curtidas():number{
        return 0;
    }

}

export default Pessoa;