import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { Ola } from './ola/ola';
import { BemVindo } from './bem-vindo/bem-vindo';
import { FormsModule } from '@angular/forms';
import { FuncionarioCard } from './funcionario-card/funcionario-card';
import { FuncionarioForm } from './funcionario-form/funcionario-form';

@NgModule({
  declarations: [App, Ola, BemVindo, FuncionarioCard, FuncionarioForm],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [provideBrowserGlobalErrorListeners()],
  bootstrap: [App],
})
export class AppModule {}
