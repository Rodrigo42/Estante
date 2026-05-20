<script setup>
    import { onMounted, ref } from 'vue';
    import { deletarLivroPorTitulo, listarLivros} from '../services/endpoints.js';
    import { useRouter } from 'vue-router';

    const livros = ref([])
    const loading = ref(false);
    const erro = ref(null);
    const router = useRouter();
    

    const currentPage = ref(0);
    const pageSize = ref(10);
    const totalPages = ref(0);



    async function fetchLivros(page = 0) {
        loading.value = true;
        erro.value = null;

        try{
            const response = await listarLivros(page, pageSize.value);
            livros.value= response.data.content;
            totalPages.value = response.data.totalPages;
            currentPage.value = page;
        }catch(e){
            erro.value = e?.response?.data?.['Erro: '] || 'Erro ao carregar livros'
        }
        finally{
            loading.value = false;
        }
    }
    
    async function deletarLivro(titulo){
        try{
            await deletarLivroPorTitulo(titulo)
            await fetchLivros()
        }catch(e){
            erro.value = e?.response?.data?.['Erro: '] || 'Erro ao deletar livro'
        }
    }

    async function alterarLivro(livro){
        try{
            router.push({
                name: 'EditarLivro',
                query: {
                    isbn: livro.isbn ?? '',
                    titulo: livro.titulo ?? '',
                    autor: livro.autor ?? '',
                    editora: livro.editora ?? '',
                    lancamento: livro.lancamento ?? '',
                    paginas: livro.paginas ?? ''
                }
            })
        
        }catch(e){
            erro.value = e?.response?.data?.['Erro: '] || 'Erro ao editar livro'
        }
    }

    const proximaPagina = () =>{
        if (currentPage.value < totalPages.value - 1){
            fetchLivros(currentPage.value + 1)
        }
    }

    const paginaAnterior = () => {
        if (currentPage.value > 0){
            fetchLivros(currentPage.value - 1)
        }
    }

    onMounted(fetchLivros)

</script>

<template>
      
        <div id="colecao">
            <div v-if="loading">Carregando livros...</div>
            <div v-else-if="erro">{{ erro }}</div>
            <div v-else>  
                <h2>Coleção</h2>
                <table>
                    <thead>
                        <tr>
                            <th>ISBN</th>
                            <th>Titulo</th>
                            <th>Autor</th>
                            <th>Editora</th>
                            <th>Lançamento</th>
                            <th>Paginas</th>
                            <th>X</th>
                            <th>O</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="livro in livros" :key="livro.isbn">
                            <td>{{ livro.isbn }}</td>
                            <td>{{ livro.titulo }}</td>
                            <td>{{ livro.autor }}</td>
                            <td>{{ livro.editora }}</td>
                            <td>{{ livro.lancamento }}</td>
                            <td>{{ livro.paginas }}</td>
                            <td id="td-button">
                                <button type="button" alt="Excluir" id="deletar-livro" @click="deletarLivro(livro.titulo)">Excluir</button>
                                
                            </td>
                            <td>
                                <button type="button" alt="Editar" id="editar-livro" @click="alterarLivro(livro)">Editar</button>
                            </td>
                        </tr>
                    </tbody>
                </table>

                <div id="pagination-controls">
                    <button 
                    type="button"
                    @click="paginaAnterior"
                    :disabled="currentPage === 0"
                    >← Anterior</button>
                    <span id="pagina-atual">Página {{ currentPage +1 }} de {{ totalPages }}</span>
                    <button 
                    type="button"
                    @click="proximaPagina"
                    :disabled="currentPage >= totalPages - 1"
                    >Próxima →</button>
                </div>
            </div>
        </div>
    
</template>

<style scoped>
    #colecao{
        background-color: #745F4C;
        margin-top: 1.5%;
        height: 10%;
        border-radius: 15px;
        padding: 1rem;
        display: flex;
        flex-direction: column;
        gap: 1rem;
        justify-content: center;
        align-items: left;
        
        
    }
    #colecao h2{
        font-family: ubuntu;
        color: rgb(0, 0, 0);
        text-align: center;
    }
    #colecao table{
        border-collapse: collapse;
        width: 100%;
        
    }
    #colecao td{
        border-bottom: 1px solid #000;
        padding: 8px;
        text-align: left;
        color: rgb(0, 0, 0);
        font-family: ubuntu;
    }
    #colecao th{
        border-bottom: 2px solid #000;
        padding: 8px;
        text-align: left;
        color: rgb(0, 0, 0);
        font-family: ubuntu;
    }
    #colecao tr:nth-child(even){
        background-color: #D9CFC1;
        
    }

    #colecao #deletar-livro{
        border-radius: 5px;
        border: none;
        background-color: #a31c1cf3;
        color: #fff;
        cursor: pointer;
    }

    #colecao #editar-livro{
        border-radius: 5px;
        border: none;
        background-color: #a18c13e1;
        color: #fff;
        cursor: pointer;
    }

     #pagination-controls {
        display: flex;
        justify-content: center;
        align-items: center;
        gap: 1rem;
        margin-top: 1rem;
    }

    #pagination-controls button {
        padding: 0.5rem 1rem;
        border-radius: 5px;
        border: none;
        background-color: #000000;
        color: #fff;
        cursor: pointer;
    }

    #pagination-controls button:disabled {
        background-color: #cccccc;
        cursor: not-allowed;
    }

    #page-info {
        color: rgb(0, 0, 0);
        font-family: ubuntu;
        font-weight: bold;
    }
</style>