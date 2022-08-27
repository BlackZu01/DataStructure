import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class SoluciónRetoArchivos {
    
    public static void Llenar(Scanner sc, String file_name){
        String campo1, campo2, campo3;
       
        try {
            FileWriter outFile = new FileWriter(file_name + ".txt", false);  //Archivo.txt
            // if false the file will be deleted and created everytime
            // if true the registers will be appended to the end of the file
            PrintWriter register = new PrintWriter(outFile);
            
            // LOGICA
            String hay_cliente;
            System.out.println("Hay mas registros? si - no");
            hay_cliente = sc.nextLine();
            while(hay_cliente.equalsIgnoreCase("si")){
                System.out.println("Campo 1");
                campo1 = sc.nextLine();
                System.out.println("Campo 2");
                campo2 = sc.nextLine();
                System.out.println("Campo 3");
                campo3 = sc.nextLine();

                while(Double.parseDouble(campo3) < 0){
                    System.out.println("Saldo debe ser positivo");
                    campo3 = sc.nextLine();
                }

                if (!campo1.isEmpty() && !campo2.isEmpty() && !campo3.isEmpty()){
                    register.println(campo1 +"\t"+ campo2 +"\t"+ campo3);
                }

                System.out.println("Hay registos? si - no");
                hay_cliente = sc.nextLine();  
            }
           register.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }
    
    public static void Leer(Scanner sc, String file_name){
        boolean hay = false;

        while(hay == false){
            try {
                BufferedReader br = new BufferedReader(new FileReader(file_name+".txt"));
                String line = null;

                while((line = br.readLine()) != null){
                    String temp[] = line.split("\t");
                    // String temp[] ={1,2,3,4}
                    System.out.println(temp[0] + ","+ temp[1] + ","+temp[2]);
                }
                br.close();
                hay = true;

            } catch (IOException ex) {
                System.out.println("No se encontro archivo");
                hay = false;
                file_name = sc.nextLine(); // Archivo
            }
        }
        
    }

    public static void Update_stuff(String filename1, String filename2){
        try{
            File originalFile = new File(filename1+".txt");
            BufferedReader register_cliente = new BufferedReader(new FileReader(originalFile));

            File originalFile2 = new File(filename2+".txt");
            BufferedReader register_transacciones = new BufferedReader(new FileReader(originalFile2));

            File Temp = new File("temp_file.txt");
            PrintWriter register_temp = new PrintWriter(new FileWriter(Temp));

            String line_cliente = null;
            String line_transaccion = null;

            line_cliente = register_cliente.readLine();
            line_transaccion = register_transacciones.readLine();

            // Mi solución
            while(line_cliente != null ||  line_transaccion!= null){
                String V[] = line_cliente.split("\t");

                if (line_transaccion!= null) {
                    String W[] = line_transaccion.split("\t");
                    String campo1 = V[0];
                    String campo2 = V[1];
                    String campo3 = V[2];

                    if (V[0].equals(W[0])) {
                        // Si es 1, entonces va a retirar
                        if (Integer.parseInt(W[1]) == 1) {
                            campo3 = String.valueOf(Integer.parseInt(V[2]) - Integer.parseInt(W[2]));
                            if (Integer.parseInt(campo3) < 0) {
                                System.out.println("[+] Usted no dispone del monto deseado a retirar!");
                            } 
                        } 
                        // Si es 0, entonces va a depositar
                        else if (Integer.parseInt(W[1]) == 0) {
                            campo3 = String.valueOf(Integer.parseInt(V[2]) + Integer.parseInt(W[2]));
                        }

                        line_cliente = register_cliente.readLine();
                        line_transaccion = register_transacciones.readLine();
                    } 
                    // Si el ID en clientes termina siendo mayor, entonces el ID en Transaccioens no esta registrado en clientes 
                    else if (Integer.parseInt(V[0]) > Integer.parseInt(W[0]) ) {
                        System.out.println("Hay un dato no registrado");
                        line_transaccion = register_transacciones.readLine();
                    } 
                    // Seguir bajando por clientes 
                    else if (Integer.parseInt(V[0]) < Integer.parseInt(W[0])) {
                        line_cliente = register_cliente.readLine(); 
                    } else {
                        break;
                    }
                    // Actualizacion de la info
                    if (!campo1.isEmpty() && !campo2.isEmpty() && !campo3.isEmpty()){
                        register_temp.println(campo1 +"\t"+ campo2 +"\t"+ campo3);
                    }
                }

            }

            register_cliente.close();
            register_transacciones.close();
            register_temp.close();
        }catch(IOException ex){
            System.out.println("No se encontro algun archivo");
        }

    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String file_name = sc.nextLine(); // Archivo
        //System.out.println("Se llama a funcion crear o llenar archivo");
        //System.out.println("Llenar infomracion de clientes");
        //Llenar(sc, "Clientes");
        
        //System.out.println("Llenar infomracion de transacciones");
        //Llenar(sc, "Transacciones");

        //System.out.println("Escribir datos de archivo a consola");
        //Leer(sc, "Clientes");
        Update_stuff("Clientes",  "Transacciones");
        sc.close();
    }
    
}