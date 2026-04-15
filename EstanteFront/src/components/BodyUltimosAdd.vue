<script setup>
import { ref } from 'vue';
import CardLivro from './CardLivro.vue';

</script>

<template>
    <div id="body-ultimos-add">
        <h2>Últimos Adicionados</h2>
        <CardLivro />
    </div>
</template>

<style scoped>
    #body-ultimos-add{
        background-color: #745F4C;
        margin-top: 1.5%;
        height: 10%;
        border-radius: 15px;
        padding: 1rem;
        display: flex;
        flex-direction: column;
        gap: 1rem;
        justify-content: center;
        align-items: center;
    }

    #body-ultimos-add h2{
        font-family: ubuntu;
        color: rgb(0, 0, 0);
    }

   
</style>