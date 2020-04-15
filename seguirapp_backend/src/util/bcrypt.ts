import bcrypt from 'bcryptjs'

function crypt(password: string) {
    return new Promise<string>(async (resolve, reject) => {
        try {

            const hash = await bcrypt.hash(password, 5);
            password = hash;

            resolve(password)
        } catch (error) {
            reject(error)
        }
    })
}

export default crypt