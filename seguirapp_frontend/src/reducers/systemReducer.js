const INITIAL_STATE = {
    user: {
        idUser: '',
        tipoUser: ''
    },
    loading: false
}

export default function (state = INITIAL_STATE, action) {
    switch (action.type) {
        case 'SET_USUARIO':
            return ({
                user: action.payload
            })
        case 'SET_LOADING':
            return ({
                loading: action.payload
            })
        default:
            return state
    }
}