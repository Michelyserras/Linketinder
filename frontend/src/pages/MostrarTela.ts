import { cadastroCandidato, candidatoPerfil } from "./CandidatoPerfil";
import { cadastroEmpresa, empresaPerfil,  } from "./EmpresaPerfil";
import { navBar, mainContent } from "./PaginaInicial";

export function mostrarTelaPrincipal(app: HTMLDivElement) {
    app.innerHTML = "";
    const div = document.createElement('div');
    app.appendChild(div);
    div.appendChild(navBar());
    div.appendChild(mainContent());

    return div;
}


export function mostrarTelaCadastroCandidato(app: HTMLDivElement){
    app.innerHTML = "";

    const div = document.createElement('div');
    app.appendChild(div);
    div.appendChild(navBar());
    div.appendChild(cadastroCandidato());

    return div;
}

export function mostrarPerfilCandidato(app: HTMLDivElement) {
    app.innerHTML = "";
    const div = document.createElement('div');
    app.appendChild(div);
    div.appendChild(navBar());
    div.appendChild(candidatoPerfil());
    return div;
}


export function mostrarTelaCadastroEmpresa(app: HTMLDivElement) {
    app.innerHTML = "";

    const div = document.createElement('div');
    app.appendChild(div);
    div.appendChild(navBar());
    div.appendChild(cadastroEmpresa());

    return div;
}

export function mostrarPerfilEmpresa(app: HTMLDivElement) {
    app.innerHTML = "";
    const div = document.createElement('div');
    app.appendChild(div);
    div.appendChild(navBar());
    div.appendChild(empresaPerfil());
    return div;
}

