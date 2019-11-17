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
            })
    }
}

export const createDispositivo = (values) => {
    return dispatch => {
        console.log(values)
        Requests.createDispositivo(values)
            .then(resp => {
                dispatch([
                    resetForm('dispositivoForm')
                ])
                toastr.success('Sucesso', 'Dispositivo cadastrado com sucesso!')
            }).catch(err =>{
                toastr.error(err)
            })
    }
}