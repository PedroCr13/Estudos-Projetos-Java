import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { providePrimeNG } from 'primeng/config';
import Aura from '@primeng/themes/aura';
import { InputTextModule } from 'primeng/inputtext';
import { TabsModule } from 'primeng/tabs';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { TooltipModule } from 'primeng/tooltip';
import { Navbar } from './navbar/navbar';
import { Select, SelectModule } from 'primeng/select';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { DepartamentosPesquisa } from './departamentos-pesquisa/departamentos-pesquisa';
import { DepartamentoCadastro } from './departamento-cadastro/departamento-cadastro';
import { InputColor } from './input-color';

@NgModule({
  declarations: [App, DepartamentosPesquisa, Navbar, DepartamentoCadastro, InputColor],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    TabsModule,
    ButtonModule,
    InputTextModule,
    TableModule,
    TooltipModule,
    SelectModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
    providePrimeNG({
      theme: {
        preset: Aura,
        options: {
          darkModeSelector: '.none',
        },
      },
    }),
  ],
  bootstrap: [App],
})
export class AppModule {}
