<script setup>
    import { ref } from 'vue';
</script>

<template>
    <div id="editar-livro">
        <h2>Editar Livro</h2>
        <h3>Preencha o titulo para buscar as informações do livro</h3>
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
        <div id="button">
            <button type="submit">Editar</button>
            <button type="button">Buscar</button>
        </div>
    </div>
</template>

<style scoped>
    #editar-livro{
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

    #editar-livro label{
        font-family: ubuntu;
        color: rgb(0, 0, 0);
        padding-right: .5em;
    }
    #editar-livro input{
        width: 100%;
    }
    #editar-livro h2{
        font-family: ubuntu;
        color: rgb(0, 0, 0);
    }

    #editar-livro form{
        display: flex;
        flex-direction: column;
        gap: 0.5rem;
    }

    #editar-livro label{
        font-family: ubuntu;
        color: rgb(0, 0, 0);
    }

    #editar-livro input{
        padding: 0.5rem;
        border-radius: 5px;
        border: none;
    }
    
    #editar-livro button{
        padding: 0.5rem 1rem;
        border-radius: 5px;
        border: none;
        background-color: #000000;
        color: #fff;
        cursor: pointer;
    }
    #button{
        display: flex;
        gap: 1rem;
    }
</style>