
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

    curtidas():number{
        return 0;
    }

}

export default Pessoa;