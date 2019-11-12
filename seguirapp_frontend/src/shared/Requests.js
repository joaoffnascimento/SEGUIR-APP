import axiosApi from './axiosApi'

export const getClientes = () => {
    return axiosApi.get(`/pessoa`)
}

export default {
    getClientes
}