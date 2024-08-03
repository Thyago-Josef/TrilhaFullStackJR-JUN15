// import { Language } from "./language.model";

import { Language } from "./language.model";

export interface Project {
    id_project: number;
    name_project: string;
    description_project: string;
    date_project: Date;
    languages: Language[];
    
  }
  