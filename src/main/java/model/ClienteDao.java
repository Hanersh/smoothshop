
package model;

import java.sql.*;
import javax.swing.*;
import java.util.*;

public class ClienteDao {
    //Instanciar la conexión
    Connection conexion;
    PreparedStatement pst;
    ResultSet rs;   
    
    //Registrar cliente
    public boolean registerClienteQuery(Cliente cliente){
        String query = "INSERT INTO cliente (id, documento, nombre, apellido, correo, telefono, password)"
                + "VALUES (?,?,?,?,?,?,?)";
        
        try {
    conexion = Connexion.getConnection();
    pst = conexion.prepareStatement(query);
    pst.setInt(1, cliente.getId());
    pst.setString(2, cliente.getDocumentos());
    pst.setString(3, cliente.getNombre());
    pst.setString(4, cliente.getApellido());
    pst.setString(5, cliente.getCorreo());
    pst.setString(6, cliente.getTelefono());
    pst.setString(7, cliente.getPassword());
    pst.execute();
    return true;
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar al cliente");
            return false;

            }   
        }
    
    //Listar cliente
    public List listClienteQuery(String value){
        List<Cliente> list_Cliente = new ArrayList(); 
        String query = "SELECT * FROM cliente"; 
        String query_search_cliente = "SELECT * FROM cliente WHERE id LIKE '%" + value + "%'";
        try {
            conexion = Connexion.getConnection();
            if (value.equalsIgnoreCase("")){
                pst = conexion.prepareStatement(query);
                rs = pst.executeQuery();
            }else{
                pst = conexion.prepareStatement(query_search_cliente);
                rs = pst.executeQuery();
            }
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setDocumento(rs.getString("documento"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setPassword(rs.getString("password"));
                list_Cliente.add(cliente); 
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return list_Cliente;
    }

    //Modificar cliente
    public boolean updateClienteQuery(Cliente cliente){
        String query = "UPDATE cliente SET documento = ?, nombre = ?, apellido = ?, correo = ?, telefono = ?, password = ? "
                + "WHERE ID = ?";
        
        try {
            conexion = Connexion.getConnection();
            pst = conexion.prepareStatement(query);
            pst.setString(1, cliente.getDocumentos());
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getApellido());
            pst.setString(4, cliente.getCorreo());
            pst.setString(5, cliente.getTelefono());
            pst.setString(6, cliente.getPassword());
            pst.setInt(7, cliente.getId());
            pst.execute();
            return true;
            
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos del cliente");
            return false;
            }   
    }
    
    //Eliminar cliente
    public boolean deleteClienteQuery(int id){
        String query = "DELETE FROM cliente WHERE id =" + id;
        
        try{
            conexion = Connexion.getConnection();
            pst = conexion.prepareStatement(query);
            pst.execute();
            return true;    
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "No puedes eliminar un cliente que tenga relación con otra tabla");
            return false;    
        }
    }
     
}   
      


            
  