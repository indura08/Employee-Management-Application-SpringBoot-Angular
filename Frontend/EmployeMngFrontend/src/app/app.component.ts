import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';
import { HttpErrorResponse } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule , FormsModule, ReactiveFormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  
  public employees: Employee[] = [];
  //public editEmployee: Employee = {name:'test', email: 'test', id:5 , jobTitle:'test', phone:'test', imgUrl:'test', employeecode:'test', address:'test'}
  public editEmployee?:Employee;
  public deletedEmployee?: Employee ;
  public delempId : Number = 0;

  constructor(private employeeService : EmployeeService ){}

  ngOnInit(): void {  //me ng oniti eka attama thiyenne me app component ekt adlala html template eka load wena welawl waldi run wenna one dewal monw kiyna eka dennai , eka dena wiiya meke example eknuiangular tutorial examp[le ekai ekkala compare krla blnna wenas kam
      this.getEmployee();
  }

  public editEmpForm(employee: Employee , employeeId : Number):void{
    this.editEmployee = employee;
    this.delempId = employeeId;
  }

  public delemp(employee: Employee){
    this.deletedEmployee = employee;
  }

  public getEmployee(): void{
    this.employeeService.getEmployees().subscribe(
      (response: Employee[]) => {
        this.employees = response;
      },
      (error:HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  public addEmployee(addForm: NgForm):void{
    this.employeeService.addEmployees(addForm.value).subscribe(
      (response: Employee) => {
        console.log(response);    //methna me subscribe eka athule liyna function deka awilla response mona hari thiynwa nm ewa handle krnni saha error mona hari thiynwa nm ewa dusplay krnni , hama ekema eham scn ekk mul krgni e subscribe eka athule liyna code deka liynne 
        this.getEmployee()
        addForm.resetForm();
      },
      (error:HttpErrorResponse)=> {
        alert(error.message);
      }
    )
  }

  public updateEmployee(employee: Employee):void{
    console.log(employee.id)
    this.employeeService.updateEmployees(employee, this.delempId).subscribe(
      (response: Employee) => {
        console.log(response);    //methna me subscribe eka athule liyna function deka awilla response mona hari thiynwa nm ewa handle krnni saha error mona hari thiynwa nm ewa dusplay krnni , hama ekema eham scn ekk mul krgni e subscribe eka athule liyna code deka liynne 
        this.getEmployee()
      },
      (error:HttpErrorResponse)=> {
        alert(error.message);
      }
    )
  }

  public deleteEmployee(employeeId: Number):void{
    this.employeeService.deleteEmployees(employeeId).subscribe(
      (response: string) => {
        console.log(response);    //methna me subscribe eka athule liyna function deka awilla response mona hari thiynwa nm ewa handle krnni saha error mona hari thiynwa nm ewa dusplay krnni , hama ekema eham scn ekk mul krgni e subscribe eka athule liyna code deka liynne 
        this.getEmployee()
      },
      (error:HttpErrorResponse)=> {
        alert(error.message);
      }
    )
  }

  // public onOpenModel(employee: Employee , mode: string){

  //   const container = document.getElementById('main-container');
  //   const button = document.createElement('button');
  //   button.type = 'button';
  //   button.style.display = 'none';
  //   button.setAttribute('data-bs-toggle', 'modal');
    
  //   if(mode === 'add'){
  //     button.setAttribute('data-bs-target' , '#addEmployeeModel');
  //   }
  //   if(mode === 'edit'){
  //     button.setAttribute('data-bs-target' , '#updateEmployeeModal');
  //   }
  //   if(mode === 'delete'){
  //     button.setAttribute('data-bs-target' , '#deleteEmployeeModal');
  //   }

  //   container?.appendChild(button);
  //   button.click()
  // }

  //nawattuwe 1:54:54 testing modaal logic eka blnna thiynne 

 
  
}
