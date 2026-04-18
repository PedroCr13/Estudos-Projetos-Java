import { Directive, ElementRef, HostBinding, HostListener, Input, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appInputColor]',
  standalone: false,
  exportAs: 'inputColorido'
})

export class InputColor {

  @Input() corUsuario = 'gray';

  @HostBinding('style.backgroundColor') cor: string = '';

  @HostListener('focus') comFoco() {
    this.cor = this.corUsuario;
  }

  @HostListener('blur') semFoco() {
    this.cor = 'transparent'
  }
}

/*
  constructor(
    private elementRef: ElementRef,
    private renderer: Renderer2,
  ) {

  }

  @HostListener('focus') comFoco() {
    this.renderer.setStyle(this.elementRef.nativeElement,
      'background-color', 'yellow');
  }

  @HostListener('blur') semFoco() {
    this.renderer.setStyle(this.elementRef.nativeElement,
      'background-color', 'transparent');
  }
  */
