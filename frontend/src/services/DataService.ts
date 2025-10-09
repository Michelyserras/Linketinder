import Candidato from '../models/Candidato';
import Empresa from '../models/Empresa';
import Vaga from '../models/Vaga';

export class DataService {
  
    static candidatos: Candidato[] = [];
    static empresas: Empresa[] = [];
    static vagas: Vaga[] = [];
    static usuarioLogado: any = null;

    static carregarDados(): void {
        const candidatosString = localStorage.getItem('candidatos');
        if (candidatosString) {
            const candidatosData = JSON.parse(candidatosString);
            this.candidatos = candidatosData.map((data: any) => {
                const candidato = new Candidato(data.id, data.nome, data.email, data.cep, data.estado, data.descricao, data.cpf, data.idade, data.competencias);
              
                if (data.senha) {
                    (candidato as any).senha = data.senha;
                }
                return candidato;
            });
        }

        const empresasString = localStorage.getItem('empresas');
        if (empresasString) {
            const empresasData = JSON.parse(empresasString);
            this.empresas = empresasData.map((data: any) => {
                const empresa = new Empresa(data.id, data.nome, data.email, data.cep, data.estado, data.descricao, data.cnpj, data.pais, data.vagas || []);
                if (data.senha) {
                    (empresa as any).senha = data.senha;
                }
                return empresa;
            });
        }

        const vagasString = localStorage.getItem('vagas');
        if (vagasString) {
            const vagasData = JSON.parse(vagasString);
            this.vagas = vagasData.map((data: any) =>
                new Vaga(data.id, data.empresaId, data.titulo, data.descricao, data.competencias, data.salario, data.localidade)
            );
        }

        const usuarioString = localStorage.getItem('usuarioLogado');
        if (usuarioString) {
            this.usuarioLogado = JSON.parse(usuarioString);
        }
    }


    static gerarId(): number {
        return Date.now();
    }

 
    static salvarCandidato(candidato: Candidato): boolean {
        
        for (let i = 0; i < this.candidatos.length; i++) {
            if (this.candidatos[i].Email === candidato.Email) {
                return false;
            }
        }

        this.candidatos.push(candidato);
        localStorage.setItem('candidatos', JSON.stringify(this.candidatos));
        return true;
    }

   
    static salvarEmpresa(empresa: Empresa): boolean {
        for (let i = 0; i < this.empresas.length; i++) {
            if (this.empresas[i].Email === empresa.Email) {
                return false;
            }
        }

        this.empresas.push(empresa);
        localStorage.setItem('empresas', JSON.stringify(this.empresas));
        return true;
    }

   
    static fazerLogin(email: string, senha: string): boolean {
        this.carregarDados();

      
        for (let i = 0; i < this.candidatos.length; i++) {
            if (this.candidatos[i].Email === email && (this.candidatos[i] as any).senha === senha) {
                this.usuarioLogado = {
                    id: this.candidatos[i].Id,
                    tipo: 'candidato',
                    dados: this.candidatos[i]
                };
                localStorage.setItem('usuarioLogado', JSON.stringify(this.usuarioLogado));
                return true;
            }
        }

       
        for (let i = 0; i < this.empresas.length; i++) {
            if (this.empresas[i].Email === email && (this.empresas[i] as any).senha === senha) {
                this.usuarioLogado = {
                    id: this.empresas[i].Id,
                    tipo: 'empresa',
                    dados: this.empresas[i]  
                };
                localStorage.setItem('usuarioLogado', JSON.stringify(this.usuarioLogado));
                return true;
            }
        }

        return false;
    }

    
    static fazerLogout(): void {
        this.usuarioLogado = null;
        localStorage.removeItem('usuarioLogado');
    }


    static salvarVaga(vaga: Vaga): void {
        this.vagas.push(vaga);
        localStorage.setItem('vagas', JSON.stringify(this.vagas));
    }

    
    static buscarTodasAsVagas(): Vaga[] {
        return this.vagas;
    }


    static buscarVagasDaEmpresa(empresaId: number): Vaga[] {
        const vagasDaEmpresa: Vaga[] = [];
        for (let i = 0; i < this.vagas.length; i++) {
            if (this.vagas[i].getEmpresaId() === empresaId) {
                vagasDaEmpresa.push(this.vagas[i]);
            }
        }
        return vagasDaEmpresa;
    }

    static buscarEmpresaPorId(id: number): Empresa | null {
        for (let i = 0; i < this.empresas.length; i++) {
            if (this.empresas[i].Id === id) {
                return this.empresas[i];
            }
        }
        return null;
    }

    
    static buscarTodosCandidatos(): Candidato[] {
        return this.candidatos;
    }

    
    static contarCompetenciasCandidatos(): { [competencia: string]: number } {
        const contagem: { [competencia: string]: number } = {};

        for (let i = 0; i < this.candidatos.length; i++) {
            const competencias = this.candidatos[i].competencias;
            for (let j = 0; j < competencias.length; j++) {
                const comp = competencias[j].trim();
                if (comp) {
                    contagem[comp] = (contagem[comp] || 0) + 1;
                }
            }
        }

        return contagem;
    }
}