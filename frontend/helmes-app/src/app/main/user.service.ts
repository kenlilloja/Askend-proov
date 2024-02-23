import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { KasutajaInfoDto } from "./dto/Dto";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private BASE_URL = '/api/v1/user';
  constructor(private http: HttpClient) {}


  getUserData() {
    return this.http.get(this.BASE_URL + '/search');
  }

  createNewUser() {
      return this.http.get(this.BASE_URL + '/create-user');
  }

  saveUserInfo(userInfoDto: KasutajaInfoDto) {
    return this.http.post(this.BASE_URL + '/save', userInfoDto);
  }

  loadKlassifikaator(domainCode: string) {
    return this.http.get(`/api/v1/klassifikaator/${domainCode}`);
  }

}
