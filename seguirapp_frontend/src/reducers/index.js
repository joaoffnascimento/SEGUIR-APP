import { combineReducers } from 'redux'
import { reducer as formReducer } from 'redux-form'
import { reducer as toastrReducer } from 'react-redux-toastr'

import systemReducer from './systemReducer'

const rootReducer = combineReducers({
    system: systemReducer,
    form: formReducer,
    toastr: toastrReducer
})

export default rootReducer