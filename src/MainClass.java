import javax.naming.NamingException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MainClass {

    public static void main(String[] args) {

        //Leitura de arquivo
        String arquivo = "C:\\Users\\Mateus Soare\\Desktop\\PerfilVsUsersTest - Copia.csv";

        //Arraylist
        List<UserxPerfil> lista = new ArrayList<UserxPerfil>();

        MainClass path = new MainClass();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha = br.readLine();
            linha = br.readLine();

            //Lendo a planilha e separando Nome de Role
            while (linha != null) {
                String[] vetor = linha.split(",");
                String nome = vetor[0];
                nome = nome.replace(" ", ".");
                String perfil = vetor[1];

                UserxPerfil dados = new UserxPerfil(nome, perfil);
                lista.add(dados);

                linha = br.readLine();
            }
                BatFile arquiv = new BatFile();
                arquiv.escreveArquivo(lista);
            //System.out.println("Dados Planilha: ");
            for (UserxPerfil u : lista) {
                System.out.println(u);
            }
        } catch (IOException e) {
            System.out.println("!!ERRO!!" + e.getMessage());
        }


    }
}