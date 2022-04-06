import javax.naming.NamingException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class MainClass extends Throwable {

    public static void main(String[] args) {
        //Conexao com a base de dados do IDM
        Conexao conect = new Conexao();

        //Leitura de arquivo
        String arquivo = "C:\\Users\\Mateus Soare\\Desktop\\PerfilVsUsersTest - Copia.csv";

        //Arraylist
        List<UserxPerfil> lista = new ArrayList<UserxPerfil>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha = br.readLine();
            linha = br.readLine();

            //Lendo a planilha e separando Nome de Role
            while (linha != null) {
                String[] vetor = linha.split(",");
                String nome = vetor[0];
                String perfil = vetor[1];

                UserxPerfil dados = new UserxPerfil(nome,perfil);
                lista.add(dados);

                linha = br.readLine();
            }

            //System.out.println("Dados Planilha: ");
            for (UserxPerfil u : lista){
                System.out.println(u);
            }

        }
        catch (IOException e) {
            System.out.println("!!ERRO!!" + e.getMessage());
        }
    }
}