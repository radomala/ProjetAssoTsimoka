export class Rubrique {

    rub_id: number;
    rub_label: string;
    rub_idparent: number;
    rub_usercreate: string;
    rub_dossierOrformulaire : boolean;
    rub_description: string;
    rub_finishconfiguration : string;
    children: Rubrique[];
    
    expandedIcon: string;
    collapsedIcon: string;
    leaf: boolean;
    expanded: boolean;
    nbLines : string;
   

    constructor(values: Object = {}) {
        Object.assign(this, values);
      }
    }