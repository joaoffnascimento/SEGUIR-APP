import React from 'react'
import { Form } from "semantic-ui-react"

export const TextField = props => {

    // const { meta: { touched, error, warning }, maxLength, className } = props
    // const fieldWithError = (touched && (error || warning) && !props.readOnly)
    return (
        <Form.Field>
            <Form.Input
                required={props.required}
                label={props.label}
                type={props.type}
                placeholder={props.placeholder}
                {...props.input}
            />
            {/* <If test={fieldWithError}>
                <span className="fieldWithError">{error}</span>
            </If> */}
        </Form.Field>
    )
}