import Requests from '../shared/Requests'
import { reset as resetForm } from 'redux-form'
import { toastr } from 'react-redux-toastr'

export const createCliente = (values) => {
    return dispatch => {
        Requests.createCliente(values)
            .then(resp => {
                dispatch([
                    resetForm('clienteForm')
                ])
                toastr.success('Sucesso', 'Usuario cadastrado com sucesso!')
            }).catch(err => {
                dispatch([
                    resetForm('clienteForm')
                ])
                toastr.success('Sucesso', 'Usuario cadastrado com sucesso!')
            })
    }
}