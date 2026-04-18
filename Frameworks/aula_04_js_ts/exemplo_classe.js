class Pessoa {

    // Em JS não há private, protected: todos os atributos são publicos

    constructor(nome) {
        this.nome = nome;
    }

    saudacao() {
        console.log(`Olá!, meu nome é ${this.nome}`);
    }
}

const hugo = new Pessoa("Hugo");
hugo.saudacao();