
import { navBar } from "./pages/PaginaInicial";
import { mostrarTela } from "./pages/PaginaInicial";

const app = document.querySelector<HTMLDivElement>('#app')!
app.appendChild(navBar());
app.appendChild(mostrarTela())

