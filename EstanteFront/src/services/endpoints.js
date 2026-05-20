import api from './api.js'

export const listarLivros = (page, size) => api.get('', { params: { page, size } });

export const deletarLivroPorTitulo = (titulo) => api.delete('/delete', { data: { titulo } });

export const adicionarLivro = (livro) => api.post('/add', livro);

export const atualizarLivro = (livro) => api.put('/update', livro);

export const buscarLivroPorIsbn = (isbn) => api.get('/porIsbn', { params: { isbn } });

export const buscarUltimos3 = () => api.get('/ultimos3');
