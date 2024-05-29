import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient){}

  public getEmployees(): Observable<Employee[]>{
    return this.http.get<Employee[]>(`${this.apiServerUrl}/employee/all`);
  }

  public addEmployees(employee: Employee): Observable<Employee>{
    return this.http.post<Employee>(`${this.apiServerUrl}/employee/create`, employee);
  }

  public updateEmployees(employee: Employee , employeeId:Number): Observable<Employee>{
    return this.http.put<Employee>(`${this.apiServerUrl}/employee/update/${employeeId}`, employee);
  }

  public deleteEmployees(id: Number): Observable<string>{
    return this.http.delete<string>(`${this.apiServerUrl}/employee/delete/${id}`);
  }

  //meken thami attatama backend eki frontend eki connect krnna wade sidda wenne hariytm baluwoth , project eka ynwath ekkala eka confirm krgnna blnna 

}
