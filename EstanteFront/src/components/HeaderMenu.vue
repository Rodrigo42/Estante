<script setup>
    import { ref } from 'vue';
    
    const menuAbert = ref(false);

    const toggleMenu = () => {
        menuAbert.value = !menuAbert.value;
    }
</script>

<template>
    <div id="header-menu">
        <button id="hamb-menu" type="button" @click="toggleMenu">
        <span></span>
        <span></span>
        <span></span>
        </button>

        <div id="titulo">
            Estante
        </div>

        <nav v-if="menuAbert" id="menu">
        <a href="#">Coleção</a>
        <a href="#">Adicionar</a>
        <a href="#">Editar</a>
        <a href="#">Excluir</a>
        <a href="#">Sair</a>
        </nav>
    </div>

    
</template>

<style scoped>
    

    #header-menu{
        background-color: #745F4C;
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: space-between;
        margin-top: 1.5%;
        height: 4rem;
        border-radius: 15px;
        position: relative;
    }
    #titulo{
        font-family: ubuntu;
        font-size: larger;
        position: absolute;  
        left: 50%;
        transform: translateX(-50%);
    }
    #hamb-menu {
        width: 2rem;
        height: 1.5rem;
        border: none;
        background: transparent;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        padding: 0;
        cursor: pointer;
        margin-left: 2em;
    }
    #hamb-menu span {
    display: block;
    height: 4px;
    width: 100%;
    background: #000000;
    border-radius: 2px;
    }

    #menu {
    position: absolute;
    top: calc(100% + 8px);
    left: 0;
    background: #745F4C;
    border-radius: 10px;
    border-color: #000000;
    border-style: outset;
    padding: 1rem;
    display: flex;
    flex-direction: column;
    gap: 1rem;
    }

    #menu a {
    color: rgb(0, 0, 0);
    text-decoration: none;
    padding: 0.4rem 0.6rem;
    }


</style>