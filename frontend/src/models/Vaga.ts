class Vaga {
    id: number;
    empresaId: number;
    titulo: string;
    descricao: string;
    competencias: string[];
    salario: string;
    localidade: string;

    constructor(id: number, empresaId: number, titulo: string, descricao: string, competencias: string[], salario: string, localidade: string) {
        this.id = id;
        this.empresaId = empresaId;
        this.titulo = titulo;
        this.descricao = descricao;
        this.competencias = competencias;
        this.salario = salario;
        this.localidade = localidade;
    }

    getId(): number {
        return this.id;
    }

    setId(id: number): void {
        this.id = id;
    }

    getEmpresaId(): number {
        return this.empresaId;
    }

    setEmpresaId(empresaId: number): void {
        this.empresaId = empresaId;
    }

    getTitulo(): string {
        return this.titulo;
    }

    setTitulo(titulo: string): void {
        this.titulo = titulo;
    }

    getDescricao(): string {
        return this.descricao;
    }

    setDescricao(descricao: string): void {
        this.descricao = descricao;
    }

    getCompetencias(): string[] {
        return this.competencias;
    }

    setCompetencias(competencias: string[]): void {
        this.competencias = competencias;
    }

    getSalario(): string {
        return this.salario;
    }

    setSalario(salario: string): void {
        this.salario = salario;
    }

    getLocalidade(): string {
        return this.localidade;
    }

    setLocalidade(localidade: string): void {
        this.localidade = localidade;
    }
}

export default Vaga;