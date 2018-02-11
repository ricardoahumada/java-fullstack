import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppComponent }  from './app.component';
import { ListaProductosComponent } from './productos/lista-productos.component';
import { FiltroProductosPipe } from './productos/lista-productos.pipe';

@NgModule({
  imports:      [ BrowserModule, FormsModule ],
  declarations: [ AppComponent, ListaProductosComponent, FiltroProductosPipe ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
