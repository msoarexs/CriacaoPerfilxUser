import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BatFile {
    //Puxando os dados pegos no arquivo e colocando no formato ETAUTIL


    public void writeFile(List<UserxPerfil> listas) {
        String arquivo = "C:\\Users\\Mateus Soare\\Desktop\\luquitaLindinho.bat";
        try (BufferedWriter br = new BufferedWriter(new FileWriter(arquivo))) {
            for (UserxPerfil u : listas) {
                arquivo = "C:\\Users\\Mateus Soare\\Desktop\\PerfilVsUsers_etautil.csv";
                br.write("etautil -d im -u etaadmin -p CAIMAG1 -DYN update 'eTGlobalUserContainerName=Global " +
                        "Users,eTNamespaceName=CommonObjects,dc=im,dc=eta' eTGlobalUser eTGlobalUserName='" + u.getLogin() +
                        "' to +eTRoleDN='eTRoleName=" + u.getRole() + ",eTRoleContainerName=Roles,eTNamespaceName=CommonObjects,dc=im'" + "\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
