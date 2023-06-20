import { Component, OnInit } from '@angular/core';
import Chart from 'chart.js/auto';
import { TacheService } from 'src/app/services/tache.service';
@Component({
  selector: 'app-chart-ing',
  templateUrl: './chart-ing.component.html',
  styleUrls: ['./chart-ing.component.css']
})
export class ChartIngComponent implements OnInit {
  chart: any;
  totaltodo: any;
 todo:any;
 totaldone:any;
 done:any;
 inprogress:any;
 totalinprogress:any;
 userconnect=JSON.parse(localStorage.getItem("userconnect")!)
  constructor(private api: TacheService) { }

  ngOnInit(): void {
    this.api.getalltasks().subscribe((res:any)=>{
      this.done=res.filter((el:any)=>el.status=="done"  &&  el.ing!=null && el.ing.id==this.userconnect.id )
      console.log("list of done tasks",this.done)
      this.totaldone=this.done.length;
   
    console.log("nombre de task done", this.totaldone)
    this.api.getalltasks().subscribe((res:any)=>{
      this.todo=res.filter((el:any)=>el.status=="todo" &&  el.ing!=null && el.ing.id==this.userconnect.id)
      console.log("list of todo tasks",this.todo)
      this.totaltodo=this.todo.length;
    console.log("nombre de task todo", this.totaltodo)
   
    this.api.getalltasks().subscribe((res:any)=>{
      this.inprogress=res.filter((el:any)=>el.status=="inprogress" &&  el.ing!=null && el.ing.id==this.userconnect.id)
      console.log("list of inprogress tasks",this.inprogress)
      this.totalinprogress=this.inprogress.length;
    console.log("nombre de task inprogress", this.totalinprogress)
   

    this.chart = new Chart('canvas', {
      type: 'doughnut',

      data: {
        labels: ['Closed', 'Todo', 'Inprogress'],
        datasets: [
          {
            label: 'My First Dataset',
            data: [this.totaldone,this.totaltodo,this.totalinprogress],
            backgroundColor: [
              'rgb(255, 99, 132)',
              'rgb(54, 162, 235)',
              'rgb(255, 205, 86)',
            ],
            hoverOffset: 4,
          },
        ],
      },
      // options: {
      //   borderRadius: 10,
      // },
     
    });
  })
})
})
  }

}
