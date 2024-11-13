<template>
  <v-container fluid fill-height>
    <div class="pa-4 text-center">
      <v-dialog v-model="dialog" max-width="600">
        <v-card prepend-icon="mdi-account" title="User Profile">
          <v-card-text>
            <v-row dense>
              <v-col cols="12" md="4" sm="6">
                <v-text-field label="First name*" required></v-text-field>
              </v-col>

              <v-col cols="12" md="4" sm="6">
                <v-text-field label="Middle name" hint="example of helper text only on focus"></v-text-field>
              </v-col>

              <v-col cols="12" md="4" sm="6">
                <v-text-field label="Last name*" persistent-hint required></v-text-field>
              </v-col>

              <v-col cols="12" md="4" sm="6">
                <v-text-field label="Email*" required></v-text-field>
              </v-col>

              <v-col cols="12" md="4" sm="6">
                <v-text-field label="Password*" type="password" required></v-text-field>
              </v-col>

              <v-col cols="12" md="4" sm="6">
                <v-text-field label="Confirm Password*" type="password" required></v-text-field>
              </v-col>

              <v-col cols="12" sm="6">
                <v-select :items="['0-17', '18-29', '30-54', '54+']" label="Age*" required></v-select>
              </v-col>

              <v-col cols="12" sm="6">
                <v-autocomplete :items="['Skiing', 'Ice hockey', 'Soccer', 'Basketball', 'Hockey', 'Reading', 'Writing', 'Coding', 'Basejump']" label="Interests" auto-select-first multiple></v-autocomplete>
              </v-col>
            </v-row>

            <small class="text-caption text-medium-emphasis">*indicates required field</small>
          </v-card-text>

          <v-divider></v-divider>

          <v-card-actions>
            <v-spacer></v-spacer>

            <v-btn text variant="plain" @click="dialog = false">Close</v-btn>

            <v-btn color="primary" text variant="tonal" @click="dialog = false">Save</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </div>

    <v-row justify="center" align="center" class="fill-height">
      <v-col cols="12" md="6">
        <v-card>
          <v-card-title class="text-h5 ml-2">Login</v-card-title>
          <v-card-text>
            <!-- Formulário de login -->
            <v-form ref="form" v-model="valid">
              <!-- Campo de Email -->
              <v-text-field
              autocomplete="off"
                v-model="email"
                label="Email"
                type="email"
                :rules="[rules.required, rules.email]"
                :error-messages="emailErrors"
                required
                class="ml-2"
              ></v-text-field>

              <!-- Campo de Senha -->
              <v-text-field
              autocomplete="off"
                v-model="password"
                label="Senha"
                type="password"
                :rules="[rules.required, rules.password]"
                :error-messages="passwordErrors"
                required
                class="ml-2"
              ></v-text-field>
              <btn color="primary" @btnAcao="login" :nome="logar"></btn>
              <btn color="primary" @btnAcao="openRegisterDialog" :nome="Cadastrar" class="ml-2"></btn>
              <btn color="red" @btnAcao="sair" :nome="Sair" class="ml-2"></btn>
              
            </v-form>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import btn from "../componets/btns/btn.vue"
export default {
  components:{
    btn
  },
  data() {
    return {
      logar:"Logar",
      Cadastrar:"Cadastrar",
      Sair:"sair",
      dialog: false, // Controls visibility of the modal dialog
      email: '',
      password: '',
      valid: false,
      emailErrors: [],
      passwordErrors: [],
      rules: {
        required: (value) => !!value || 'Este campo é obrigatório.',
        email: (value) =>
          /.+@.+\..+/.test(value) || 'Por favor, insira um e-mail válido.',
        password: (value) =>
          value.length >= 6 || 'A senha deve ter pelo menos 6 caracteres.',
      },
    };
  },
  methods: {
    // Função para simular login
    login() {
      console.log("Chamou login");
      
      if (this.$refs.form.validate()) {
        // Lógica de autenticação (exemplo)
        console.log('Login bem-sucedido', this.email, this.password);
        // Limpar campos após login
        this.email = '';
        this.password = '';
        this.$emit('login', { email: this.email });
      }
    },
    // Função para registrar novo usuário (apenas exemplo)
    openRegisterDialog() {
      this.dialog = true; // Show the dialog when clicking on "Cadastrar"
    },
    // Função para logout
    sair() {
      this.email = '';
      this.password = '';
      console.log('Usuário deslogado');
    },
  },
};
</script>

<style scoped>
.v-btn {
  width: 100%;
  margin-top: 10px;
}
.v-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh; /* Garante que ocupe 100% da altura da tela */
}

.v-row {
  width: 100%; /* Garante que a linha ocupe 100% da largura */
}
</style>
