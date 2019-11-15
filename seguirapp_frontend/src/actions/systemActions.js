export const setUsuario = (user) => {
    return(dispatch) => {
        dispatch({
            type: 'SET_USUARIO',
            payload: user
        }) 
    }
}