
import { DataService } from '../services/DataService';

export function cadastroCandidato() {
    const cadastro = document.createElement('div');
    cadastro.className = "CandidatoForm";
    cadastro.innerHTML = `
    <h1>Cadastro Candidato</h1>
      <form>
        <div class="group">
          <label for="nome">Nome:</label>
          <input type="text" id="nome" name="nome" required />
        </div>
        <div class="group">
          <label for="email">Email:</label>   
          <input type="email" id="email" name="email" required />
        </div>
        <div class="group">
          <label for="cep">CEP:</label>
          <input type="text" id="cep" name="cep" required />
        </div>
        <div class="group">
          <label for="estado">Estado:</label>
          <input type="text" id="estado" name="estado" required />
        </div>
        <div class="group">
          <label for="cpf">CPF:</label>
          <input type="text" id="cpf" name="cpf" required />
        </div>
        <div class="group">
          <label for="idade">Idade:</label>
          <input type="number" id="idade" name="idade" required />
        </div>
        <div class="group full-width">
          <label for="descricao">Descrição:</label>
          <input type="text" id="descricao" name="descricao" required />
        </div>
        <div class="group full-width">
          <label for="habilidades">Habilidades:</label>
          <input type="text" id="habilidades" name="habilidades" required />
          <label for="senha">Senha:</label>
          <input type="password" id="senha" name="senha" required />
        </div>
        <div class="button-container">
          <button type="button" onclick="processarCadastroCandidato()">Salvar</button>
          <button type="button" onclick="mostrarTelaPrincipal()">Cancelar</button>
        </div>
      </form>`;

    return cadastro;
}

export function loginCandidato() {
    const login = document.createElement('div');
    login.className = "CandidatoLogin";
    login.innerHTML = `
    <h1>Login Candidato</h1>
      <form>
        <div class="group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required />
        </div>
        <div class="group">
            <label for="senha">Senha:</label>
            <input type="password" id="senha" name="senha" required />
        </div>
        <div class="button-container">
            <button type="button" onclick="processarLogin()">Login</button>
            <button type="button" onclick="mostrarTelaPrincipal()">Cancelar</button>
        </div>
      </form>`;

    return login;
}

export function candidatoPerfil() {
    // Carregar dados se ainda não foram carregados
    DataService.carregarDados();

    let nomeCandidato = 'Não informado';
    let emailCandidato = 'Não informado';
    let cpfCandidato = 'Não informado';
    let idadeCandidato = 'Não informado';
    let cepCandidato = 'Não informado';
    let estadoCandidato = 'Não informado';
    let descricaoCandidato = 'Não informado';
    let competenciasCandidato = 'Não informado';

    if (DataService.usuarioLogado && DataService.usuarioLogado.tipo === 'candidato') {
        const candidato = DataService.usuarioLogado.dados;

        nomeCandidato = candidato.Nome || candidato.nome || 'Não informado';
        emailCandidato = candidato.Email || candidato.email || 'Não informado';
        // Usar método se disponível, senão usar propriedade direta
        cpfCandidato = (typeof candidato.getCpf === 'function' ? candidato.getCpf() : candidato.cpf) || 'Não informado';
        // Usar método se disponível, senão usar propriedade direta
        idadeCandidato = (typeof candidato.getIdade === 'function' ? candidato.getIdade() : candidato.idade);
        idadeCandidato = idadeCandidato ? `${idadeCandidato} anos` : 'Não informado';
        cepCandidato = candidato.Cep || candidato.cep || 'Não informado';
        estadoCandidato = candidato.Estado || candidato.estado || 'Não informado';
        descricaoCandidato = candidato.Descricao || candidato.descricao || 'Não informado';
        // Usar método se disponível, senão usar propriedade direta
        const competencias = (typeof candidato.getCompetencias === 'function' ? candidato.getCompetencias() : candidato.competencias);
        competenciasCandidato = competencias ? competencias.join(', ') : 'Não informado';
    }

    // Buscar todas as vagas disponíveis
    const todasAsVagas = DataService.buscarTodasAsVagas();
    let vagasHtml = '';

    if (todasAsVagas.length > 0) {
        vagasHtml = todasAsVagas.map(vaga => {
            return `
                <div class="vaga-item">
                    <div class="vaga-titulo">${vaga.getTitulo()}</div>
                    <div class="vaga-empresa">Empresa Anônima</div>
                    
                    <div class="vaga-detalhes">
                        <div class="vaga-detalhe">
                            <strong>Salário:</strong> ${vaga.getSalario()}
                        </div>
                        <div class="vaga-detalhe">
                            <strong>Local:</strong> ${vaga.getLocalidade()}
                        </div>
                    </div>
                    
                    <div class="vaga-descricao">${vaga.getDescricao()}</div>
                    
                    <div class="vaga-competencias">
                        <strong>Competências:</strong>
                        <div class="competencias-tags">
                            ${vaga.getCompetencias().map(comp => `<span class="competencia-tag">${comp}</span>`).join('')}
                        </div>
                    </div>
                </div>
            `;
        }).join('');
    } else {
        vagasHtml = '<div class="sem-vagas">Nenhuma vaga disponível no momento.</div>';
    }

    const perfil = document.createElement('div');
    perfil.className = "PerfilContainer";
    perfil.innerHTML = `
        <button class="back-button" onclick="mostrarTelaPrincipal()" title="Voltar à página inicial">←</button>
        
        <h1>Meu Perfil - Candidato</h1>
        
        <div class="perfil-info">
            <div class="info-item">
                <span class="info-label">Nome</span>
                <span class="info-value">${nomeCandidato}</span>
            </div>
            
            <div class="info-item">
                <span class="info-label">Email</span>
                <span class="info-value">${emailCandidato}</span>
            </div>
            
            <div class="info-item">
                <span class="info-label">CPF</span>
                <span class="info-value">${cpfCandidato}</span>
            </div>
            
            <div class="info-item">
                <span class="info-label">Idade</span>
                <span class="info-value">${idadeCandidato}</span>
            </div>
            
            <div class="info-item">
                <span class="info-label">CEP</span>
                <span class="info-value">${cepCandidato}</span>
            </div>
            
            <div class="info-item">
                <span class="info-label">Estado</span>
                <span class="info-value">${estadoCandidato}</span>
            </div>
            
            <div class="info-item full-width">
                <span class="info-label">Descrição</span>
                <span class="info-value">${descricaoCandidato}</span>
            </div>
            
            <div class="info-item full-width">
                <span class="info-label">Competências</span>
                <span class="info-value">${competenciasCandidato}</span>
            </div>
        </div>
        
        <div class="perfil-actions">
            <button onclick="processarLogout()">Sair</button>
        </div>
        
        <div class="vagas-section">
            <h3>Vagas Disponíveis</h3>
            <div class="vagas-lista">
                ${vagasHtml}
            </div>
        </div>
    `;

    return perfil;
}





export function candidatoVagas() {
    const vagas = document.createElement('div');
    vagas.innerHTML = `
        <h1>Vagas do Candidato</h1>
        <ul id="lista-vagas">
            <li><strong>Vaga 1:</strong> Descrição da vaga 1</li>
            <li><strong>Vaga 2:</strong> Descrição da vaga 2</li>
            <li><strong>Vaga 3:</strong> Descrição da vaga 3</li>
        </ul>
    `;
    return vagas;
}