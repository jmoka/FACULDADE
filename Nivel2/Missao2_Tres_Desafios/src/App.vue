<template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/ordenando">Ordenando</router-link>|
    <router-link to="/api">API</router-link>|
  </nav>
  <div>
    <router-view />
  </div>
</template>


<script>
import { defineComponent } from 'vue';
import { useRouter } from 'vue-router';

export default defineComponent({
  name: 'App',
  setup() {
    const router = useRouter();

    return {
      goToRoute(route) {
        router.push(route);
        location.reload();
      },
    };
  },
});
</script>






<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  
 
}

nav {
  padding: 10px;
  background-color:antiquewhite;

}

nav a {
  font-size: 30px;
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
