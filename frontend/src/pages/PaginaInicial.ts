import { CadastroCandidato, CardCandidato } from "./CandidatoPerfil";
import { CadastroEmpresa } from "./EmpresaPerfil";

export function mostrarTela(){
    const app = document.getElementById('app');
    app!.innerHTML = "";

    const div = document.createElement('div');
    app!.appendChild(div);
    div.appendChild(CadastroCandidato());
    div.appendChild(CadastroEmpresa());
    div.appendChild(CardCandidato());

    return div;
}


