import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { AdministrationGeneraleComponent } from 'src/app/administration-generale/administration-generale.component';
import { PageAcceuilComponent } from 'src/app/page-acceuil/page-acceuil.component';
import { AdministrationRubriqueComponent } from 'src/app/administration-rubrique/administration-rubrique.component';
import { AdministrationPageAcceuilComponent } from 'src/app/administration-page-acceuil/administration-page-acceuil.component';



const gestionRoute: Routes = [
{
    path: 'administrationGenerale', component: AdministrationGeneraleComponent,
    children: [                         
      {
        path: 'administrationpageaccueil',
        component: AdministrationPageAcceuilComponent,
      },
      {
        path: 'administrationRubrique',
        component: AdministrationRubriqueComponent
      }
    ]

  },
  { path: 'administrationpageaccueil', component: PageAcceuilComponent},
  { path: 'administrationRubrique', component: AdministrationRubriqueComponent},
  { path: 'pageAcceuil', component: PageAcceuilComponent},
  { path: '', component: PageAcceuilComponent},
  { path: '**' , redirectTo: '/' }
];

@NgModule({
  imports: [RouterModule.forRoot(gestionRoute, { useHash: true, enableTracing: false })],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule { }
