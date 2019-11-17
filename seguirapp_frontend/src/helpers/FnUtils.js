import VMask from 'vanilla-masker'

export const cpfLabel = (value) => {
    return VMask.toPattern(value, '999.999.999-99')
}

export const celularLabel = (value) => {
    if (!value) return null;
    value = value.replace(/^55/, '')
    value = removeNoNumeric(value)
    if (value.length == 11) return VMask.toPattern(value, '(99) 9 9999-9999')
    return VMask.toPattern(value, '(99) 9999-9999')
}

export const validatePhoneBr = (phone) => {
    phone = removeNoNumeric(phone)
    return /(^|\()?\s*(\d{2})\s*(\s|\))*(9?\d{4})(\s|-)?(\d{4})($|\n)/.test(phone) ? undefined : "Número inválido" // obrigatorio ter ddd
}

export const validateCpf = (cpf) => {
    if (cpf === null || cpf === undefined || cpf === NaN) return false
    cpf = removeNoNumeric(cpf)
    var numeros, digitos, soma, i, resultado, digitos_iguais;
    digitos_iguais = 1;
    if (cpf.length < 11)
        return "CPF inválido"
    for (i = 0; i < cpf.length - 1; i++)
        if (cpf.charAt(i) != cpf.charAt(i + 1)) {
            digitos_iguais = 0;
            break;
        }
    if (!digitos_iguais) {
        numeros = cpf.substring(0, 9);
        digitos = cpf.substring(9);
        soma = 0;
        for (i = 10; i > 1; i--)
            soma += numeros.charAt(10 - i) * i;
        resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
        if (resultado != digitos.charAt(0))
            return "CPF inválido"
        numeros = cpf.substring(0, 10);
        soma = 0;
        for (i = 11; i > 1; i--)
            soma += numeros.charAt(11 - i) * i;
        resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
        if (resultado != digitos.charAt(1))
            return "CPF inválido"
        return undefined
    } else
        return undefined
}

export const requiredValidate = (value = null) => {
    if (value === null || value === "" || value === undefined) return 'Obrigatório'
    if (value.toString().trim() === "") return 'Obrigatório'
    return undefined
}

export const removeNoNumeric = (val) => {
    if (val === undefined || val === null) return val
    return val.toString().replace(/[^\d]+/g, '')
}