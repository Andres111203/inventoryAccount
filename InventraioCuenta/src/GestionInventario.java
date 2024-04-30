import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class GestionInventario {

    ArrayList <Inventario> arregloInv = new ArrayList<>();
    Inventario producto;
    int i = 0;

    public void agregar_Producto(){
        producto  = new Inventario();
        String nombre = "";
        int codigo = 0;
        int cantidad = 0;
        while(true){
            try{

                nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
                if(!nombre.matches("[a-zA-Z]+")){

                    throw new ExceptionCadena("cadena invalida, solo letras");
                }    
                codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del producto"));
                cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del producto"));
                
                

                
                break;
                

            }catch(ExceptionCadena e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            catch(NumberFormatException e){
                String advertencia = "tipo de dato invalido\ningrese los datos nuevamente";
                JOptionPane.showMessageDialog(null, advertencia);
            }catch(Exception e){
                String advertencia = "tipo de dato invalido\ningrese los datos nuevamente";
                JOptionPane.showMessageDialog(null, advertencia);
            }
        
        
        }
        producto.setNombre(nombre);
        producto.setCodigoProducto(codigo);
        producto.setCantidad(cantidad);
        arregloInv.add(producto);

    }
    

    public void eliminarProducto(){
        boolean existeCodigo = false;
        boolean existeNombre = false;

        if(arregloInv.isEmpty()){

            JOptionPane.showMessageDialog(null, "el inventario está vacío");
        }else{
        
            while(true){
                try{
                    
                    String nomP = JOptionPane.showInputDialog("ingrese el nombre del producto a eliminar");
                    if(!nomP.matches("[a-zA-Z]+")){
                        throw new ExceptionCadena("dato incorrecto, solo letras");
                    }
                    
                    for(Inventario inv: arregloInv){

                        if(nomP.equalsIgnoreCase(inv.getNombre())){
                            existeNombre = true;
                        }
                    }
                    if(!existeNombre){
                        throw new ExceptionName("el nombre de producto ingresado no existe en el inventario");
                    }
                    int codPr = Integer.parseInt(JOptionPane.showInputDialog("ingrese el codigo del producto a eliminar"));
                    Inventario producto_a_eliminar = null;
                    for(Inventario inv: arregloInv){

                        if(inv.getCodigoProducto() == codPr){

                            producto_a_eliminar = inv;
                            existeCodigo = true;
                            
                        }
                    }
                    if(producto_a_eliminar !=null){
                        arregloInv.remove(producto_a_eliminar);
                        break;
                    }
                    if(!existeCodigo){
                        throw new ExceptionCode("el codigo no existe en el inventario");
                    }
                    }catch(ExceptionCode e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    catch (ExceptionName e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());

                    }catch(ExceptionCadena e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    
                    }catch(InputMismatchException e){
                        JOptionPane.showMessageDialog(null, "tipo de dato no valido");

                    }catch(NumberFormatException e){
                        System.out.println("los datos ingresados no pertenecen al tipo de datos solicitado");
                    }
                    catch(Exception e){
                        System.out.println("error en los datos ingresados");
                    }

                    
                }
        }
        
    }

    public void getProductos() { 

        if(arregloInv.isEmpty()){
            JOptionPane.showMessageDialog(null ,"el inventario está vacío", "INVENTARIO", JOptionPane.WARNING_MESSAGE);
        }else{
        for(Inventario inven: arregloInv){

            JOptionPane.showConfirmDialog(null, producto.getCodigoProducto(), "Producto", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showConfirmDialog(null, producto.getNombre(), "Nombre", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showConfirmDialog(null, producto.getCantidad(), "Cantidad", JOptionPane.INFORMATION_MESSAGE);
            }
        
        }
    }

    public void buscarProductoEspecifico(){

        if(arregloInv.isEmpty()){

            JOptionPane.showMessageDialog(null, "el inventario está vacío");
            
        }else{

            while(true){
                try{
                    boolean existenomPr = false;
                    boolean existecodPr = false;
                    String nomProd = JOptionPane.showInputDialog("ingrese el nombre del producto a buscar");
                    if(!nomProd.matches("[a-zA-Z]+")){
                        throw new ExceptionCadena("cadena invalida, solo letras");
                    }
                    
                    for(Inventario inv: arregloInv){

                        if(nomProd.equalsIgnoreCase(inv.getNombre())){
                            existenomPr = true;
                        }
                    }
                    if(!existenomPr){
                        throw new ExceptionName("el nombre de producto ingresado no existe en el inventario");
                    }

                    int codPr = Integer.parseInt(JOptionPane.showInputDialog("ingrese el codigo del producto a buscar"));

                    for(Inventario inv: arregloInv){

                        if(codPr == inv.getCodigoProducto()){
                            existecodPr = true;
                        }
                    }
                    
                    if(!existecodPr){
                        throw new ExceptionCode("el codigo no existe en el inventario");
                    }

                    if(existecodPr && existenomPr){

                        Inventario prodEncontrado = null;
                        for(Inventario producto : arregloInv){

                            if(producto.getNombre().equalsIgnoreCase(nomProd) && producto.getCodigoProducto() == codPr){
                                prodEncontrado = producto;
                                break;
                            }
                            
                        }
                        if(prodEncontrado != null){
                           
                            String mensaje = "el producto: " + nomProd + "\ncodigo de producto: " + codPr + "\ncantidad: " + producto.getCantidad();
                            JOptionPane.showMessageDialog(null, mensaje, "Search", JOptionPane.INFORMATION_MESSAGE);
                            break;
                            
                        }   
                    }
                    

                    
                    
                }catch(ExceptionCadena e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                catch(ExceptionName e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                
                catch(ExceptionCode e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                
                catch(NumberFormatException e){
                    System.out.println("los datos ingresados no pertenecen al tipo de datos solicitado");
                }
                catch(Exception e){
                    System.out.println("error en los datos ingresados");
                }
            }
        }

    }

    
}
