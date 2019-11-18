import Requests from '../shared/Requests'
import { reset as resetForm } from 'redux-form'
import { toastr } from 'react-redux-toastr'

export const setLoading = (loading) => {
    return dispatch => {
        dispatch({
            type: 'SET_LOADING',
            payload: loading
        })
    }
}

export const createCliente = (values) => {
    setLoading(true)

    return dispatch => {
        Requests.createCliente(values)
            .then(resp => {
                dispatch([
                    resetForm('clienteForm')
                ])
                toastr.success('Sucesso', 'Usuario cadastrado com sucesso!')
                setLoading(false)

                const latitude = Math.random() * (100 - (-100)) + (-100)
                const longitude = Math.random() * (100 - (-100)) + (-100)
                const velocidade =  Math.random()

                const localizacao = {
                    latitude: latitude,
                    longitude: longitude,
                    velocidade: velocidade,
                    dispositivo: {
                        idDispositivo: values.dispositivo.idDispositivo
                    }
                }
                
                Requests.createLocalizacao(localizacao).then(resp => {
                })

                const {
                    protocol,
                    host
                } = window.location;

                window.location.replace(`${protocol}//${host}/#/cliente`);
            }).catch(err => {
                toastr.err('Erro', 'Usuario ja cadastrado!')
            })
    }
}

export const createVeiculo = (values) => {
    setLoading(true)

    return dispatch => {
        Requests.createVeiculo(values)
            .then(resp => {
                dispatch([
                    resetForm('veiculoForm')
                ])
                toastr.success('Sucesso', 'Veiculo cadastrado com sucesso!')
                setLoading(false)

                const {
                    protocol,
                    host
                } = window.location;

                window.location.replace(`${protocol}//${host}/#/veiculo`);
            }).catch(err => {
                toastr.error('Erro', 'Dispostivo ja cadastrado!')
            })
    }
}