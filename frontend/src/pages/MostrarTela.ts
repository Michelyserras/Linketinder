import { cadastroCandidato, candidatoPerfil, loginCandidato } from "./CandidatoPerfil";
import { cadastroEmpresa, empresaPerfil, empresaLogin } from "./EmpresaPerfil";
import { navBar, mainContent } from "./PaginaInicial";


export function criarDivPrincipal(app: HTMLDivElement) {
    app.innerHTML = "";
    const div = document.createElement('div');
    app.appendChild(div);
    div.appendChild(navBar());
    return div;
}

export function mostrarTelaPrincipal(app: HTMLDivElement) {
    const div = criarDivPrincipal(app);
    div.appendChild(mainContent());
    return div;
}


export function mostrarTelaCadastroCandidato(app: HTMLDivElement) {
    const div = criarDivPrincipal(app);
    div.appendChild(cadastroCandidato());
    return div;
}

export function mostrarPerfilCandidato(app: HTMLDivElement) {
    const div = criarDivPrincipal(app);
    div.appendChild(candidatoPerfil());

    return div;
}

export function mostrarTelaLoginCandidato(app: HTMLDivElement) {
    const div = criarDivPrincipal(app);
    div.appendChild(loginCandidato());

    return div;
}

export function mostrarTelaLoginEmpresa(app: HTMLDivElement) {
    const div = criarDivPrincipal(app);
    div.appendChild(empresaLogin());

    return div;
}

export function mostrarTelaCadastroEmpresa(app: HTMLDivElement) {
    const div = criarDivPrincipal(app);
    div.appendChild(cadastroEmpresa());

    return div;
}

export function mostrarPerfilEmpresa(app: HTMLDivElement) {
    const div = criarDivPrincipal(app);
    div.appendChild(empresaPerfil());
    return div;
}



