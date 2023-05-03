
package model;

import java.sql.*;
import javax.swing.*;
import java.util.*;

public class CategoriaDao {
    //Instanciar la conexión
    Connection conexion;
    PreparedStatement pst;
    ResultSet rs;
    
    //Registrar categoria
    public boolean registerCategoriaQuery(Categoria categoria){
        String query ="INSERT INTO categoria (id , nombre, created, update) VALUES(?,?,?)";
        
        try{conexion = Connexion.getConnection();
        pst = conexion.prepareStatement(query);
        pst.setInt(1, categoria.getId());
        pst.setString(2, categoria.getNombre());
        pst.execute();
        return true;
        
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al registrar al cliente");
            return false;
        }
    
    }
    
    //Listar categoria
    public List listCategoriaQuery(String value){
        List<Categoria> list_categoria = new ArrayList();
        String query = "SELECT * FROM categoria";
        String query_search_categoria = "SELECT * FROM categoria WHERE id LIKE '%" + value + "%'";
        try {
            conexion = Connexion.getConnection();
            if (value.equalsIgnoreCase("")){
                pst = conexion.prepareStatement(query);
                rs = pst.executeQuery();
            }else{
                pst = conexion.prepareStatement(query_search_categoria);
                rs = pst.executeQuery();
            }
            
            while(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNombre(rs.getString("nombre"));
                list_categoria.add(categoria); 
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return list_categoria;
    }
    
    //Modificar categoria
    public boolean updateCategoriaQuery(Categoria categoria){
        String query = "UPDATE categoria SET nombre = ? WHERE id =?";
        
        try{
            conexion = Connexion.getConnection();
            pst = conexion.prepareStatement(query);
            pst.setString(1, categoria.getNombre());
            pst.setInt(2, categoria.getId());
            pst.execute();
            return true;
        
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al modificar los datos de la categoria");
            return false;
        }
    
    }

    //Eliminar categoria
    public boolean deleteCategoriaQuery(int id){
        String query = "DELETE FROM categoria WHERE id =" + id;
        
        try{
            conexion = Connexion.getConnection();
            pst = conexion.prepareStatement(query);
            pst.execute();
            return true;    
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "No puedes eliminar una categoria que tenga relación con otra tabla");
            return false;    
        }
    }


}

