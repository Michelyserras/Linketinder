
export function CadastroCandidato() {
    const cadastro = document.createElement('div');
    cadastro.innerHTML = `
    <h1>Cadastro Candidato</h1>
    <dialog>
      <form method="dialog">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required />
        <label for="email">Email:</label>   
        <input type="email" id="email" name="email" required />
        <label for="cep">CEP:</label>
        <input type="text" id="cep" name="cep" required />
        <label for="estado">Estado:</label>
        <input type="text" id="estado" name="estado" required />
        <label for="descricao">Descrição:</label>
        <input type="text" id="descricao" name="descricao" required />
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" required />
        <label for="habilidades">Habilidades:</label>
        <input type="text" id="habilidades" name="habilidades" required />
        </form>
    </dialog>`
    return cadastro;
}

export function CandidatoPerfil() {
    const perfil = document.createElement('div');
    perfil.innerHTML = `
        <h1>Perfil do Candidato</h1>
        <p><strong>Nome:</strong> <span id="perfil-nome"></span></p>
        <p><strong>Email:</strong> <span id="perfil-email"></span></p>
        <p><strong>CEP:</strong> <span id="perfil-cep"></span></p>
        <p><strong>Estado:</strong> <span id="perfil-estado"></span></p>
        <p><strong>Descrição:</strong> <span id="perfil-descricao"></span></p>
        <p><strong>CPF:</strong> <span id="perfil-cpf"></span></p>
        <p><strong>Habilidades:</strong> <span id="perfil-habilidades"></span></p>
        <button id="editar-perfil-btn">Editar Perfil</button>
   `;
    return perfil;
}


export function editarPerfilCandidato() {
    const editar = document.createElement('div');
    editar.innerHTML = `
    <h1>Editar Perfil do Candidato</h1>
    <dialog>
        <form method="dialog">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" required />
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required />
            <label for="cep">CEP:</label>
            <input type="text" id="cep" name="cep" required />
            <label for="estado">Estado:</label>
            <input type="text" id="estado" name="estado" required />
            <label for="descricao">Descrição:</label>
            <input type="text" id="descricao" name="descricao" required />
            <label for="cpf">CPF:</label>
            <input type="text" id="cpf" name="cpf" required />
            <label for="habilidades">Habilidades:</label>
            <input type="text" id="habilidades" name="habilidades" required />
        </form>
            <button id="salvar-cadastro-btn">Salvar</button>
            <button id="cancelar-cadastro-btn">Cancelar</button>
    </dialog>`
    return editar;
}


export function CandidatoVagas() {
    const vagas = document.createElement('div');
    vagas.innerHTML = `
        <h1>Vagas do Candidato</h1>
        <ul id="lista-vagas">
            <li><strong>Vaga 1:</strong> Descrição da vaga 1</li>
            <li><strong>Vaga 2:</strong> Descrição da vaga 2</li>
            <li><strong>Vaga 3:</strong> Descrição da vaga 3</li>
        </ul>
    `;
    return vagas;
}