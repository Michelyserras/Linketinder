import { mostrarTelaCadastroCandidato, mostrarTelaCadastroEmpresa, mostrarTelaPrincipal } from "./MostrarTela";

const app = document.querySelector<HTMLDivElement>('#app')!


export function navBar() {
    const nav = document.createElement("nav");
    nav.className = "nav-container";


    nav.innerHTML = ` 
    <div id="logo">
    <span class="material-symbols-outlined">
        business_center
    </span>
    <a href="">Linke<span id="highlight">tinder</span></a>
    </div>
    <div id="nav-links">
        <a href="#" id="empresas-link">ver vagas</a>
        <a href="#" id="candidato-link">ver candidatos</a>
    </div>
  
    `

    const link = nav.querySelector('#logo a');
    link?.addEventListener('click', (e) => {
    e.preventDefault();
        mostrarTelaPrincipal(app);
    });

    return nav;

}

export function mainContent() {
    const div = document.createElement('div');
    div.id = "pagina-inicial";


    div.innerHTML = `
        <div id="descricao">
            <h1>Conectando talentos com oportunidades</h1>
            <p>Encontre a vaga dos seus sonhos ou o candidato ideal para sua equipe</p>
        </div>
        <div id="cards-container">
            <div class="card">
                <span class="material-symbols-outlined" id="icon">
                    apartment
                </span>
                <h2>Sou uma empresa!</h2>
                <span id="text">Cadastre sua empresa e encontre talentos </span>
                <div id="btn">
                    <button id="btn-cadastro" class="btn-empresa">Cadastrar Empresa</button>
                    <button id="btn-login">Fazer Login</button>
                </div>
                
            </div>

            <div class="card">
                <span class="material-symbols-outlined" id="icon">
                assignment_ind
                </span>
                <h2>Sou um candidato!</h2>
                <span id="text">Cadastre-se e conecte-se com empresas incríveis</span>
                <div id="btn">
                    <button id="btn-cadastro" class="btn-candidato">Cadastrar Candidato</button>
                    <button id="btn-login">Fazer Login</button>
                </div>
            </div>
        </div>
    `

    const btnCadastroEmpresa = div.querySelector('.btn-empresa');
    btnCadastroEmpresa?.addEventListener('click', () => {  
        mostrarTelaCadastroEmpresa(app);
    });

    const btnCadastroCandidato = div.querySelector('.btn-candidato');
    btnCadastroCandidato?.addEventListener('click', () => {
        mostrarTelaCadastroCandidato(app);
    });


    return div;
}


