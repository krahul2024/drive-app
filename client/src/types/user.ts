export interface User{
    id : number, 
    name : string, 
    email : string, 
    password? : string, 
    imageUrl ? : string, 
    joinedAt ?: string, 
    updatedAt ? : string, 
    lastSeen ? : string, 
    usedStorage ? : number, 
    planId ? : number, 
}

export interface UserState {
    user : User | null ; 
}

export const SET_USER = "SET_USER"; 
export const UPDATE_USER = "UPDATE_USER";

interface SetUserAction {
    type : typeof SET_USER; 
    payload : User; 
}

interface UpdateUserAction {
    type : typeof UPDATE_USER; 
    payload : User; 
}

export type UserActionTypes = SetUserAction | UpdateUserAction; 