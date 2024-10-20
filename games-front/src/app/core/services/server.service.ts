import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServerService {

  readonly baseUrl = '/api/games';

  private http = inject(HttpClient);

  start(id: string): Observable<void> {
    console.debug(`start ${id}`);
    return this.http.post<void>(`${this.baseUrl}/${id}/run`, null);
  }

  restart(id: string): Observable<void> {
    console.debug(`restart ${id}`);
    return this.http.put<void>(`${this.baseUrl}/${id}/run`, null);
  }

  stop(id: string): Observable<void> {
    console.debug(`stop ${id}`);
    return this.http.delete<void>(`${this.baseUrl}/${id}/run`);
  }

  update(id: string): Observable<void> {
    console.debug(`update ${id}`);
    return this.http.get<void>(`${this.baseUrl}/${id}/update`);
  }

}
