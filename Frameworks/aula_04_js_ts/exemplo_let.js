let x = 10; // x nesse bloco

if (x == 10) {
    let x = 20;  // x como é variável existente apenas neste bloco {}
    console.log(x);
}
console.log(x);

// exemplo const: valores que não podem ser reatribuídos
const y = 30;
//y = 40; //Assignment to constant variable.
console.log(y);
