//.eslintrc
module.exports = {
    root: true,
    env: {
        node: true,
        es6: true, // Adiciona suporte ao ES6
    },
    extends: [
        'plugin:vue/essential',
        'eslint:recommended',
    ],
    rules: {
        'no-console': process.env.NODE_ENV === 'production' ? 'error' : 'off',
        'no-debugger': process.env.NODE_ENV === 'production' ? 'error' : 'off',
    },
    parserOptions: {
        parser: '@babel/eslint-parser', // Usando o parser Babel para ES6
        ecmaVersion: 2020, // Configura o suporte ao ES6+ (use a versão que deseja)
        sourceType: 'module', // Permite importações ES6
    },
}
