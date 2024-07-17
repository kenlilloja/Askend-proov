export interface FilterDTO {
    name: string;
    selectedCriteria: CriteriaDTO;
    criterias: CriteriaDTO[];
}

export interface CriteriaDTO {
    criteriaType: any;
    condition: any;
    value: string;
}
