import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FilterDTO} from "./main/dto/Dto";

@Injectable({
  providedIn: 'root'
})
export class HttpService {

    private BASE_URL = '/api/v1/';
    constructor(private http: HttpClient) {}


    getUserData() {
        return this.http.get(this.BASE_URL + '/search');
    }

    saveFilter(filterDto: FilterDTO) {
        console.log(filterDto);
        return this.http.post(this.BASE_URL + 'filter/save', filterDto);
    }

    loadClassifiers(domainCode: string) {
        return this.http.get(this.BASE_URL + `classifier/${domainCode}`);
    }
}
