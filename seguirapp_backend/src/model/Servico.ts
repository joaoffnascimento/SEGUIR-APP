import {
    ObjectId
} from 'mongodb';

import moment from 'moment'

class servico {
    createdAt: Date
    updatedAt: Date

    constructor(public pessoaId: ObjectId, public veiculoId: ObjectId, public equipamentoId: ObjectId, public descricao: string, public preco: number) {
        this.createdAt = moment().toDate()
    }
}