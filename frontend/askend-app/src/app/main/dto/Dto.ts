export interface FilterDTO {
    name: string;
    selectedCriteria: CriteriaDTO;
    criterias: CriteriaDTO[];
}

export interface CriteriaDTO {
    criteriaType: string;
    condition: string;
    value: string;
}
