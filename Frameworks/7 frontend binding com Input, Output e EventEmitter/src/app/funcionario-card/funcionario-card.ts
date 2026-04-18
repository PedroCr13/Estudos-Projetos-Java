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

}

