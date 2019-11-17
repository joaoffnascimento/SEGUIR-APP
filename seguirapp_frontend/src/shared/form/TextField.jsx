import React from 'react'
import { Form } from "semantic-ui-react"
import If from '../if'

export const TextField = props => {

    const { meta: { touched, error, warning }, maxLength, className } = props
    const fieldWithError = (touched && (error || warning) && !props.readOnly)
    return (
        <Form.Field>
            <Form.Input
                error={fieldWithError}
                label={props.label}
                placeholder={props.placeholder}
                type={props.type || 'text'} {...props.input} maxLength={maxLength} />
            <If test={fieldWithError}>
                <span className="fieldWithError">{error}</span>
            </If>
        </Form.Field>
    )
}