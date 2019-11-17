import axiosApi from './AxiosApi'

export const getClientes = () => {
    return axiosApi.get(`/pessoa`)
}

export const createCliente = (values) => {
    return axiosApi.post('/pessoa/cadastrar',values)
}

export const getDispositivos = () => {
    return axiosApi.get('/dispositivo')
}

export const createDispositivo = (value) => {
    return axiosApi.post('/dispositivo/cadastrar', value)
}

export const getCidades = () => {
    return axiosApi.get('/cidade')
}

export const getEstados = () => {
    return axiosApi.get('/estado')
}

export const createGrupo = (value) =>{
    return axiosApi.post('/grupo/cadastrar', value)
} 

export const getGrupos = () => {
    return axiosApi.get('/grupo')
}

export default {
    getClientes,
    createCliente,
    getDispositivos,
    createDispositivo,
    getCidades,
    getEstados,
    createGrupo,
    getGrupos
}