// babel.config.js ou nuxt.config.js
export default {
    presets: [
      ['@babel/preset-env', {
        targets: '> 0.25%, not dead',  // Define os alvos dos navegadores, para que o Babel transpile conforme necessário
        useBuiltIns: 'entry',  // Garante que o Babel carregue os polyfills necessários
        corejs: 3,  // Especifica a versão do CoreJS a ser usada
      }],
    ],
    plugins: [
      '@babel/plugin-proposal-optional-chaining',  // Suporte para o operador de encadeamento opcional (?.)
      '@babel/plugin-proposal-nullish-coalescing-operator',  // Suporte para o operador de coalescência nula (??)
    ],
  };
  