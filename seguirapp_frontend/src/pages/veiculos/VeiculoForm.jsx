import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form'
import { Container, Header, Form, Button, Message, Table } from 'semantic-ui-react';
import { cpfLabel, validateCpf, requiredValidate, celularLabel, validatePhoneBr } from '../../helpers/FnUtils'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import { createVeiculo } from '../../actions/formActions'
import { TextField } from '../../shared/form/TextField'
import { SelectField } from '../../shared/form/SelectField'
import Requests from '../../shared/Requests'

class VeiculoForm extends Component {

    state = {
        veiculos: [],

        errors: [],
        optionsDispositivos: [],
        estado: ''
    }

    componentDidMount() {
        this.getDispositivos()
        this.getVeiculos()
        // this.getEstados()
        // // this.getCidades()
        // this.getGrupos()
    }

    getVeiculos() {
        Requests.getVeiculos().then(veiculos => {
            this.setState({ veiculos: veiculos })
        })
    }


    getDispositivos() {

        this.setState({ loading: true })

        Requests.getVeiculos().then(veiculos => {

            let identificador = []
            let dispositivoValid = []

            const dispVeiculo = veiculos.filter(veiculo => {
                return veiculo.dispositivo
            })

            dispVeiculo.map(id => {
                identificador.push(id.dispositivo.identificador)
            })

            Requests.getDispositivos().then(dispositivos => {

                for (let index = 0; index < dispositivos.length; index++) {

                    const dispositivo = dispositivos[index]

                    const identificadorveiculo = identificador[index]

                    dispositivoValid.push(dispositivo.identificador !== identificadorveiculo ?
                        dispositivos[index] : null)
                }

                const disps = dispositivoValid.map(disp => (
                    disp ?
                        { key: disp.idDispositivo, text: disp.nome, value: { idDispositivo: String(disp.idDispositivo) } }
                        : {}
                ))

                this.setState({ optionsDispositivos: disps, loading: false })
            })
        })
    }

    renderVeiculo(veiculo) {
        const dispositivo = veiculo.dispositivo ? veiculo.dispositivo.nome : 'Não encontrado'

        return (
            <Table.Row key={veiculo.idVeiculo}>
                <Table.Cell>
                    {veiculo.marca}
                </Table.Cell>
                <Table.Cell>
                    {veiculo.modelo}
                </Table.Cell>
                <Table.Cell>
                    {veiculo.cor}
                </Table.Cell>
                <Table.Cell>
                    {dispositivo}
                </Table.Cell>
            </Table.Row>
        )
    }

    renderVeiculos() {

        const { veiculos } = this.state

        console.log(veiculos)

        return (
            <>
                <Header>Lista Veiculos</Header>

                <Table>
                    <Table.Header>
                        <Table.Row>
                            <Table.HeaderCell>MARCA</Table.HeaderCell>
                            <Table.HeaderCell>MODELO</Table.HeaderCell>
                            <Table.HeaderCell>COR</Table.HeaderCell>
                            <Table.HeaderCell>PLACA</Table.HeaderCell>
                            <Table.HeaderCell>DISPOSITIVO</Table.HeaderCell>
                        </Table.Row>
                    </Table.Header>

                    <Table.Body>
                        {veiculos.map(veiculo => this.renderVeiculo(veiculo))}
                    </Table.Body>

                </Table>
            </>
        )
    }

    render() {
        const { handleSubmit } = this.props
        const { errors, optionsDispositivos, loading } = this.state

        const dispositivosOpts = optionsDispositivos.filter(item => {
            if (item.key) {
                return item
            }
        });

        return (
            <Container className='semi-fluid'>
                <Header>Cadastrar Veiculos</Header>

                <Message
                    error
                    hidden={errors.length === 0}
                    list={errors}>
                </Message>

                <Form onSubmit={handleSubmit(this.props.createVeiculo)}>

                    <Form.Group widths='equal'>
                        <Field
                            name='marca'
                            label='Marca'
                            placeholder='Informe a marca'
                            component={TextField} />

                        <Field
                            name='modelo'
                            label='Modelo'
                            placeholder='Informe o modelo'
                            component={TextField} />
                        <Field
                            name='cor'
                            label='Cor'
                            placeholder='Informe a cor'
                            component={TextField} />
                        <Field
                            name='placa'
                            label='Placa'
                            placeholder='Informe a placa'
                            component={TextField} />
                    </Form.Group>

                    <Form.Group widths='equal'>
                        <Field
                            name='dispositivo'
                            options={dispositivosOpts}
                            placeholder='Selecione um dispositivo'
                            label='Dispositivo'
                            component={SelectField} />
                    </Form.Group>

                    <Button positive loading={this.props.loading} type='submit' >Cadastrar</Button>
                </Form>
            </Container>
        );
    }
}

const validate = (values, props) => {
    const marca = requiredValidate(values.marca)

    let modelo = requiredValidate(values.modelo)

    const cor = requiredValidate(values.cor)

    const placa = requiredValidate(values.placa)

    const dispositivo = requiredValidate(values.dispositivo)

    const errors = {
        marca,
        modelo,
        cor,
        placa,
        dispositivo
    }
    return errors
}

const veiculoForm = reduxForm({
    form: 'veiculoForm',
    validate
})(VeiculoForm)

const mapStateToProps = state => ({
    loading: state.system.loading
})

const mapDispatchToProps = dispatch => bindActionCreators({ createVeiculo }, dispatch)

export default connect(mapStateToProps, mapDispatchToProps)(veiculoForm)