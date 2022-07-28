import { Curso } from './model/curso/curso';
import { CursoService } from './service/curso/curso.service';
import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  message: string = "Projeto angular";
  cursos: Curso[] = [];

  form: FormGroup = new FormGroup({
    "description": new FormControl('')
  })

  constructor(
    private cursoService: CursoService
  ) { }

  submit() { 
    const curso: Curso = { ...this.form.value }
    this.cursoService.salvar(curso).subscribe(
      resp => {
        this.cursos.push(resp);
        this.form.reset()
      })
  }
}
