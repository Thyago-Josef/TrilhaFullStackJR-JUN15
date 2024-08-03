import { Language } from './../language.model';
import { Component } from '@angular/core';
import { Project } from '../project.model';
import { ProjectService } from './../project.service';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrl: './project-list.component.css'

})
export class ProjectListComponent {
  projects: Project[] = [];
  languages:Language[] = [];

  constructor(private projectService: ProjectService) { }

  ngOnInit() {
    this.projectService.getProjects().subscribe((data: Project[]) => {
      this.projects = data;
    });
}
}
