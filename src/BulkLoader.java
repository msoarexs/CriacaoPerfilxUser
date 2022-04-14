import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BulkLoader {
//action,%FULL_NAME%,%LAST_NAME%,%FIRST_NAME%,%USER_ID%,%LOGIN_ID%,%MAIL%
        String nome;
    public void arquivocsv(List<UserxPerfil> listaa) {
        String arquivo = "C:\\Users\\Mateus Soare\\Desktop\\bulkloader.csv";
        try (BufferedWriter br = new BufferedWriter(new FileWriter(arquivo))) {
            br.write("action,%USER_ID%,%LOGIN_ID%,%FULL_NAME%,%LAST_NAME%,%FIRST_NAME%,%MAIL%");
            for (UserxPerfil u : listaa) {
                nome= u.getLogin().replace("."," ");
                br.write( "\n"+"create,"+u.getLogin()+","+u.getLogin()+","+nome+",n/a,n/a,"+u.getLogin().toLowerCase()+"@nicolasec.com");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


