import moment from "moment"

class Equipamento {
    createdAt: Date
    updatedAt: Date

    coordenada: {
        latitude: number
        longitude: number
        velocidade: number
        altitude: number
        horario: Date
    }

    constructor(public marca: string) {
        this.createdAt = moment().toDate()
    }
}