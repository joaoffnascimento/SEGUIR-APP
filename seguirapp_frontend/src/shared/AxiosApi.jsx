import axios from 'axios'
import { toastr } from 'react-redux-toastr'

const axiosApi = axios

axiosApi.defaults.baseURL = 'http://localhost:8080/rest'


export const ResponseSucess = function (response) {
    if (response.data) {
        return response.data;
    }
    return response;
}

export const ResponseError = (error) => {
    if (error.response) {

        const { status, data } = error.response

        const { errors } = data

        switch (status) {
            case 400:
                toastr.error(errors)
                break;
            case 401:
                toastr.error(errors)
                break;
            case 404:
                toastr.error(errors)
                break;
        }
    } else {
        if (error.message === 'Network Error') {
            toastr.error('Sem conexão com o servidor');
        }
    }

    return Promise.reject(error);
}

axiosApi.interceptors.response.use(ResponseSucess, ResponseError);

export default axiosApi;