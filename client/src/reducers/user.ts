import { UserState, UserActionTypes, SET_USER, UPDATE_USER } from "../types/user";

const initialState : UserState = {
    user : null, 
    loggedIn : false,
}; 

const userReducer = (state = initialState, action : UserActionTypes) : UserState => {
    switch (action.type) {
        case SET_USER : 
            return {
                ...state, user : action.payload.user, loggedIn : action.payload.loggedIn,  
            }; 
        case UPDATE_USER : 
            return {
                ...state, 
                user : state.user ? {...state.user, ...action.payload} : null, 
            }; 
        default : return state; 
    }
}

export default userReducer; 