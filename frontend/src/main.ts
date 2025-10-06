import { CadastroCandidato } from "./pages/CandidatoPerfil"

const app = document.querySelector<HTMLDivElement>('#app')!
app.innerHTML = CadastroCandidato().innerHTML;