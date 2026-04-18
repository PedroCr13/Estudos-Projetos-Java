// Exemplo de closure sendo usada para manipular variveis privadas:
// saldo é uma variavel privada que só pode ser acessada por depositar(), sacar() e verSaldo()
function criarBanco() {
    let saldo = 0;

    return {
        depositar: function(valor) {
            saldo += valor;
            console.log(`Depositado: R$ ${valor}. Saldo atual: R$${saldo}`);
        },
        sacar: function(valor) {
            if (valor <= saldo) {
                saldo -= valor;
                console.log(`Sacado: R$${valor}. Saldo atual: R$${saldo}`);    
            } else {
                console.log('Saldo insuficiente.');
            }
        },
        verSaldo: function() {
            console.log(`Saldo atual: R$${saldo}`);
        }
    };
}

const minhaConta = criarBanco();
minhaConta.depositar(100);
minhaConta.sacar(50);
minhaConta.verSaldo();