import { Component, OnInit } from '@angular/core';
import {FilterDialogComponent} from "../filter-dialog/filter-dialog.component";
import {MatDialog} from "@angular/material/dialog";
import {FilterDTO} from "./dto/Dto";
import {HttpClient} from "@angular/common/http";
import {HttpService} from "../http.service";

@Component({
    selector: 'app-main',
    templateUrl: './main.component.html',
    styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
    filters: FilterDTO[] = [];

    constructor(
        private dialog: MatDialog,
        private httpService: HttpService) {}

    ngOnInit(): void {
    }

    openAddingModal() {
        const dialogRef = this.dialog.open(FilterDialogComponent, {
            width: '85vh',
            disableClose: true
        });
    }
}
