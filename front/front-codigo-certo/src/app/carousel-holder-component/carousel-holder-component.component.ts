import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { OwlOptions, SlidesOutputData } from 'ngx-owl-carousel-o';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-carousel-holder-component',
  templateUrl: './carousel-holder-component.component.html',
  styleUrl: './carousel-holder-component.component.css',
  encapsulation: ViewEncapsulation.None,
})
export class CarouselHolderComponentComponent{
 //projects: Projects[] = [];

  customOptions: OwlOptions = {
    loop: true,
    margin:10,
    mouseDrag: true,
    touchDrag: true,
    pullDrag: true,
    dots: true,
    navSpeed: 700,
    navText: ['<', '>'],
    responsive: {
      0: {
        items: 1
      },
      400: {
        items: 2
      },
      740: {
        items: 3
      },
      940: {
        items: 4
      }
    },
    nav: true
  }
    activeSlides: SlidesOutputData | undefined;

      slidesStore: any[] | undefined;
      //constructor() {}

      getData(data: SlidesOutputData) {
        this.activeSlides = data;
        console.log(this.activeSlides);
      }

   //slidesStore: any[] = [];


  constructor(private ProjectService: ProjectService) { }

  ngOnInit(): void {
    this.ProjectService.getProjects().subscribe(data => {
      this.slidesStore = data;
    });
  }
}


