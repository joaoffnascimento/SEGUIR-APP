import React, { Component } from 'react';
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import { createDispositivo } from '../../actions/clienteActions'
import { Field, reduxForm } from 'redux-form'
import { Container, Header, Form, Button, Table } from 'semantic-ui-react';
import { TextField } from '../../shared/form/TextField'
import Requests from '../../shared/Requests'
import { toastr } from 'react-redux-toastr'

class GrupoForm extends Component {
    state = {
        grupos: [],
        nomeGrupo: ''
    }

    componentDidMount() {
        this.getGrupos()
    }

    getGrupos() {
        Requests.getGrupos().then(grupo => {
            this.setState({ grupos: grupo })
        })
    }

    handleSubmit = () => {
        const { nomeGrupo } = this.state
        const grupo = {
            empresa: nomeGrupo
        }

        Requests.createGrupo(grupo).then(resp => {
            toastr.success('Sucesso', 'Grupo cadastrado com sucesso!')
            this.setState({ nomeGrupo: '' })

            this.getGrupos()
        }).catch(err => {
            toastr.error(err)
        })
    }

    rendergrupos(grupo) {
        return (
            <Table.Row key={grupo.idGrupo}>
                <Table.Cell>{grupo.idGrupo}</Table.Cell>
                <Table.Cell>{grupo.empresa}</Table.Cell>
            </Table.Row>
        )
    }

    render() {
        const { grupos, nomeGrupo } = this.state

        return (
            <Container className='semi-fluid'>
                <Header>Cadastrar Grupo</Header>
                <Form onSubmit={this.handleSubmit}>
                    <Form.Group widths='equal'>
                        <Form.Input
                            label='Nome'
                            value={nomeGrupo}
                            placeholder='Informe o nome do grupo'
                            required
                            onChange={(event) => this.setState({ nomeGrupo: event.target.value })}
                        />
                    </Form.Group>

                    <Button positive type='submit'>Cadastrar</Button>
                </Form>

                <Header>Listar Grupos</Header>
                <Table>
                    <Table.Header>
                        <Table.Row>
                            <Table.HeaderCell>ID</Table.HeaderCell>
                            <Table.HeaderCell>NOME</Table.HeaderCell>
                        </Table.Row>
                    </Table.Header>

                    <Table.Body>
                        {grupos.map(grupo => this.rendergrupos(grupo))}
                    </Table.Body>
                </Table>
            </Container>
        )
    }

}

export default GrupoForm
