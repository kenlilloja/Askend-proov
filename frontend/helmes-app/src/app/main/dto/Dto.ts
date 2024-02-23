export class KasutajaInfoDto {
    id: any;
    nimi: string;
    sektorid: KasutajaSektorDto[];
    onNousTingimustega: boolean;
    createdAt: any;
    lastModifiedAt: any;

  constructor(nimi: string = '', sektorid:  any[] = [], onNousTingimustega: boolean = false) {
    this.nimi = nimi;
    this.sektorid = sektorid;
    this.onNousTingimustega = onNousTingimustega;
  }
}

export class KasutajaSektorDto {
    id: any;
    sektor: any;
    createdAt: any;
    lastModifiedAt: any;

    constructor(id: any, sektor: any, createdAt: any, lastModifiedAt: any) {
        this.id =  id;
        this.sektor = sektor;
        this.createdAt = createdAt
        this.lastModifiedAt = lastModifiedAt
    }
}
