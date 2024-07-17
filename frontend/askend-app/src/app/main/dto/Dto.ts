export interface FilterDTO {
    id: any;
    name: string;
    selectedCriteria: CriteriaDTO;
    criterias: CriteriaDTO[];
    createdAt: any;
}

export interface CriteriaDTO {
    id: any;
    criteriaType: any;
    condition: any;
    value: string;
}
