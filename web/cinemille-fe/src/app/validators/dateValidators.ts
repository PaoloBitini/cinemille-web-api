import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';
import { isMatch } from 'date-fns'

const dateFormat: string = "MM/dd/yyyy";
export const dateToStringFormat = "yyyy-MM-dd";

export function invalidDateValidator(): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
        const invalid = !isMatch(control.value, dateFormat)
        return invalid ? { invalidDate: { value: control.value } } : null;
    };
}

export function notJustOneDate(first: string, second: string): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
        let f = control.get(first);
        let s = control.get(second);
        return f && s && ((f.value && !s.value) || (s.value && !f.value)) ? { invalidDate: { value: control.value } } : null;
    };
}