
package model;

import java.sql.*;
import javax.swing.*;
import java.util.*;

public class ProductoDao {
    
    //Instanciar la conexión
    Connection conexion;
    PreparedStatement pst;
    ResultSet rs; 
    
    //Registrar producto
    public boolean registerProductoQuery(Producto producto){
      String query = "INSERT INTO producto (id, codigo, nombre, descripcion, precio, categoria_id) VALUES (?,?,?,?,?,?)";  
      
      try{
          conexion = Connexion.getConnection();
          pst = conexion.prepareStatement(query);
          pst.setInt(1, producto.getId());
          pst.setInt(2,producto.getCodigo());
          pst.setString(3,producto.getNombre());
          pst.setString(4,producto.getDescripcion());
          pst.setDouble(5, producto.getPrecio());
          pst.setInt(6, producto.getCategoria_id());
          pst.execute();
          return true;
         
      }catch(SQLException e){
          JOptionPane.showMessageDialog(null,"Error al registrar el producto");
      return false;
      }
    }
    
    //Listar producto
    public List listProductoQuery(String value){
        List<Producto> list_Producto = new ArrayList();
        String query = "SELECT pro.*, ca.nombre as categoria_nombre FROM producto pro, categoria ca where pro.categoria_id = ca.id";
        String query_search_producto = "SELECT pro.*, ca.nombre as categoria_nombre FROM producto pro INNER JOIN categoria ca ON pro.categoria_id = ca.id WHERE pro.nombre LIKE '%" + value + "%'";
    
        try{
            conexion = Connexion.getConnection();
            if (value.equalsIgnoreCase("")){
                pst = conexion.prepareStatement(query);
                rs = pst.executeQuery();
            }else{
                pst = conexion.prepareStatement(query_search_producto);
                rs = pst.executeQuery();
            }
            
            while(rs.next()){
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setCodigo(rs.getInt("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCategoria_nombre(rs.getString("categoria_nombre"));                    
                list_Producto.add(producto);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return list_Producto;
        } 
    
    //Modificar producto
    public boolean updateProductoQuery(Producto producto){
        String query = "UPDATE producto SET codigo = ?, nombre = ?, descripcion = ?, precio = ?, categoria_id = ?"
                + "WHERE ID = ?";
        
        try {
            conexion = Connexion.getConnection();
            pst = conexion.prepareStatement(query);
            pst.setInt(1,producto.getCodigo());
            pst.setString(2,producto.getNombre());
            pst.setString(3,producto.getDescripcion());
            pst.setDouble(4, producto.getPrecio());
            pst.setInt(5, producto.getCategoria_id());
            pst.setInt(6, producto.getId());
            pst.execute();
            return true;
            
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos del producto");
            return false;
            }   
    }
    
    //Eliminar cliente
    public boolean deleteProductoQuery(int id){
        String query = "DELETE FROM producto WHERE id =" + id;
        
        try{
            conexion = Connexion.getConnection();
            pst = conexion.prepareStatement(query);
            pst.execute();
            return true;    
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "No puedes eliminar un producto que tenga relación con otra tabla");
            return false;    
        }
    }
      
}
