<script setup>
    import { onMounted, ref } from 'vue';
    import { atualizarLivro } from '../services/endpoints.js';
    import { buscarLivroPorIsbn } from '../services/endpoints.js';
    import { useRoute } from 'vue-router';

    const isbn = ref('');
    const titulo = ref('');
    const autor = ref('');
    const editora = ref('');
    const lancamento = ref('');
    const paginas = ref('');
    const route = useRoute();

    const editarLivro = async () => {
        const livro = {
            isbn: isbn.value,
            titulo: titulo.value,
            autor: autor.value,
            editora: editora.value,
            lancamento: lancamento.value,
            paginas: paginas.value
        };

        try {
            await atualizarLivro(livro);
            alert('Livro atualizado com sucesso!');
            // Limpar os campos após a atualização
            isbn.value = '';
            titulo.value = '';
            autor.value = '';
            editora.value = '';
            lancamento.value = '';
            paginas.value = '';
        } catch (error) {
            console.error('Erro ao atualizar livro:', error);
            alert('Ocorreu um erro ao atualizar o livro. Por favor, tente novamente.');
        }
    };

    const buscarLivro = async () => {
        try {
            const response = await buscarLivroPorIsbn(isbn.value);
            const livro = response.data;
            titulo.value = livro.titulo;
            autor.value = livro.autor;
            editora.value = livro.editora;
            lancamento.value = livro.lancamento;
            paginas.value = livro.paginas;

            


        } catch (error) {
            console.error('Erro ao buscar livro:', error);
            alert('Ocorreu um erro ao buscar o livro. Por favor, tente novamente.');
        }
    };

    onMounted(() => {
        const query = route.query;
        isbn.value = query.isbn || '';
        titulo.value = query.titulo || '';
        autor.value = query.autor || '';
        editora.value = query.editora || '';
        lancamento.value = query.lancamento || '';
        paginas.value = query.paginas || '';
    });

</script>

<template>
    <div id="editar-livro">
        <h2>Editar Livro</h2>
        <h3>Preencha o titulo para buscar as informações do livro</h3>
        <form @submit.prevent="editarLivro">
            <div class="campo">
            <label class="" for="isbn">ISBN:</label>
            <input type="text" id="isbn" name="isbn" v-model="isbn" required>
            </div>

            <div class="campo">
            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo" v-model="titulo" required>
            </div>

            <div class="campo">
            <label for="autor">Autor:</label>
            <input type="text" id="autor" name="autor" v-model="autor">
            </div>

            <div class="campo">
            <label for="editora">Editora:</label>
            <input type="text" id="editora" name="editora" v-model="editora">
            </div>

            <div class="campo">
            <label for="lacamento">Lançamento:</label>
            <input type="date" id="lancamento" name="lancamento" v-model="lancamento">
            </div>

            <div class="campo">
            <label for="paginas">Páginas:</label>
            <input type="number" id="paginas" name="paginas" v-model="paginas">
            </div>
        </form>
        <div id="button">
            <button type="submit" @click="editarLivro(livro)">Editar</button>
            <button type="button" @click="buscarLivro(isbn)">Buscar</button>
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