/*
 Através da desestruturação é possível entregar o valor para uma função sem especificar parâmetro por parâmetro, pois o Javascript entende automaticamente qual campo é qual.
 Permitindo extrair dados de arrays ou objetos em variáveis distintas também.
*/

const fruits = ['banana', 'morango', 'manga'];
const [firstFruit, secondFruit] = fruits;

console.log(fruits);
console.log(firstFruit);
console.log(secondFruit);

// desestruturação de um objeto:
const pessoa = {
    nome: 'Sergio',
    idade: 60,
    contato: { 
        email: 'sergio@teste.com'
    }
}

const { nome, contato: {email} } = pessoa;

console.log(pessoa);
console.log(nome);
console.log(email);

// desestrurando de um array:
const pessoa1 = {
    nomeCompleto: 'Manoel',
    idade: 60
}

const pessoa2 = {
    nomeCompleto: 'Pedro',
    idade: 26
}

const pessoa3 = {
    nomeCompleto: 'João',
    idade: 30
}

const amigos = [ pessoa1, pessoa2, pessoa3 ];

const [ , {nomeCompleto}] = amigos;

console.log(pessoa1);
console.log(pessoa2);
console.log(pessoa3);
console.log(nomeCompleto);

// retorno Objeto:
function criarUsuario(nomeCliente, idade, email) {
    return {
        nomeCliente, 
        idade, 
        contato: { email }
    }
}

const { nomeCliente } = criarUsuario('Fabio', 45, 'fabio@teste.com');

console.log(nomeCliente);

