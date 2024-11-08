/**
 * Função que define a migração para a criação da tabela "usuarios".
 * @param { import("knex").Knex } knex - O objeto knex utilizado para interagir com o banco de dados.
 * @returns { Promise<void> } - Retorna uma Promise que resolve quando a operação de criação for concluída.
 */
exports.up = async function (knex) {
    // Criação da tabela "usuarios" com suas respectivas colunas
    await knex.schema.createTable("usuarios", table => {
        // Definindo a coluna 'id' como chave primária com auto incremento
        table.increments("id").primary()

        // Definindo a coluna 'nome' como string de até 255 caracteres e que não pode ser nula
        table.string("nome", 255).notNullable()

        // Definindo a coluna 'email' como string de até 255 caracteres, que não pode ser nula e deve ser única
        table.string("email", 255).notNullable().unique()

        // Definindo a coluna 'senha' como string de até 255 caracteres e que não pode ser nula
        table.string("senha", 255).notNullable()

        // Definindo a coluna 'perfil' como um número inteiro que não pode ser nulo
        table.integer("perfil").notNullable()

        // Definindo a coluna 'status' como string que não pode ser nula
        table.string("status").notNullable()

        // Definindo a coluna 'data_criacao' como um timestamp, com o valor padrão sendo a data e hora atuais
        table.timestamp("data_criacao").defaultTo(knex.fn.now())
    })
};

/**
 * Função que define a migração para a exclusão da tabela "usuarios".
 * @param { import("knex").Knex } knex - O objeto knex utilizado para interagir com o banco de dados.
 * @returns { Promise<void> } - Retorna uma Promise que resolve quando a operação de exclusão for concluída.
 */
exports.down = function (knex) {
    // Excluindo a tabela "usuarios"
    return knex.schema.dropTable("usuarios")
};
