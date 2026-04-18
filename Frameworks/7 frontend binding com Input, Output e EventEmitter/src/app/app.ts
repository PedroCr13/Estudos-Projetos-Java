import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
  funcionarios: Funcionario[] = []; // Typagem com Interface, evitar any

  aoAdicionar(funcionarioDoTemplate: Funcionario) {
    this.funcionarios.push(funcionarioDoTemplate);
  }
}

interface Funcionario
{
  id: number;
  nome: string
}
