import { Component, OnInit } from '@angular/core';
import {FilterDialogComponent} from "../filter-dialog/filter-dialog.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
    selector: 'app-main',
    templateUrl: './main.component.html',
    styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
    filters: [] = [];

    constructor(public dialog: MatDialog) {}

    ngOnInit(): void {
    }

    openAddingModal() {
        const dialogRef = this.dialog.open(FilterDialogComponent, {
            width: '85vh',
            disableClose: true
        });
    }
}
