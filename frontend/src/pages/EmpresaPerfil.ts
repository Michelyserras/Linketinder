
export function EmpresaPerfil() {
    const perfil = document.createElement('div');
    perfil.innerHTML = `
        <h1>Perfil da Empresa</h1>
        <p><strong>Nome:</strong> <span id="perfil-nome"></span></p>
        <p><strong>Email:</strong> <span id="perfil-email"></span></p>  
        <p><strong>CEP:</strong> <span id="perfil-cep"></span></p>
        <p><strong>País:</strong> <span id="perfil-pais"></span></p>
        <p><strong>Estado:</strong> <span id="perfil-estado"></span></p>
        <p><strong>Descrição:</strong> <span id="perfil-descricao"></span></p>
        <p><strong>CNPJ:</strong> <span id="perfil-cnpj"></span></p>        
        <button id="editar-perfil-btn">Editar Perfil</button>`

    return perfil;
}
export function CadastroEmpresa() {
    const cadastro = document.createElement('div');
    cadastro.innerHTML = `
    <dialog>
        <form method="dialog">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" required />
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required />
            <label for="cep">CEP:</label>
            <input type="text" id="cep" name="cep" required />
            <label for="pais">País:</label>
            <input type="text" id="pais" name="pais" required />
            <label for="estado">Estado:</label>
            <input type="text" id="estado" name="estado" required />
            <label for="descricao">Descrição:</label>
            <input type="text" id="descricao" name="descricao" required />
            <label for="cnpj">CNPJ:</label>
            <input type="text" id="cnpj" name="cnpj" required />
        </form>
        <button id="salvar-cadastro-btn">Salvar</button>
        <button id="cancelar-cadastro-btn">Cancelar</button>
    </dialog>`
    return cadastro;
}


export function editarPerfilEmpresa() {
    const editar = document.createElement('div');
    editar.innerHTML = `
    <h1>Editar Perfil da Empresa</h1>
    <dialog>
        <form method="dialog">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" required />
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required />
            <label for="cep">CEP:</label>
            <input type="text" id="cep" name="cep" required />
            <label for="pais">País:</label>
            <input type="text" id="pais" name="pais" required />
            <label for="estado">Estado:</label>
            <input type="text" id="estado" name="estado" required />
            <label for="descricao">Descrição:</label>
            <input type="text" id="descricao" name="descricao" required />
            <label for="cnpj">CNPJ:</label>
            <input type="text" id="cnpj" name="cnpj" required />
        </form>
    <button id="salvar-cadastro-btn">Salvar</button>
    <button id="cancelar-cadastro-btn">Cancelar</button>
    </dialog>`
    return editar;
}
