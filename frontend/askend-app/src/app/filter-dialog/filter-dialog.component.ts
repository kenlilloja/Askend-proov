import {Component, OnInit} from '@angular/core';
import { MatDialogRef } from "@angular/material/dialog";
import { CriteriaDTO, FilterDTO } from "../main/dto/Dto";
import {HttpService} from "../http.service";

@Component({
    selector: 'app-filter-dialog',
    templateUrl: './filter-dialog.component.html',
    styleUrls: ['./filter-dialog.component.css']
})
export class FilterDialogComponent implements OnInit {

    comparisonTypes: any;
    criteriaTypes: any;
    criterias: CriteriaDTO[] = [];
    filter: FilterDTO = {
        id: null,
        name: '',
        criterias: [],
        createdAt: null
    };

    constructor(private dialogRef: MatDialogRef<FilterDialogComponent>,
                private service: HttpService) {
    }

    ngOnInit(): void {
        this.addRow();
        this.loadCriteriaTypes();
        this.loadComparisonTypes();
    }

    onClose(): void {
        this.dialogRef.close();
    }

    onSave(): void {
        this.filter.criterias = this.criterias;
        this.service.saveFilter(this.filter).subscribe(
            (types) => {
                this.dialogRef.close();
            },
            (error) => {
                console.error('Error saving filter data:', error);
            }
        );
    }

    deleteRow(index: number) {
        this.criterias.splice(index, 1);
    }

    addRow() {
        const newCriteria: CriteriaDTO = {
            id: null,
            criteriaType: '',
            condition: '',
            value: '',
            isSelected: false
        };
        this.criterias.push(newCriteria);
    }

    private loadCriteriaTypes() {
        this.service.loadClassifiers('CRITERIA_TYPE').subscribe(
            (types) => {
                this.criteriaTypes = types;
            },
            (error) => {
                console.error('Error loading criteria data:', error);
            }
        );
    }

    private loadComparisonTypes() {
        this.service.loadClassifiers('CRITERIA_COMPARISON').subscribe(
            (compTypes) => {
                this.comparisonTypes = compTypes
            },
            (error) => {
                console.error('Error loading comparison data:', error);
            }
        );
    }

    onCriteriaChange(event: any) {
        const selectedCriteria = event.value;

        this.criterias.forEach(criteria => {
            criteria.isSelected = criteria === selectedCriteria;
        });
    }
}
