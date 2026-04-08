<script setup>
  import { ref } from 'vue'
  import HeaderMenu from './components/HeaderMenu.vue';
  import BodyUltimosAdd from './components/BodyUltimosAdd.vue';
  import Colecao from './components/Colecao.vue';
  import CadastroLivro from './components/CadastroLivro.vue';
  import EditarLivro from './components/EditarLivro.vue';
  </script>

<template>
  <HeaderMenu/>
  <router-view/>
</template>

<style scoped>
  
</style>
