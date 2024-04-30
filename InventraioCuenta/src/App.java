import java.util.InputMismatchException;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {

        //Scanner sc = new Scanner(System.in);
        
        GestionInventario gest_Cuenta = new GestionInventario();
      
        int opc;
        
        
        do{
            
            System.out.println("------------ Menu de Opciones -----------");
            System.out.println("1. Agregar nuevo producto");
            System.out.println("2. Eliminar producto existente");
            System.out.println("3. Consultar todos los productos en el inventario");
            System.out.println("4. Consultar un producto en especifico");

            boolean opcionValida = false;
            while(true){
                try{
                    System.out.println("ingrese la opcion que desea realizar");
                    opc = Integer.parseInt(JOptionPane.showInputDialog("ingrese la opcion que desea realizar"));
                    if(opc >= 0 && opc <= 4){
                        opcionValida = true;
                        break;
                    }
                   
                }catch(InputMismatchException e){
                    JOptionPane.showMessageDialog(null, "tipo de dato incorrecto");

                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Error al ingresar los datos");
                }
                
            }
            switch(opc){
                case 0: return;
                case 1: gest_Cuenta.agregar_Producto(); break;
                case 2: gest_Cuenta.eliminarProducto(); break;
                case 3: gest_Cuenta.getProductos(); break;
                case 4: gest_Cuenta.buscarProductoEspecifico(); break;
                         
               default: System.out.println("Opcion no valida, intentelo nuevamente.");
            }

        }while(opc !=0);

        /*Inventario inv1 = new Inventario();
        inv1.setNombre();
        System.out.println("nombre del producto: " + inv1.getNombre());*/
    }
}
