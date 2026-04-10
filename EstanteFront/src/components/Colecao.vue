<script setup>
    import { onMounted, ref } from 'vue';
    import { deletarLivroPorTitulo, listarLivros} from '../services/endpoints.js';
    import { useRouter } from 'vue-router';

    const livros = ref([])
    const loading = ref(false);
    const erro = ref(null);
    const router = useRouter();
    

    async function fetchLivros() {
        loading.value = true;
        erro.value = null;

        try{
            const response = await listarLivros()
            livros.value= response.data
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
</style>