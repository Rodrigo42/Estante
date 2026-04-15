<script setup>
    import { ref, onMounted } from 'vue';
    import { buscarUltimos3 } from '../services/endpoints.js';

    const livros = ref([]);
    const error = ref(null);

    async function fetchLivros() {
        error.value = null;

        try{
            const response = await buscarUltimos3();
            livros.value = response.data;
        }catch(e){
            console.error('Erro ao buscar os últimos livros:', e);
            alert('Ocorreu um erro ao buscar os últimos livros. Por favor, tente novamente.');
        }finally{
            console.log('Busca de livros finalizada');
        }
        
        
    }

    onMounted(fetchLivros);
</script>

<template>
    <div id="card-livro">
        <ul>
            <li v-for="livro in livros" :key="livro.isbn">
                <h4>titulo: {{ livro.titulo }}</h4>
                <h4>autor: {{ livro.autor }}</h4>
                <h4>editora: {{ livro.editora }}</h4>
                <h4>lancamento: {{ livro.lancamento }}</h4>
                <h4>paginas: {{ livro.paginas }}</h4>
            </li>
        </ul>
    </div>
</template>

<style scoped>
   #card-livro li{
        background-color: #ffffff3b;
        min-width: 30%;
        border-radius: 15px;
        align-items: left;
        border: black solid 1px;
        margin: 0.5rem;
        padding: 0.5rem;
    }


    #card-livro ul{
        list-style-type: none;
        padding-left: 0;
        display: flex;
    }


    #card-livro h3{
        font-family: ubuntu;
        color: rgb(0, 0, 0);
    }

    #card-livro h4{
        color: rgb(0, 0, 0);
        font-family: ubuntu;
    }
</style>