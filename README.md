# 📗 Projeto Estante



## 🎯 Objetivo
  * Projeto pessoal para registrar minha coleção de livros.
  * Um software desenvolvido com Java, Springboot, MongoDB e Vue.JS (Esse ultimo ainda por fazer).
  * Objetivo final é ter uma aplicação web com as tecnologias citas acima rodando no ambiente da AWS e por fim funcionando com um aplicativo de Android também.

## 🧗🏻Até aqui...
  * Api com CRUD funcional e alguns tratamentos de erros, registrando os livros em um cluster remoto do MongoDB.
  * **GET(/livros)** -> Somente consulta de todos os livros cadastrados
  * **POST(/livros/post)** -> Body de exemplo:  
    <code>"isbn": "123456789012",  
      "titulo": "O Pequeno Príncipe",  
      "autor": "Antoine de Saint-Exupéry",  
      "editora": "",  
      "lancamento": "06/04/1943",  
      "paginas": "96"</code>
      * Somente ISBN e Titulo são obrigatorios.
  * **PUT (livros/update)** -> Recebe o mesmo body do post com as informações novas. Se baseia no ISBN para atualizar as informações.
  * **DELTE (livros/delete)** -> Recebe um body com titulo a ser excluido. Body de Exemplo: `"titulo": "Crepusculo"`

  * **Frontend finalizado**

## 🖥️ Proximos passos
  * Integração Frontend X API
  * Subir a aplicação para AWS.
  * Desenvolver o sistema de usuários com segurança.

