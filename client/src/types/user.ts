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
    loggedIn : boolean;
}

export const SET_USER = "SET_USER"; 
export const UPDATE_USER = "UPDATE_USER";

interface SetUserAction {
    type : typeof SET_USER; 
    payload : { user : User; loggedIn : boolean}; 
}

interface UpdateUserAction {
    type : typeof UPDATE_USER; 
    payload : { user : User; loggedIn : boolean}; 
}

export type UserActionTypes = SetUserAction | UpdateUserAction; 

// interface : define interfaces for each item in the state
// actions : move to actions in order to update the actions 
// reducer : move to reducer in order to update the reducer