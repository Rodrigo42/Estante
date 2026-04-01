<script setup>
import { ref } from 'vue';

</script>

<template>
    <div id="body-ultimos-add">
        <h2>Últimos Adicionados</h2>
        <ul>
            <li>Harry Potter e a volta dos que não foram</li>
            <li>Senhor dos aneis e o Boromir teria se jogado</li>
            <li>Como ler 3,4 livros por segundo</li>
            <li>5am club: Acorde as 5 da manhã e seja um otario desde cedo</li>
            <li>Cuscuz com Deus pai</li>
        </ul>
        
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

    #body-ultimos-add ul{
        list-style-type: none;
        padding-left: 0;
        display: flex;
        
    }

    #body-ultimos-add li{
        color: rgb(0, 0, 0);
        font-family: ubuntu;
        padding: 1em;
    }
</style>