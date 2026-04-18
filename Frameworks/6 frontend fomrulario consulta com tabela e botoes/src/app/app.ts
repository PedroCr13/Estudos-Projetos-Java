import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})

export class App {

    funcionarios = [
      { id: 1, nomeFuncionario: 'João da Silva', departamento: 'RH' },
      { id: 2, nomeFuncionario: 'Maria Oliveira', departamento: 'TI' },
      { id: 3, nomeFuncionario: 'Antonio Moraes', departamento: 'TI' },
      { id: 4, nomeFuncionario: 'Pamela Silva', departamento: 'Administrativo' },
      { id: 5, nomeFuncionario: 'Renan Silveira', departamento: 'Administrativo' },
      { id: 6, nomeFuncionario: 'Ana Caroline', departamento: 'Estoque' },
      { id: 7, nomeFuncionario: 'Antonio Marcolino', departamento: 'TI' },
      { id: 8, nomeFuncionario: 'Anderson Oliveira', departamento: 'Comercial' },
      { id: 9, nomeFuncionario: 'Lucia da Silva', departamento: 'Comercial' },
      { id: 10, nomeFuncionario: 'Antonio Moraes', departamento: 'TI' },
      { id: 11, nomeFuncionario: 'Antonio Moraes', departamento: 'Estoque' },
    ];

}
