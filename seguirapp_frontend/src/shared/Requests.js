import axiosApi from './AxiosApi'

export const getClientes = () => {
    return axiosApi.get(`/pessoa`)
}

export default {
    getClientes
}