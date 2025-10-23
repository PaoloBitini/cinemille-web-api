export interface Sort {
    empty: boolean,
    sorted: boolean,
    unsorted: boolean
}

export interface Pageable {
    pageNumber: number,
    pageSize: number,
    sort: Sort,
    offset: number,
    paged: boolean,
    unpaged: boolean
}


export class Page<Model> {
    content: Model[] = [];
    pageable!: Pageable;
    last!: boolean;
    totalPages!: number;
    totalElements!: number;
    size!: number;
    number!: number;
    sort!: Sort;
    first!: boolean;
    numberOfElements!: number;
}