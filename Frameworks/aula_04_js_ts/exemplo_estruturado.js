function calcularFatorial(n) {
    if (n <= 1) return 1;

    return n * calcularFatorial(n - 1);
}

console.log(calcularFatorial(5));