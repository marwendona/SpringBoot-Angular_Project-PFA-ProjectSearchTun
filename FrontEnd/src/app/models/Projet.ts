import { User } from "./User";

export class Projet {

    projectId:number;
    user:User;
    title:string;
    type:string;
    description:string;
    requiredSkills:string[];
    createdDate:Date;
    numberOfMembers:number;
    projectStatus:string;


    
  constructor(projectId:number,user:User,title: string, type: string, description: string, requiredSkills: string[], createdDate: Date, numberOfMembers: number,projectStatus:string) {
    this.projectId = projectId;
    this.user = user;
    this.title = title;
    this.type = type;
    this.description = description;
    this.requiredSkills = requiredSkills;
    this.createdDate = createdDate;
    this.numberOfMembers = numberOfMembers;
    this.projectStatus = projectStatus;
  }
  
 
  
   
  }