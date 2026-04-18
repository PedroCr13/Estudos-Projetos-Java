import { Component } from '@angular/core';

@Component({
  selector: 'app-departamentos-pesquisa',
  standalone: false,
  templateUrl: './departamentos-pesquisa.html',
  styleUrl: './departamentos-pesquisa.css',
})
export class DepartamentosPesquisa {

    departamentos = [
      { id: 1, nomeDepartamento: 'RH' },
      { id: 2, nomeDepartamento: 'TI' },
      { id: 3, nomeDepartamento: 'Contabilidade' },
      { id: 4, nomeDepartamento: 'Administrativo' },
      { id: 5, nomeDepartamento: 'Manutenção' },
      { id: 6, nomeDepartamento: 'Estoque' },
      { id: 7, nomeDepartamento: 'Cobrança' },
      { id: 8, nomeDepartamento: 'Jurídico' },
      { id: 9, nomeDepartamento: 'Diretoria' },
      { id: 10, nomeDepartamento: 'Almoxarifado' },
      { id: 11, nomeDepartamento: 'Segurança' }
    ];

}
