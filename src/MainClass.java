import javax.naming.NamingException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Conexao conect = new Conexao();

        File file = new File("C:\\Users\\Mateus Soare\\Desktop\\PerfilVsUsersTest - Copia.csv");
        Scanner sc = null;

        try{
            sc = new Scanner(file);
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        //conect.NovaConexao();
        //conect.addUsuario();

    }

}