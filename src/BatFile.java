
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
//Bat

public class BatFile {
    //Puxando os dados pegos no arquivo e colocando no formato ETAUTIL

    public void writeFile(List<UserxPerfil> listas) {

        //Local onde será gerado o arquivo
        String arquivo = "C:\\Users\\Mateus Soare\\Desktop\\Carga.bat";

        try (BufferedWriter br = new BufferedWriter(new FileWriter(arquivo))) {
            for (UserxPerfil u : listas) {
                //Gerando ETAUTIL baseado ns informações da planilha
                br.write("etautil -d im -u etaadmin -p CAIMAG1 -DYN update 'eTGlobalUserContainerName=Global Users,eTNamespaceName=CommonObjects,dc=im,dc=eta' eTGlobalUser eTGlobalUserName='"+ u.getLogin() +"' to +eTRoleDN='eTRoleName="+ u.getRole() +",eTRoleContainerName=Roles,eTNamespaceName=CommonObjects,dc=im';>>Carga_log.txt" + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




