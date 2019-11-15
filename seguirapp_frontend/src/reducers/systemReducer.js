const INITIAL_STATE = {
    user: {
        idUser: '',
        tipoUser: ''
    }
}

export default function (state = INITIAL_STATE, action) {
    switch (action.type) {
        case 'SET_USUARIO':
            return ({
                user: action.payload
            })
        default:
            return state
    }
}