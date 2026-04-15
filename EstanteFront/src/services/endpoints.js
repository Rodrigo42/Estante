import api from './api.js'

export const listarLivros = () => api.get('');

export const deletarLivroPorTitulo = (titulo) => api.delete('/delete', { data: { titulo } });