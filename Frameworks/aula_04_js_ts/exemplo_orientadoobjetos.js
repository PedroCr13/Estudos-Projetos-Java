class Pessoa {
    constructor(nome, idade) {
        this.nome = nome;
        this.idade = idade;
    }

    cumprimentar() {
        console.log(`Olá, meu nome é ${this.nome} e eu tenho ${this.idade} anos`);
    }
}

const pessoa = new Pessoa('Pedro', 25);
pessoa.cumprimentar();