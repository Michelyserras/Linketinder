import { CadastroCandidato } from "./CandidatoPerfil";

export function mostrarTelaAv(){
    const app = document.getElementById('app');
    app!.innerHTML = "";

    const div = document.createElement('div');
    app!.appendChild(div);
    div.appendChild(CadastroCandidato());

    return div;
}