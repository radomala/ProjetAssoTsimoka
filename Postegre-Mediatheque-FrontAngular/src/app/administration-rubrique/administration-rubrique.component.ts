import { Component, OnInit } from '@angular/core';
import { TreeTableModule } from 'primeng/treetable';
import { TreeNode } from 'primeng/api';

@Component({
  selector: 'app-administration-rubrique',
  templateUrl: './administration-rubrique.component.html',
  styleUrls: ['./administration-rubrique.component.css']
})
export class AdministrationRubriqueComponent implements OnInit {

  lazyFiles: TreeNode[];
  // msgsimp: Message[] = [];
  loading: boolean = true;


  constructor() { }

  ngOnInit() {
  }


  loadRubrique() {

    this.nodeservice.getArborescenceRubrique('', -1).subscribe(data => {
      this.lazyFiles = [{
        //        id: '',
        label: 'Racine',
        expanded: true,
        draggable: false,
        droppable: true,
        selectable: false,
        leaf: data['children'].length > 0,
        expandedIcon: 'fa-folder-open',
        collapsedIcon: 'fa-folder',
        children: data['children']
      }];

      this.loading = false;

      this.expandAll();

    });
  }

  expandAll() {
    this.lazyFiles[0].children.forEach(node => {
      this.expandRecursive(node, true);
    });
  }


  expandRecursive(node: TreeNode, isExpand: boolean) {
    //node.expanded = !node['isFormulaire'] && isExpand;
    node.expanded = isExpand;
    // node.leaf = !node['isFormulaire'] && node.children.length > 0 ? true : false;
    node.leaf = true;
    node.draggable = true;
    //node.droppable = !node['isFormulaire'];
    node.droppable = true;
    node.selectable = true;
    node.expandedIcon = node['isFormulaire'] ? 'fa-file' : 'fa-folder-open';
    node.collapsedIcon = node['isFormulaire'] ? 'fa-file' : 'fa-folder';

    node.children.forEach(childNode => {
      this.expandRecursive(childNode, isExpand);
    });
  }






}
