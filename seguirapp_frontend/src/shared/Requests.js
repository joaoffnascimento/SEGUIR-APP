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

export const createVeiculo = (value) => {
    return axiosApi.post('/veiculo/cadastrar', value)
}

export const getVeiculos = () => {
    return axiosApi.get('/veiculo')
}

export const getGrupos = () => {
    return axiosApi.get('/grupo')
}

export const getLocalizacaoById = (id) => {
    return axiosApi.get(`/localizacao/getLocalizacaoById/${id}`)
}

export const getLocalizacao = () => {
    return axiosApi.get('/localizacao')
}

export const createLocalizacao = (localizacao) => {
    return axiosApi.post('localizacao/post', localizacao)
}

export default {
    getClientes,
    createCliente,
    getDispositivos,
    createDispositivo,
    getCidades,
    getEstados,
    createGrupo,
    getGrupos,
    createVeiculo,
    getVeiculos,
    getLocalizacaoById,
    getLocalizacao,
    createLocalizacao
}