
package model;

import java.util.*;


public class AdministradorDao {
    
    private ClienteDao clienteDao;
    private CategoriaDao categoriaDao;
    private ProductoDao productoDao;
    
    public AdministradorDao() {
        clienteDao = new ClienteDao();
        categoriaDao = new CategoriaDao();
        productoDao = new ProductoDao();
    }
    
    // Métodos para gestionar clientes
    
    public boolean registerClienteQuery(Cliente cliente) {
        return clienteDao.registerClienteQuery(cliente);
    }
    
    public List<Cliente> listClienteQuery() {
        return clienteDao.listClienteQuery("");
    }
    
    public boolean updateClienteQuery(Cliente cliente) {
        return clienteDao.updateClienteQuery(cliente);
    }
    
    public boolean deleteCliente(int id) {
        return clienteDao.deleteClienteQuery(id);
    }
    
    // Métodos para gestionar categorías
    
    public boolean registerCategoriaQuery(Categoria categoria) {
        return categoriaDao.registerCategoriaQuery(categoria);
    }
    
    public List<Categoria> listCategoriaQuery() {
        return categoriaDao.listCategoriaQuery("");
    }
    
    public boolean updateCategoriaQuery(Categoria categoria) {
        return categoriaDao.updateCategoriaQuery(categoria);
    }
    
    public boolean deleteCategoriaQuery(int id) {
        return categoriaDao.deleteCategoriaQuery(id);
    }
    
    // Métodos para gestionar productos
    
    public boolean registerProductoQuery(Producto producto) {
        return productoDao.registerProductoQuery(producto);
    }
    
    public List<Producto> listProductoQuery() {
        return productoDao.listProductoQuery("");
    }
    
    public boolean updateProductoQuery(Producto producto) {
        return productoDao.updateProductoQuery(producto);
    }
    
    public boolean deleteProductoQuery(int id) {
        return productoDao.deleteProductoQuery(id);
    }
    
}
