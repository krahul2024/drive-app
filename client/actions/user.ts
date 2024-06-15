import {User, SET_USER, UPDATE_USER, UserActionTypes} from "../types/user";

export const setUser = (user : User) : UserActionTypes => ({
    type : SET_USER, 
    payload : user
}); 

export const updateUser = (user : User) : UserActionTypes => ({
    type : UPDATE_USER, 
    payload : user
}); 