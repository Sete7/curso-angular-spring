import { Curso } from './model/curso/curso';
import { CursoService } from './service/curso/curso.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  message: string = "Projeto angular";
  cursos: Curso[] = [];

  form: FormGroup = new FormGroup({
    "description": new FormControl('')
  })

  constructor(
    private cursoService: CursoService
  ) { }

  ngOnInit() {
    this.listar();
  }

  submit() {
    const curso: Curso = { ...this.form.value }
    this.cursoService.salvar(curso).subscribe(
      resp => {
        this.cursos.push(resp);
        this.form.reset()
      })
  }

  listar() {
    this.cursoService.listar()
      .subscribe(
        resp => {
          this.cursos = resp;
          console.log(resp)
        }
      )
  }

  deletar(curso: Curso){
    this.cursoService.deletar(curso.id)
    .subscribe({next: (resp) => this.listar()})
  }



}


