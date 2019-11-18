import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form'
import { Container, Header, Form, Button, Message, Table, Segment } from 'semantic-ui-react';
import { cpfLabel, validateCpf, requiredValidate, celularLabel, validatePhoneBr } from '../../helpers/FnUtils'
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import { createVeiculo } from '../../actions/formActions'
import { TextField } from '../../shared/form/TextField'
import { SelectField } from '../../shared/form/SelectField'
import Requests from '../../shared/Requests'
import { Link } from 'react-router-dom'

class VeiculoList extends Component {

    state = {
        veiculos: []
    }

    componentDidMount() {
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


    renderVeiculo(veiculo) {
        const dispositivo = veiculo.dispositivo ? veiculo.dispositivo.nome : 'Não encontrado'

        console.log(dispositivo)
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
                    {veiculo.placa}
                </Table.Cell>
                <Table.Cell>
                    {dispositivo}
                </Table.Cell>
            </Table.Row>
        )
    }

    render() {

        const { veiculos } = this.state

        console.log(veiculos)

        return (
            <Container className='semi-fluid'>

                <Segment>
                    <Link to='/veiculo/novo'>
                        <Button>Novo Veiculo</Button>
                    </Link>
                </Segment>


                <Header>Veiculos</Header>

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
            </Container>
        )
    }
}

export default VeiculoList