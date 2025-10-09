
import { mostrarTelaPrincipal } from "./pages/MostrarTela";
import "./handlers/FormHandlers";
import { DataService } from "./services/DataService";

import "./styles/cadastroCandidato.css";


DataService.carregarDados();

const app = document.querySelector<HTMLDivElement>('#app')!
mostrarTelaPrincipal(app);

