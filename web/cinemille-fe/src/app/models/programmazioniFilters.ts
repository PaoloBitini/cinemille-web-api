export interface ProgrammazioniFilters {
    titolo: string,
    regista: string,
    genere: string,
    sala: string,
    daProiezione: string;
    aProiezione: string;
}

export function defaultProgramamzioniFilters(): ProgrammazioniFilters {
    return {
        titolo: "",
        regista: "",
        genere: "",
        sala: "",
        daProiezione: "",
        aProiezione: "",
    }
}