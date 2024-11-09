import dotenv from 'dotenv';
dotenv.config(); // Carregar variáveis de ambiente

export const config = {
  development: {
    client: 'mysql2',
    connection: {
      host: '127.0.0.1',
      user: 'root',
      password: '12345678',
      database: 'baseCliente',
      port: '3306',
    },
  },
  production: {
    client: 'mysql2',
    connection: {
      host: '127.0.0.1',
      user: 'root',
      password: '123',
      database: 'baseCliente',
      port: '3306',
      ssl: { rejectUnauthorized: false },
    },
  },
};
