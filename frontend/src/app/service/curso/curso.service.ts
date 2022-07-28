import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Curso } from './../../model/curso/curso';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CursoService {

  apiUrl: string = "http://localhost:8080/api/curso";

  constructor(
    private http: HttpClient
  ) { }

  salvar(curso: Curso): Observable<Curso> {
    return this.http.post<Curso>(this.apiUrl, curso);
  }

  listar(): Observable<Curso[]> {
    return this.http.get<Curso[]>(`${this.apiUrl}/listar`);
  }
}
