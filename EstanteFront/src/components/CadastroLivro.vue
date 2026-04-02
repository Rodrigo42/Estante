<script setup>
import { ref } from 'vue';
</script>

<template>
    <div id="cadastro-livro">
        <h2>Cadastro de Livro</h2>
        <form>
            <div class="campo">
            <label class="" for="isbn">ISBN:</label>
            <input type="text" id="isbn" name="isbn" required>
            </div>

            <div class="campo">
            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo" required>
            </div>

            <div class="campo">
            <label for="autor">Autor:</label>
            <input type="text" id="autor" name="autor">
            </div>

            <div class="campo">
            <label for="editora">Editora:</label>
            <input type="text" id="editora" name="editora">
            </div>

            <div class="campo">
            <label for="lacamento">Lançamento:</label>
            <input type="date" id="lancamento" name="lancamento">
            </div>

            <div class="campo">
            <label for="paginas">Páginas:</label>
            <input type="number" id="paginas" name="paginas">
            </div>
        </form>

        <button type="submit">Cadastrar</button>
    </div>
</template>

<style scoped>
    #cadastro-livro{
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

    #cadastro-livro label{
        font-family: ubuntu;
        color: rgb(0, 0, 0);
        padding-right: .5em;
    }
    #cadastro-livro input{
        width: 100%;
    }
    #cadastro-livro h2{
        font-family: ubuntu;
        color: rgb(0, 0, 0);
    }

    #cadastro-livro form{
        display: flex;
        flex-direction: column;
        gap: 0.5rem;
    }

    #cadastro-livro label{
        font-family: ubuntu;
        color: rgb(0, 0, 0);
    }

    #cadastro-livro input{
        padding: 0.5rem;
        border-radius: 5px;
        border: none;
    }
    
    #cadastro-livro button{
        padding: 0.5rem 1rem;
        border-radius: 5px;
        border: none;
        background-color: #000000;
        color: #fff;
        cursor: pointer;
    }
</style>