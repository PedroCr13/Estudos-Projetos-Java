let texto = "Olá, mundo!";
console.log(texto.length);

console.log(texto.indexOf("mundo")); // posição primeira ocorrência da string
console.log(texto.lastIndexOf("o")); // ultima ocorrencia da string, não achou retorna -1

console.log(texto.slice(0, 5));
console.log(texto.slice(-6)); // considerando de trás para frente
console.log(texto.substring(0, 5));

let novoTexto = texto.replace("mundo", "JavaScript");
console.log(novoTexto);

let palavaras = texto.split(" ");
console.log(palavaras);

console.log(texto.charAt(2));
console.log(texto[2]);