import { Language } from '../language.model';
import { Project } from '../project.model';
import { ProjectService } from './../project.service';
import { Component, Input } from '@angular/core';


@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrl: './card.component.css'
})
export class CardComponent {
  @Input() title: string = '';
  @Input() content: string = '';
  @Input() languages: Language[] = [];
  onActionClick() {
    console.log('Ação clicada!');
    console.log(this.title);
    console.log(this.languages);
  }

}
