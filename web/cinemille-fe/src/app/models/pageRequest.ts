export interface PageRequest {
    size: number,
    page: number
}

export function defaultPageRequest(): PageRequest {
    return {
        size: 20,
        page: 0
    }
}