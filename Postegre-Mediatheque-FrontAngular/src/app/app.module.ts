import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ButtonModule } from 'primeng/button';
import { AccordionModule } from 'primeng/accordion';
import { TabViewModule } from 'primeng/tabview';
import { PanelModule } from 'primeng/panel';
import { FieldsetModule } from 'primeng/fieldset';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { TreeTableModule } from 'primeng/treetable';

//treenode n a pas de module a declarer, il faut juste faire un import 
import {TreeNode} from 'primeng/api';

//httpclient
import { HttpClientModule, HttpClient } from '@angular/common/http';



//MES COMPOSANTS
import { PageAcceuilComponent } from './page-acceuil/page-acceuil.component';
import { AdministrationGeneraleComponent } from './administration-generale/administration-generale.component';
import { AdministrationPageAcceuilComponent } from './administration-page-acceuil/administration-page-acceuil.component';
import { AdministrationRubriqueComponent } from './administration-rubrique/administration-rubrique.component';


@NgModule({
  declarations: [
    //MES COMPOSANTS
    AppComponent,
    PageAcceuilComponent,
    AdministrationGeneraleComponent,
    AdministrationPageAcceuilComponent,
    AdministrationRubriqueComponent
  ],
  imports: [
    //module  qui gere les routes
    AppRoutingModule,

    //COMPOSANT UTIL UTILISE PAR MES COMPOSANT
    BrowserModule,
    ButtonModule,
    AccordionModule,
    TabViewModule,
    PanelModule,
    FieldsetModule,
    TreeTableModule,
    
    //HTTP
    HttpClientModule, 
    HttpClient
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
