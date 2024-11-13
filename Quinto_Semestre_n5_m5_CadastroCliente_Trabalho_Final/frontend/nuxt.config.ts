// https://nuxt.com/docs/api/configuration/nuxt-config


// Nuxt config file
import { defineNuxtConfig } from 'nuxt/config'

export default defineNuxtConfig({

  compatibilityDate: '2024-04-03',
  devtools: { enabled: true },
  modules: [
    'vuetify-nuxt-module'
  ],
  vuetify: {
    moduleOptions: {
      /* module specific options */
    },
    vuetifyOptions: {
      /* vuetify options */
    }
  }
})