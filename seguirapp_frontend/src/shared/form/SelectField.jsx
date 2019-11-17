import React from 'react'
import If from '../if'
import { Form, Dropdown } from 'semantic-ui-react'

export const SelectField = props => {
    let fieldWithError, error

    // if(true){ //props.validate
    let { meta: { touched, warning }, width } = props
    error = props.meta.error
    fieldWithError = (touched && (error || warning) && !props.readOnly)

    return (
        <Form.Field width={width} error={fieldWithError}>

            <label>{props.label}</label>
            <Dropdown
                selection
                search
                searchInput={props.input.value}
                {...props.input}
                placeholder={props.placeholder || null}
                options={props.options} disabled={props.readOnly || false}
                value={props.input.value}
                autoFocus={props.focus || false}
                onChange={(param, data) => props.input.onChange(data.value)}
            />

            {fieldWithError ?
                <span className="fieldWithError">{error}</span>
                : null}
        </Form.Field>
    )
}