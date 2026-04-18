// sintaxe colchetes
let frutas = ['maça', 'banana', 'laranja'];

// ou Construtor Array
let numeros = new Array(1, 2, 3, 4, 5);

console.log(frutas[0]);
console.log(frutas[1]);

console.log(frutas.toString());

// join: separator
console.log(frutas.join(' - '));

// push: adiciona elemento ao final do array
frutas.push('pessego');
console.log(frutas);

// unshift(element): adiciona um ou mais elementos ao inicio do array
frutas.unshift('Abacaxi');
console.log(frutas);

// pop: remove o ultimo elemento e o retorna
let ultimaFruta = frutas.pop();
console.log(ultimaFruta);
console.log(frutas);

// shift: remove o primeiro elemento e o retorna
let primeiraFruta = frutas.shift();
console.log(primeiraFruta);
console.log(frutas);

// slice(start, end): Retorna uma cópia de uma porção do array, sem alterar o original
let listaDeFrautas = ['maça', 'banana', 'laranja', 'uva'];
let citrus = frutas.slice(1.3);
console.log(listaDeFrautas);
console.log(citrus);

// Cria um novo array a partir de um objeto semelhante a um array ou de um objeto iterável
let str = 'Hello';
let arr = Array.from(str);
console.log(arr); // [ 'H', 'e', 'l', 'l', 'o' ]

// Cria um novo array com um número variável de elementos
const array = Array.of(16); // cria um array com 6 posições vazias

// forEach
frutas.forEach(function(item, index) {
    console.log(index, item);
});

// map
// Cria um novo array com os resultados da chamada de uma função para cada elemento do array.
const capitalizedFruits = frutas.map(fruta => {
    return fruta.toUpperCase();
});

console.log(frutas);
console.log(capitalizedFruits);

// find: Retorna o PRIMEIRO valor encontrado no array que satisfaz a função de teste fornecida
let numerosLista = [1, 2, 3, 4];
let encontrado = numerosLista.find(function(num) {
    return num > 2;
});

console.log(encontrado);

// some: se algum elemento atende condição (retorna booleano)
// every: se todos os elementos atendem condição
let algumMaiorQueTres = numerosLista.some(function(num) {
    return num > 3;
});

console.log(algumMaiorQueTres);