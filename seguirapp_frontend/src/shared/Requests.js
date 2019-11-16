import axiosApi from './AxiosApi'

export const getClientes = () => {
    return axiosApi.get(`/pessoa`)
}

export const createCliente = (values) => {
    return axiosApi.post('/pessoa/cadastrar',{values})
}

export default {
    getClientes,
    createCliente
}