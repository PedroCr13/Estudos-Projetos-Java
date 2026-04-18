/*
Expande elementos de um array ou objeto. Ele basicamente é usado para pegar todas as propriedades de um objeto 
e depois sobrescrever uma propriedade específica por outra nova que podemos passar.
*/

const partes = ['ombro', 'joelho', 'orelha'];

const corpo = ['cabeca', partes[0], partes[2], 'pés'];
console.log(corpo);

const corpoComSpread = ['cabeca', ...partes, 'pés'];
console.log(corpoComSpread);

// Sem spread operator:
function createUser(name, age, contact1, contact2, contact3)
{
    return {
        name, 
        age, 
        contacts: [contact1, contact2, contact3]
    }
}

// Com spread operator: não precisou criar diversas variáveis no parâmetro da função
function createUserComSpread(name, age, ...contacts) {
    return {
        name, 
        age, 
        contacts
    }
}

const usuarioA = createUser('Fabio', 45, {email: 'fabio@teste.com'}, {fone: '1234-1234'}, {whats: '4321-4321'});

const usuarioB = createUserComSpread('Fabio', 45, {email: 'fabio@teste.com'}, {fone: '1234-1234'}, {whats: '4321-4321'});

console.log(usuarioA);
console.log(usuarioB);

// SpreadOperator para clonar um objeto:
const usuario = {
    nome: 'Pedro',
    email: 'pedro@teste.com.br'
};

// novo objeto apontando para outro endereço de memória
const novoUsuario = {...usuario, regra: 'admin'}

console.log(usuario);
console.log(novoUsuario);

// exemplo Rest Operator: (representa o resto dos elementos)
// deve ser o ultimo item a ser aplicado na relação de variáveis
const frutas = ['banana', 'morango', 'kiwi', 'maracujá'];
const [primeiroItem, segundoItem, ...outrosItens] = frutas;
console.log(primeiroItem);
console.log(segundoItem);
console.log(outrosItens);
