import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-funcionario-card',
  standalone: false,
  templateUrl: './funcionario-card.html',
  styleUrl: './funcionario-card.css',
})
export class FuncionarioCard {

  // propriedade seja visivel a outros componentes
  @Input() funcionario : any;

  isAdmin() {
    return this.funcionario.nome.startsWith('A');
  }

  getListaClasses() {
    return ['badge', 'badge-primary'];
  }

  getEstilosCard() {
    return { 
      'border-width': this.funcionario.id + 'px',
      backgroundColor: this.funcionario.id % 2 === 0 ? 'ligthblue' : 'ligthgreen'
    };
  }
}

