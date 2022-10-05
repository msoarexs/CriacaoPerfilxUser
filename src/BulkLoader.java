/*
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BulkLoader {
//action,%FULL_NAME%,%LAST_NAME%,%FIRST_NAME%,%USER_ID%,%LOGIN_ID%,%MAIL%

    public void arquivocsv(List<UserxPerfil> listaa) {
        String arquivo = "C:\\Users\\Mateus Soare\\Desktop\\bulkloader_extrafarma.csv";
        try (BufferedWriter br = new BufferedWriter(new FileWriter(arquivo))) {
            br.write("action,%USER_ID%,%CustomField16%,%CustomField99%,%CustomField98%,%CustomField94%");
            for (UserxPerfil u : listaa) {
                br.write( "\n"+"modify,"+u.getLogin()+","+u.getRole()+","+u.getUid()+","+u.getNome_ges()+","+u.getMatricula());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

*/