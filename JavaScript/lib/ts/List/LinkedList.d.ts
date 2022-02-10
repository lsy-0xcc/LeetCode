export default class LinkedList<T> {
    private head;
    private tail;
    private _length;
    constructor(list?: T[]);
    get length(): number;
    private insert;
    private remove;
    push(val: T): void;
    pop(): T | null;
    shift(): T | null;
    unshift(val: T): void;
    toArray(): T[];
    getFirst(): T | null;
    getLast(): T | null;
}
