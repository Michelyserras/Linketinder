
import { navBar } from "./pages/NavBar";
import { mostrarTela } from "./pages/PaginaInicial";

const app = document.querySelector<HTMLDivElement>('#app')!
app.appendChild(navBar());
app.appendChild(mostrarTela())

