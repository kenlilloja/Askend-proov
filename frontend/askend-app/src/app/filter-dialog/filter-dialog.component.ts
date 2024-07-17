import {Component, OnInit} from '@angular/core';
import { MatDialogRef } from "@angular/material/dialog";
import { CriteriaDTO, FilterDTO } from "../main/dto/Dto";

@Component({
    selector: 'app-filter-dialog',
    templateUrl: './filter-dialog.component.html',
    styleUrls: ['./filter-dialog.component.css'] // Make sure this is 'styleUrls' (plural)
})
export class FilterDialogComponent implements OnInit {

    // Initialize criterias as an array of CriteriaDTO
    criterias: CriteriaDTO[] = [];
    filter: FilterDTO = {
        name: '',
        selectedCriteria: {
            criteriaType: '',
            condition: '',
            value: ''
        },
        criterias: []
    };

    constructor(public dialogRef: MatDialogRef<FilterDialogComponent>) {
    }

    ngOnInit(): void {
        this.addRow();
    }

    onClose(): void {
        this.dialogRef.close();
    }

    onSave(): void {
        // Implement save logic
        this.dialogRef.close();
    }

    deleteRow(index: number) {
        this.criterias.splice(index, 1);
    }

    addRow() {
        const newCriteria: CriteriaDTO = {
            criteriaType: '',
            condition: '',
            value: ''
        };
        this.criterias.push(newCriteria);
    }
}
