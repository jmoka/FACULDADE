import mysql from 'mysql2';
import dotenv from 'dotenv'; // Importando dotenv usando ES Modules

dotenv.config(); // Carregando variáveis de ambiente 

export default {
  development: {
    client: "mysql2",
    connection: {
      host: process.env.DB_HOST, // ou 'localhost'
      user: process.env.DB_USER,
      password: process.env.DB_PASSWORD,
      database: process.env.DB_NAME,
    },
    migrations: {
      directory: './src/database/migrations'
    },
    seeds: {
      directory: './src/database/seeds'
    }
  },
  production: {
    client: "mysql2",
    connection: {
      host: process.env.DB_HOST, // ou 'localhost'
      user: process.env.DB_USER,
      password: process.env.DB_PASSWORD,
      database: process.env.DB_NAME,
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
