

export class projetV1 {

   
    title:string;
    type:string;
    description:string;

    requiredSkills:string[];
    createdDate:Date;
    numberOfMembers:number;



    
  constructor(title: string, type: string, description: string,    
     requiredSkills: string[], createdDate: Date, numberOfMembers: number) {

    this.title = title;
    this.type = type;
    this.description = description;

    this.requiredSkills = requiredSkills;
    this.createdDate = createdDate;
    this.numberOfMembers = numberOfMembers;

  }
  
 
  
   
  }