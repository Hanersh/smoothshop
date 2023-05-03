

package com.mycompany.sistemagestion;

import java.util.List;
import model.Cliente;
import model.ClienteDao;


public class SistemaGestion {

    public static void main(String[] args) {
  
    // Crear una instancia de ClienteDao
        ClienteDao clienteDao = new ClienteDao();
        
        // Llamar al método listClienteQuery para obtener la lista de clientes
        List<Cliente> listaClientes = clienteDao.listClienteQuery("");
        
        // Imprimir los datos de los clientes en la consola
        for (Cliente cliente : listaClientes) {
            System.out.println("ID: " + cliente.getId());
            System.out.println("Documento: " + cliente.getDocumentos());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Apellido: " + cliente.getApellido());
            System.out.println("Correo: " + cliente.getCorreo());
            System.out.println("Telefono: " + cliente.getTelefono());
            System.out.println("Password: " + cliente.getPassword());
            System.out.println("------------------------");
        
    }
        }
}
