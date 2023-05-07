package BaseDatos;

import java.io.*;
import java.util.*;

public class Usuarios {
    public static void main(String[] args) throws IOException {
        UserInfo user = new UserInfo();
        String nombre1 = "Juan", tipo = "Auto", placa = "LKJ-842", ciudad = "Cartagena";
        int userCont = 0;

        try {
            File file = new File("src/main/java/BaseDatos/Datos.txt");

            if (!file.exists()) { file.createNewFile(); } //Si el archivo no existe lo crea
            
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] div = linea.split(",");

                if (div.length == 4) {
                    user.NewUser(div[0], div[1], div[2], div[3]);
                    userCont++;
                }
            }
            scanner.close();

            //Comprobar que no sea usuario repetido
            boolean comp = false;
            for (int i = 0; i < userCont; i++) {
                if (placa.equals(user.GetPlaca(i)) && ciudad.equals(user.GetCity(i))) {
                    comp = false;
                    break;
                } else {
                    comp = true;
                }
            }

            if (comp) {
                user.NewUser(nombre1, tipo, placa, ciudad);
                userCont++;
            }

            PrintWriter writer = new PrintWriter("src/main/java/BaseDatos/Datos.txt", "UTF-8");
            for (int i = 0; i < userCont; i++) {
                writer.println(user.GetAll(i));
            }
            writer.close();
            //File file2 = new File("src/main/java/BaseDatos/asd2.txt");
            //PrintWriter writer = new PrintWriter("src/main/java/BaseDatos/asd2.txt", "UTF-8");

            /*if (!file2.exists()) {
                file2.createNewFile();
            }
            */

            /* 
            for (int i = 0; i < user.length; i++) {
                writer.println(user.GetAll(i));
            }
            */


            /* 
            FileWriter escribir = new FileWriter(archivo);
            escribir.write("TEXTO2");
            escribir.close();*/

            //writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }

        for (int i = 0; i < userCont; i++) {
            user.GetUser(i);
        }
    }
}