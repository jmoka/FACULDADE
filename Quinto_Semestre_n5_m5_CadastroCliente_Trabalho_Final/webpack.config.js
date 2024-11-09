const path = require('path');

module.exports = {
    entry: './src/index.js',  // Altere conforme o ponto de entrada do seu projeto
    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'bundle.js',
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',  // Usando Babel para transpilação
                },
            },
        ],
    },
    resolve: {
        extensions: ['.js', '.graphql'],
    },
};
