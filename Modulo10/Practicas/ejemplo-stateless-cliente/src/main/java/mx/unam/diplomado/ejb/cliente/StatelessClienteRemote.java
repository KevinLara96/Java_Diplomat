package mx.unam.diplomado.ejb.cliente;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import mx.unam.diplomado.ejb.IStatelessRemote;

import java.util.Map;
import java.util.Properties;

public class StatelessClienteRemote {

    public static void main(String[] args) {

        IStatelessRemote service = null;
        final Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        env.put("jboss.naming.client.ejb.context", true);

        try {
            InitialContext ctx = new InitialContext(env);
            service = (IStatelessRemote) ctx
                    .lookup("ejb:/ejemplo-stateless-remote/StatelessEJBRemote!mx.unam.diplomado.ejb.IStatelessRemote");

            Map<String, Object> saludo = service.saludar("Jorge");
            System.out.println(saludo);

        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

}
