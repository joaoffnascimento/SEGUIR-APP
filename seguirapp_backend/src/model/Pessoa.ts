import {
    ObjectId
} from 'mongodb';

import moment from 'moment'
import crypt from './../util/bcrypt'

class Pessoa {

    cnpj!: string
    sexo!: string
    createdAt: Date
    updatedAt!: Date
    //Normalizar endereço depois (issue)
    telefone!: string
    auth!: {
        email: string,
        password: string
    }

    constructor(public nomeCompleto: string, public cidadeId: ObjectId, public cpf: string, email: string, password: string, public endereco: string, public celular: string) {

        this.createdAt = moment().toDate()
        this.auth.email = email
        // O bcrypt vai agir antes de salvar, TS informa que Promise<string> != string
        crypt(password).then(res => {
            this.auth.password = res
        })


    }
}