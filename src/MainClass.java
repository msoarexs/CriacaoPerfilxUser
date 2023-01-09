import javax.naming.NamingException;
import java.io.*;
import java.util.*;

public class MainClass extends UserxPerfil {

    public MainClass(String login, String role) {
        super(login, role);
    }

    public static void main(String[] args) {

    /*
      !!!!!!!!!!!!!!!!IMPORTANTE!!!!!!!!!!!!!!
      Para utilizar o código, troque a "String Arquivo" abaixo para o diretório onde se encontra sua planilha de Usuário x Perfil.
      Na Classe "BatFile" Altere também a "String Arquivo" que será o local onde o arquivo de carga será criado.
     */

        //Local do arquivo que será lido.
        String arquivo = "C:\\Users\\Mateus Soare\\Desktop\\CARGA - Usuários.csv";

        //Arraylist Criando a lista
        List<UserxPerfil> lista = new ArrayList<UserxPerfil>();

        //Lendo arquivo
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha = br.readLine();
            linha = br.readLine();

            //Lendo a planilha e separando Usuário de Role
            while (linha != null) {
                String[] vetor = linha.split(",");
                String nome = vetor[0];                         //Separa o login das roles
                String perfil = vetor[1];                       //Separa o login das roles

                UserxPerfil dados = new UserxPerfil(nome, perfil);

                lista.add(dados);
                linha = br.readLine();
            }

            //Cria o arquivo bat para a carga de User x Perfil
            BatFile esc = new BatFile();
            esc.writeFile(lista);


            //Imprime no prompt os dados da planilha para validação
            for (UserxPerfil u : lista) {
                System.out.println(u);
            }
        } catch (IOException e) {
            System.out.println("!!ERRO!!" + e.getMessage());
        }
    }
}