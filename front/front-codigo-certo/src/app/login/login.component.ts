import { HttpClient } from '@angular/common/http';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  @Input() usuario: string = '';
  @Input() senha: string = '';
  @Input() mensagemErro: string = '';

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    // Implementar lógica de autenticação aqui
    // Exemplo usando HttpClient para POST em uma API
    this.http.post('/api/login', {
      usuario: this.usuario,
      senha: this.senha
    })
    .subscribe(
      (data) => {
        // Armazenar token de autenticação e redirecionar para a página principal
        console.log('Login realizado com sucesso!');
        // Redirecionar para página principal
      },
      (error) => {
        this.mensagemErro = 'Usuário ou senha inválidos.';
        console.error(error);
      }
    );
  }
}
