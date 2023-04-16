import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchServiceService {

  constructor(private http: HttpClient) { }

  search(query: string): Observable<any> {
    const url = `http://localhost:8080/search?q=${query}`;
    return this.http.get(url);
  }
}
