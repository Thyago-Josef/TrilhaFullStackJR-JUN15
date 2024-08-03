import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
    isLoggedIn(): boolean {
        const token = localStorage.getItem('token'); // Obter token do localStorage
        return !!token; // Verificar se o token existe e é válido
      }

  private apiUrl: string = 'http://localhost:8080/api'; // Substitua pela URL da sua API Spring

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    const body = {
      username: username,
      password: password
    };

    

    return this.http.post(this.apiUrl, body)
      .pipe(
        // Mapeamento da resposta da API para o formato desejado
        map((data: any) => {
          // Extrair token de autenticação da resposta
          const token = data.token;
          // Armazenar o token em local seguro (localStorage, por exemplo)
          localStorage.setItem('token', token);
          return data;
        })
      );
  }

  

  // Outros métodos para logout, verificação de usuário logado, etc.
}
