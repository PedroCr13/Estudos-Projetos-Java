function incrementar() {
    var valor = 0;

    return function() {
        return ++valor;
    }
}

var fn = incrementar();
console.log(fn());
console.log(fn());
console.log(fn());

// exemplo de closure: funcao relembra valores mesmo depois chamada
function saudacao(nome) {

    const mensagem = 'Olá!';

    function saudar() {
        console.log(`${mensagem}, ${nome}`);
    }

    return saudar;
}

const saudacaoAlunos = saudacao('Alunos da UTFPR');
saudacaoAlunos();

// Usando closure para gerar outras funções
function criarSaudacao(saudacao) {
    return function(nome) {
        console.log(`${saudacao}, ${nome}`);
    };
}

const saudacaoOi = criarSaudacao('Oi');
saudacaoOi('Maria');

const saudacaoBomDia = criarSaudacao('Bom dia');
saudacaoBomDia('Pedro');

