import mysql from 'mysql2';
export default {
  development: {
    client: 'mysql2',
    connection: {
      host: '127.0.0.1', // ou 'localhost'
      user: 'root',
      password: '123',
      database: 'baseCliente',
    },
    migrations: {
      directory: './src/database/migrations'
    },
    seeds: {
      directory: './src/database/seeds'
    }
  },
  production: {
    client: 'mysql2',
    connection: {
      host: '127.0.0.1', // ou 'localhost'
      user: 'root',
      password: '123',
      database: 'baseCliente',
      ssl: { rejectUnauthorized: false }
    },
    migrations: {
      directory: './src/database/migrations'
    },
    seeds: {
      directory: './src/database/seeds'
    }
  }
};
