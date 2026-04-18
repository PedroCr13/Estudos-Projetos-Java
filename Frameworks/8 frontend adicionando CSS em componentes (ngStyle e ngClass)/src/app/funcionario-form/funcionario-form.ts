import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-funcionario-form',
  standalone: false,
  templateUrl: './funcionario-form.html',
  styleUrl: './funcionario-form.css',
})
export class FuncionarioForm {
  ultimoId = 0;
  nome = '';
  adicionado = false;
  @Output() funcionarioAdicionado = new EventEmitter();

  adicionar() {
    this.adicionado = true;

     const funcionario = {
      id: ++this.ultimoId,
      nome: this.nome
    };

    // enviando o objeto (leva para o componente)
    this.funcionarioAdicionado.emit(funcionario)
  }

}

