var d = new Date();
console.log(d);

var feriado = new Date("03/04/2026");
console.log(feriado);

let natal = new Date(2026, 11, 25); // 0 1 2 3
console.log(natal);

let agora = new Date();
console.log(agora.getFullYear());
console.log(agora.getMonth());
console.log(agora.getDate());
console.log(agora.getDay());
console.log(agora.getMinutes());
console.log(agora.getSeconds());
console.log(agora.getMilliseconds());

let data = new Date();
data.setFullYear(2025);
data.setMonth(0); // janeiro 0
data.setDate(16); // dia
data.setMinutes(30);
data.setSeconds(45);

console.log(data);

// converter data para string:
let dataDeAgora = new Date();
console.log(agora.toDateString());