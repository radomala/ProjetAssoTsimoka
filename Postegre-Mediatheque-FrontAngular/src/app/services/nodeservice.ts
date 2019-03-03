import { Injectable } from "@angular/core";
import { HttpParams } from "@angular/common/http";
import { Rubrique } from "../beans/Rubrique";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";



@Injectable()
export class NodeService {

  listRubriques = [];
  
  constructor(private http: HttpClient) {

  }


getArborescenceRubrique(idfrom: string, childrenLevel: number) {
    let promise = this.getRubriqueConfigArborescence(idfrom, childrenLevel);
    return promise;
  }

  getRubriqueConfigArborescence(idForm: string, childrenLevel: number): Observable<Rubrique[]> {

    let params = new HttpParams();
    params = params.append("idForm", idForm);

    if (childrenLevel != null && childrenLevel != undefined) {
      params = params.append("childrenLevel", "" + childrenLevel);
    }

    return this.http.get<Rubrique[]>('./getRubriqueControllerConfFormulaire.aspx', params, { triggerMsg: true, triggerLoader: false });
  }
}