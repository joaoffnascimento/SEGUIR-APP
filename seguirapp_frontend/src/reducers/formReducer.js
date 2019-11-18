const INITIAL_STATE = {
    loading: false
}

export default function (state = INITIAL_STATE, action) {
    switch (action.type) {
        case 'SET_LOADING':
            return ({
                loading: action.payload
            })
        default:
            return state
    }
}