import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

class Departamento {
  nome: string = '';
}

@Component({
  selector: 'app-departamento-cadastro',
  standalone: false,
  templateUrl: './departamento-cadastro.html',
  styleUrl: './departamento-cadastro.css',
})
export class DepartamentoCadastro {

  departamento = new Departamento();

  salvar(departamentoForm: NgForm) {
    console.log(departamentoForm.value.nomeDepartamento);

    departamentoForm.reset({ departamentoNome: ''});
  }
}
