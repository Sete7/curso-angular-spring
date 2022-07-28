import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  message: string = "Projeto angular";

  form: FormGroup = new FormGroup({
    "description": new FormControl('Java')
  })

  submit() {
    console.log(this.form.value)
  }
}
