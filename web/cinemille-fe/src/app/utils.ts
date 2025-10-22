import { FormGroup } from "@angular/forms";
import { FilmFilters } from "./models/filmFilters";
import { formatDate } from "date-fns";
import { dateToStringFormat } from "./validators/dateValidators";
import { ProgrammazioniFilters } from "./models/programmazioniFilters";

export function isControlInvalid(form: FormGroup, controlName: string) {
    return form.controls[controlName].invalid && (form.controls[controlName].dirty || form.controls[controlName].touched)
}

export function isEmptyFilmFilter(filmFilters: FilmFilters) {
    return !(
        filmFilters.titolo ||
        filmFilters.regista ||
        filmFilters.genere ||
        filmFilters.daDataUscita ||
        filmFilters.aDataUscita ||
        filmFilters.daDataFinePermanenza ||
        filmFilters.aDataFinePermanenza
    );
}

export function isEmptyProgrammazioniFilter(progFilters: ProgrammazioniFilters) {
    return !(
        progFilters.sala ||
        progFilters.titolo ||
        progFilters.regista ||
        progFilters.genere ||
        progFilters.daProiezione ||
        progFilters.aProiezione
    );
}

export function formatDateToString(value: string | Date | null): string {
    if (value) {
        return formatDate(value, dateToStringFormat);
    }
    return "";
}