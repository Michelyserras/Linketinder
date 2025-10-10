

export function validarNome(nome: string): boolean {
    if (!nome){
        return false;
    } 
    const regex = /^[a-zA-ZÀ-ÿ\s]+$/;
    return regex.test(nome.trim());
}

export function validarEmail(email: string): boolean {
    if (!email){
        return false;
    } 
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email.trim());
}

export function validarCPF(cpf: string): boolean {
    if (!cpf){
        return false;
    } 
    const regex = /^\d{3}\.?\d{3}\.?\d{3}\-?\d{2}$/;
    return regex.test(cpf.replace(/\s/g, ''));
}

export function validarCNPJ(cnpj: string): boolean {
    if (!cnpj) {
        return false;
    }
    const regex = /^\d{2}\.?\d{3}\.?\d{3}\/?\d{4}\-?\d{2}$/;
    return regex.test(cnpj.replace(/\s/g, ''));
}

export function validarCEP(cep: string): boolean {
    if (!cep){
        return false;
    } 
    const regex = /^\d{5}\-?\d{3}$/;
    return regex.test(cep.trim());
}

export function validarTelefone(telefone: string): boolean {
    if (!telefone){
        return false;
    } 
    const regex = /^(\+55\s?)?(\(?\d{2}\)?\s?)?(?:9?\d{4}[- ]?\d{4})$/;
    return regex.test(telefone.trim());
}

export function validarTag(tag: string): boolean {
    if (!tag){
        return false;
    } 
    const regex = /^[A-Za-z0-9\-\#\+ ]{1,50}$/;
    return regex.test(tag.trim());
}

export function validarListaHabilidades(competenciaSeparadaPorVirgula: string): boolean {
    if (!competenciaSeparadaPorVirgula) {
        return false;
    }
    const partes = competenciaSeparadaPorVirgula.split(',').map(p => p.trim()).filter(p => p.length > 0);
    if (partes.length === 0) {
        return false;
    }
    return partes.every(p => validarTag(p));
}
