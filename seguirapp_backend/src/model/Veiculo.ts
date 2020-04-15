import moment from 'moment'

class Veiculo {
    createdAt: Date
    updatedAt: Date

    anoVeiculo: Date

    constructor(public placa: string, public chassi: string, public cor: string, public marca: string, public modelo: string) {
        this.createdAt = moment().toDate()
    }
}