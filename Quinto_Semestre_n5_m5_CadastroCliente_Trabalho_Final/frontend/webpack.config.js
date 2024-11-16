// webpack.config.js
exports default = {
    entry: './src/index.js',  // Ponto de entrada do seu projeto
    output: {
      path: path.resolve(__dirname, 'dist'),
      filename: 'bundle.js',
    },
    module: {
      rules: [
        {
          test: /\.js$/, // Transpilar todos os arquivos .js
          exclude: /node_modules/, // Excluir node_modules
          use: {
            loader: 'babel-loader', // Usando Babel para transpilar o código
            options: {
              presets: ['@babel/preset-env'],  // Usando preset-env para JavaScript moderno
              plugins: [
                '@babel/plugin-proposal-optional-chaining',  // Suporte para operador de encadeamento opcional
                '@babel/plugin-proposal-nullish-coalescing-operator',  // Suporte para operador de coalescência nula
              ],
            },
          },
        },
      ],
    },
    resolve: {
      extensions: ['.js', '.graphql'],  // Suporte para .js e .graphql
    },
    devtool: 'source-map',  // Habilitar mapas de fontes para depuração
  };
  