
import { DataService } from '../services/DataService';
import { gerarGraficoCompetencias } from '../components/grafico';

export function empresaPerfil() {
    // Carregar dados se ainda não foram carregados
    DataService.carregarDados();

    let nomeEmpresa = 'Não informado';
    let emailEmpresa = 'Não informado';
    let cnpjEmpresa = 'Não informado';
    let cepEmpresa = 'Não informado';
    let estadoEmpresa = 'Não informado';
    let paisEmpresa = 'Não informado';
    let descricaoEmpresa = 'Não informado';
    let empresaId = null;

    if (DataService.usuarioLogado && DataService.usuarioLogado.tipo === 'empresa') {
        const empresa = DataService.usuarioLogado.dados;

        empresaId = empresa.Id || empresa.id;
        nomeEmpresa = empresa.Nome || empresa.nome || 'Não informado';
        emailEmpresa = empresa.Email || empresa.email || 'Não informado';
        cnpjEmpresa = (typeof empresa.getCnpj === 'function' ? empresa.getCnpj() : empresa.cnpj) || 'Não informado';
        cepEmpresa = empresa.Cep || empresa.cep || 'Não informado';
        estadoEmpresa = empresa.Estado || empresa.estado || 'Não informado';
        paisEmpresa = (typeof empresa.getPais === 'function' ? empresa.getPais() : empresa.pais) || 'Não informado';
        descricaoEmpresa = empresa.Descricao || empresa.descricao || 'Não informado';
    }

   
    let vagasHtml = '';
    if (empresaId) {
        const vagasDaEmpresa = DataService.buscarVagasDaEmpresa(empresaId);

        if (vagasDaEmpresa.length > 0) {
            vagasHtml = vagasDaEmpresa.map(vaga => `
                <div class="vaga-item">
                    <div class="vaga-titulo">${vaga.getTitulo()}</div>
                    
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
            `).join('');
        } else {
            vagasHtml = '<div class="sem-vagas">Você ainda não publicou nenhuma vaga.</div>';
        }
    } else {
        vagasHtml = '<div class="sem-vagas">Erro ao carregar vagas.</div>';
    }

    const perfil = document.createElement('div');
    perfil.className = "PerfilContainer";
    perfil.innerHTML = `
        <button class="back-button" onclick="mostrarTelaPrincipal()" title="Voltar à página inicial">←</button>
        
        <h1>Meu Perfil - Empresa</h1>
        
        <div class="perfil-info">
            <div class="info-item">
                <span class="info-label">Nome da Empresa</span>
                <span class="info-value">${nomeEmpresa}</span>
            </div>
            
            <div class="info-item">
                <span class="info-label">Email</span>
                <span class="info-value">${emailEmpresa}</span>
            </div>
            
            <div class="info-item">
                <span class="info-label">CNPJ</span>
                <span class="info-value">${cnpjEmpresa}</span>
            </div>
            
            <div class="info-item">
                <span class="info-label">CEP</span>
                <span class="info-value">${cepEmpresa}</span>
            </div>
            
            <div class="info-item">
                <span class="info-label">Estado</span>
                <span class="info-value">${estadoEmpresa}</span>
            </div>
            
            <div class="info-item">
                <span class="info-label">País</span>
                <span class="info-value">${paisEmpresa}</span>
            </div>
            
            <div class="info-item full-width">
                <span class="info-label">Descrição da Empresa</span>
                <span class="info-value">${descricaoEmpresa}</span>
            </div>
        </div>
        
        <div class="perfil-actions">
            <button onclick="mostrarFormularioVaga()">Publicar Vaga</button>
            <button onclick="processarLogout()">Sair</button>
        </div>
        
        <div class="vagas-section">
            <h3>Minhas Vagas Publicadas</h3>
            <div class="vagas-lista">
                ${vagasHtml}
            </div>
        </div>
        
        ${gerarGraficoCompetencias()}
    `;

    return perfil;
}

export function empresaLogin() {
    const login = document.createElement('div');
    login.className = "EmpresaLogin";
    login.innerHTML = `
    <h1>Login Empresa</h1>
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

export function cadastroEmpresa() {
    const cadastro = document.createElement('div');
    cadastro.className = "EmpresaForm";
    cadastro.innerHTML = `
        <h1>Cadastro Empresa</h1>
        <form method="dialog">
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
                <label for="pais">País:</label>
                <input type="text" id="pais" name="pais" required />
            </div>
            <div class="group">
                <label for="estado">Estado:</label>
                <input type="text" id="estado" name="estado" required />
            </div>
            <div class="group">
                <label for="cnpj">CNPJ:</label>
                <input type="text" id="cnpj" name="cnpj" required />
            </div>
            <div class="group full-width">
                <label for="descricao">Descrição:</label>
                <input type="text" id="descricao" name="descricao" required />
                <label for="senha">Senha:</label>
                <input type="password" id="senha" name="senha" required />
            </div>
            <div class="button-container">
                <button type="button" onclick="processarCadastroEmpresa()">Salvar</button>
                <button type="button" onclick="mostrarTelaPrincipal()">Cancelar</button>
            </div>
        </form>`;
    return cadastro;
}


