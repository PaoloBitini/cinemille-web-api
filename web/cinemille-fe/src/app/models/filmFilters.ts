export interface FilmFilters {
    titolo: string,
    regista: string,
    genere: string,
    daDataUscita: string,
    aDataUscita: string,
    daDataFinePermanenza: string,
    aDataFinePermanenza: string
}

export function defaultFilmFilter(): FilmFilters {
    return {
        titolo: "",
        regista: "",
        genere: "",
        daDataUscita: "",
        aDataUscita: "",
        daDataFinePermanenza: "",
        aDataFinePermanenza: ""
    }
}