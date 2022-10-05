import javax.naming.NamingException;
import java.io.*;
import java.util.*;

public class MainClass extends UserxPerfil {

    public MainClass(String login, String role) {
        super(login, role);
    }

    public static void main(String[] args) {

        //Local de arquivo para uma variavel
        String arquivo = "C:\\Users\\Mateus Soare\\Desktop\\carga se suite.csv";

        //Arraylist Criando a lista
        List<UserxPerfil> lista = new ArrayList<UserxPerfil>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha = br.readLine();
            linha = br.readLine();

            //Lendo a planilha e separando Nome de Role
            while (linha != null) {
                String[] vetor = linha.split(",");
                String nome = vetor[0];                         //Separa o login das roles;
                String perfil = vetor[1];                       //Separa o login das roles


                UserxPerfil dados = new UserxPerfil(nome, perfil);

                lista.add(dados);
                linha = br.readLine();
            }
            //Cria o arquivo bat para a carga de User x Perfil
            BatFile esc = new BatFile();
            esc.writeFile(lista);
            //System.out.println("teste");
            //BulkLoader bl = new BulkLoader();
            //bl.arquivocsv(lista);


            //Imprime os dados da planilha
            for (UserxPerfil u : lista) {
                System.out.println(u);
            }
        } catch (IOException e) {
            System.out.println("!!ERRO!!" + e.getMessage());
        }
    }
}