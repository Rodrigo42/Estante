<script setup>
import { ref } from 'vue';

</script>

<template>
    <div id="colecao">
        <h2>Coleção</h2>
        <table>
            <tr>
                <td>ISBN</td>
                <td>Titulo</td>
                <td>Autor</td>
                <td>Editora</td>
                <td>Lançamento</td>
                <td>Paginas</td>
            </tr>
            <tr>
                <td>978-3-16-148410-0</td>
                <td>Harry Potter e a volta dos que não foram</td>
                <td>J.K. Rowling</td>
                <td>Rocco</td>
                <td>2007</td>
                <td>500</td>
            </tr>
            <tr>
                <td>978-1-23-456789-0</td>
                <td>Senhor dos aneis e o Boromir teria se jogado</td>
                <td>J.R.R. Tolkien</td>
                <td>Martins Fontes</td>
                <td>1954</td>
                <td>1200</td>
            </tr>
            <tr>
                <td>978-0-12-345678-9</td>
                <td>Como ler 3,4 livros por segundo</td>
                <td>John Doe</td>
                <td>Self-Published</td>
                <td>2020</td>
                <td>200</td>
            </tr>
            <tr>
                <td>978-9-87-654321-0</td>
                <td>5am club: Acorde as 5 da manhã e seja um otario desde cedo</td>
                <td>Robin Sharma</td>
                <td>BestSeller</td>
                <td>2018</td>
                <td>300</td>
            </tr>
            
        </table>
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
        align-items: center;
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
    #colecao tr:nth-child(even){
        background-color: #D9CFC1;
        
    }
</style>