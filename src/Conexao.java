
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.Properties;

public class Conexao {
    DirContext conexao;
    public void NovaConexao() throws MainClass{
        Properties env;
        env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL,"ldap://192.168.179.133:10101");
        env.put(Context.SECURITY_PRINCIPAL,"cn=dsaadmin,ou=im,ou=ca,o=com");
        env.put(Context.SECURITY_CREDENTIALS,"senha@123");
        try {
            conexao = new InitialDirContext(env);
            System.out.println("Conectou" + conexao);
        }catch (AuthenticationException ex){
            System.out.println(ex.getMessage());
        }catch (NamingException e) {
            e.printStackTrace();
        }
    }
    public void GetUsers() throws NamingException
    {
        String filtroPesquisa = ("uid=*");
        String[] nome = {"cn"};
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setReturningAttributes(nome);

        NamingEnumeration users = conexao.search("ou=im,ou=ca,o=com", filtroPesquisa, controls);

        SearchResult result = null;
        while (users.hasMore())
        {
            result = (SearchResult) users.next();
            Attributes attr = result.getAttributes();
            System.out.println(attr.get("cn"));
        }
    }
    public void addUsuario() {
        Attributes attributos = new BasicAttributes();
        Attribute attributo = new BasicAttribute("objectClass");
        attributo.add("inetOrgPerson");

        attributos.put(attributo);

        attributos.put("cn", "");
        try {
            conexao.createSubcontext("", attributos);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

}

