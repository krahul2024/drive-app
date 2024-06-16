import {User, SET_USER, UPDATE_USER, UserActionTypes} from "../types/user";

export const setUser = (user : User, loggedIn : boolean) : UserActionTypes => ({
    type : SET_USER, 
    payload : {user, loggedIn}
}); 

export const updateUser = (user : User, loggedIn : boolean) : UserActionTypes => ({
    type : UPDATE_USER, 
    payload : {user, loggedIn}
}); 