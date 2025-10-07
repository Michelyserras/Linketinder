// import { CadastroCandidato, CardCandidato } from "./CandidatoPerfil";
// import { CadastroEmpresa } from "./EmpresaPerfil";

export function mostrarTela() {
    const app = document.getElementById('app');
    app!.innerHTML = "";
    const div = document.createElement('div');
    app!.appendChild(div);
    div.appendChild(navBar());
    div.appendChild(mainContent());
    // div.appendChild(CadastroCandidato());
    // div.appendChild(CadastroEmpresa());
    // div.appendChild(CardCandidato());

    return div;
}

export function navBar() {
    const nav = document.createElement("nav");

    nav.innerHTML = ` 
    <div id="logo">
    <span class="material-symbols-outlined">
        business_center
    </span>
    <a href="#">Linketinder</a>
    </div>
    <a href="#" id="empresas-link">Empresas</a>
    <a href="#" id="candidato-link">Candidatos</a>
    `
    return nav;

}

export function mainContent() {
    const div = document.createElement('div');
    div.id = "pagina-inicial";


    div.innerHTML = `
        <h1>Conectando Talentos com oportunidades</h1>
        <p>Encontre a vaga dos seus sonhos ou o candidato ideal</p>

        <div id="cards-container">
            <div class="empresa-card">
                <span class="material-symbols-outlined">
                    apartment
                </span>
                <h2>Sou uma empresa!</h2>
                <span>Cadastre sua empresa e encontre talentos para a sua equipe</span>
                <button id="empresa-btn">Cadastrar Empresa</button>
                <button id="vaga-btn">Publicar Vaga</button>
                <button id="ver-vagas-btn">Ver Empresas</button>
            </div>

            <div class="candidato-card">
                <span class="material-symbols-outlined">
                assignment_ind
                </span>
                <h2>Sou um candidato!</h2>
                <span>Cadastre-se e conecte-se com empresas incríveis</span>
                <button id="candidato-btn">Cadastrar Candidato</button>
                <button id="ver-candidatos-btn">Ver Candidatos</button>
            </div>
        </div>
    `
    return div;
}


