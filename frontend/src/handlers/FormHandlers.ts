import Candidato from '../models/Candidato';
import Empresa from '../models/Empresa';
import Vaga from '../models/Vaga';
import { DataService } from '../services/DataService';
import { mostrarTelaLoginCandidato, mostrarTelaLoginEmpresa, mostrarTelaPrincipal, mostrarPerfilCandidato, mostrarPerfilEmpresa } from '../pages/MostrarTela';
import * as validators from './validacao';


function formatarCompetencias(competenciasString: string): string[] {
    return competenciasString.split(',').map(competencia => competencia.trim()).filter(competencia => competencia.length > 0);
}


function getApp(): HTMLDivElement {
    return document.querySelector('#app') as HTMLDivElement;
}


export function processarCadastroCandidato(): void {
    const nome = (document.getElementById('nome') as HTMLInputElement).value;
    const email = (document.getElementById('email') as HTMLInputElement).value;
    const senha = (document.getElementById('senha') as HTMLInputElement).value;
    const cpf = (document.getElementById('cpf') as HTMLInputElement).value;
    const idade = parseInt((document.getElementById('idade') as HTMLInputElement).value);
    const cep = (document.getElementById('cep') as HTMLInputElement).value;
    const estado = (document.getElementById('estado') as HTMLInputElement).value;
    const descricao = (document.getElementById('descricao') as HTMLInputElement).value;
    const competenciasString = (document.getElementById('habilidades') as HTMLInputElement).value;


    if (!validators.validarNome(nome)) { alert('Nome inválido. Use apenas letras e espaços (mín. 2 caracteres).'); return; }
    if (!validators.validarEmail(email)) { alert('E-mail inválido.'); return; }
    if (!validators.validarCPF(cpf)) { alert('CPF inválido.'); return; }
    if (!validators.validarCEP(cep)) { alert('CEP inválido.'); return; }
    if (!validators.validarListaHabilidades(competenciasString)) { alert('Habilidades inválidas. Separe por vírgula e use caracteres válidos.'); return; }

    const competencias = formatarCompetencias(competenciasString);

    const candidato = new Candidato(
        DataService.gerarId(),
        nome,
        email,
        cep,
        estado,
        descricao,
        cpf,
        idade,
        competencias
    );


    (candidato as any).senha = senha;

    if (DataService.salvarCandidato(candidato)) {
        alert('Cadastro realizado com sucesso!');
        mostrarTelaLoginCandidato(getApp());
    } else {
        alert('Email já cadastrado!');
    }
}


export function processarCadastroEmpresa(): void {
    const nome = (document.getElementById('nome') as HTMLInputElement).value;
    const email = (document.getElementById('email') as HTMLInputElement).value;
    const senha = (document.getElementById('senha') as HTMLInputElement).value;
    const cnpj = (document.getElementById('cnpj') as HTMLInputElement).value;
    const cep = (document.getElementById('cep') as HTMLInputElement).value;
    const estado = (document.getElementById('estado') as HTMLInputElement).value;
    const pais = (document.getElementById('pais') as HTMLInputElement).value;
    const descricao = (document.getElementById('descricao') as HTMLInputElement).value;

    
    if (!validators.validarNome(nome)) { alert('Nome inválido. Use apenas letras e espaços (mín. 2 caracteres).'); return; }
    if (!validators.validarEmail(email)) { alert('E-mail inválido.'); return; }
    if (!validators.validarCNPJ(cnpj)) { alert('CNPJ inválido.'); return; }
    if (!validators.validarCEP(cep)) { alert('CEP inválido.'); return; }

    const empresa = new Empresa(
        DataService.gerarId(),
        nome,
        email,
        cep,
        estado,
        descricao,
        cnpj,
        pais,
        []
    );


    (empresa as any).senha = senha;

    if (DataService.salvarEmpresa(empresa)) {
        alert('Cadastro realizado com sucesso!');
        mostrarTelaLoginEmpresa(getApp());
    } else {
        alert('Email já cadastrado!');
    }
}


export function processarLogin(): void {
    const email = (document.getElementById('email') as HTMLInputElement).value;
    const senha = (document.getElementById('senha') as HTMLInputElement).value;

    if (DataService.fazerLogin(email, senha)) {
        if (DataService.usuarioLogado.tipo === 'candidato') {
            mostrarPerfilCandidato(getApp());
        } else {
            mostrarPerfilEmpresa(getApp());
        }
    } else {
        alert('Email ou senha incorretos!');
    }
}


export function processarLogout(): void {
    DataService.fazerLogout();
    mostrarTelaPrincipal(getApp());
}


export function processarPublicarVaga(): void {
    const titulo = (document.getElementById('titulo') as HTMLInputElement).value;
    const descricao = (document.getElementById('descricao') as HTMLTextAreaElement).value;
    const competenciasString = (document.getElementById('competencias') as HTMLInputElement).value;
    const salario = (document.getElementById('salario') as HTMLInputElement).value;
    const localidade = (document.getElementById('localidade') as HTMLInputElement).value;

    const competencias = formatarCompetencias(competenciasString);

    const vaga = new Vaga(
        DataService.gerarId(),
        DataService.usuarioLogado.id,
        titulo,
        descricao,
        competencias,
        salario,
        localidade
    );

    DataService.salvarVaga(vaga);
    alert('Vaga publicada com sucesso!');
    mostrarPerfilEmpresa(getApp());
}


export function mostrarFormularioVaga(): void {
    const app = getApp();
    app.innerHTML = `
        <div class="EmpresaForm">
            <button class="back-btn" onclick="mostrarPerfilEmpresa()">← Voltar</button>
            <h1>Publicar Nova Vaga</h1>
            <form>
                <div class="group">
                    <label for="titulo">Título da Vaga:</label>
                    <input type="text" id="titulo" name="titulo" required />
                </div>
                
                <div class="group">
                    <label for="competencias">Competências (separadas por vírgula):</label>
                    <input type="text" id="competencias" name="competencias" placeholder="Java, JavaScript, React..." required />
                </div>
                
                <div class="group">
                    <label for="salario">Salário:</label>
                    <input type="text" id="salario" name="salario" placeholder="R$ 0000,00" required />
                </div>
                
                <div class="group">
                    <label for="localidade">Localidade:</label>
                    <input type="text" id="localidade" name="localidade" required />
                </div>
                
                <div class="group full-width">
                    <label for="descricao">Descrição da Vaga:</label>
                    <textarea id="descricao" name="descricao" rows="4" required></textarea>
                </div>
                
                <div class="button-container">
                    <button type="button" onclick="processarPublicarVaga()">Publicar Vaga</button>
                    <button type="button" onclick="mostrarPerfilEmpresa()">Cancelar</button>
                </div>
            </form>
        </div>
    `;
}


declare global {
    interface Window {
        processarCadastroCandidato: () => void;
        processarCadastroEmpresa: () => void;
        processarLogin: () => void;
        processarLogout: () => void;
        processarPublicarVaga: () => void;
        mostrarFormularioVaga: () => void;
        mostrarTelaLoginCandidato: () => void;
        mostrarTelaLoginEmpresa: () => void;
        mostrarTelaPrincipal: () => void;
        mostrarPerfilCandidato: () => void;
        mostrarPerfilEmpresa: () => void;
    }
}

window.processarCadastroCandidato = processarCadastroCandidato;
window.processarCadastroEmpresa = processarCadastroEmpresa;
window.processarLogin = processarLogin;
window.processarLogout = processarLogout;
window.processarPublicarVaga = processarPublicarVaga;
window.mostrarFormularioVaga = mostrarFormularioVaga;
window.mostrarTelaLoginCandidato = () => mostrarTelaLoginCandidato(getApp());
window.mostrarTelaLoginEmpresa = () => mostrarTelaLoginEmpresa(getApp());
window.mostrarTelaPrincipal = () => mostrarTelaPrincipal(getApp());
window.mostrarPerfilCandidato = () => mostrarPerfilCandidato(getApp());
window.mostrarPerfilEmpresa = () => mostrarPerfilEmpresa(getApp());