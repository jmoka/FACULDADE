// nuxt.config.js
export default {
  buildModules: [
    '@nuxtjs/vuetify',  // Adicionando Vuetify
  ],
  
  css: [
    'vuetify/dist/vuetify.min.css',  // CSS do Vuetify
  ],

  // plugins: [
  //   './plugins/vuetify.js',
  // ],

  vuetify: {
    theme: {
      dark: false,  // Modo claro
      themes: {
        light: {
          primary: '#1976D2',
          secondary: '#424242',
          accent: '#82B1FF',
        },
      },
    },
  },

  // build: {
  //   babel: {
  //     presets: [
  //       ['@babel/preset-env', {
  //         targets: '> 0.25%, not dead',
  //         useBuiltIns: 'entry',
  //         corejs: 3,  // Defina o corejs que será utilizado
  //       }],
  //     ],
  //     plugins: [
  //       '@babel/plugin-proposal-optional-chaining',
  //       '@babel/plugin-proposal-nullish-coalescing-operator',
  //     ],
  //   },
  // },
};
