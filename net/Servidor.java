package net;

import java.io.IOException;
import java.net.Socket;
import net.sf.lipermi.exception.LipeRMIException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.IServerListener;
import net.sf.lipermi.net.Server;

public class Servidor {

    private int puerto = 9007;
    private CallHandler invocador;
    private Server servidor;
    private CalculoRmiCombustibleImplem calculo;

    public Servidor() {
        invocador = new CallHandler();
        servidor = new Server();
        calculo = new CalculoRmiCombustibleImplem();

        servidor.addServerListener(new IServerListener() {
            @Override
            public void clientConnected(Socket socket) {
                System.out.println("Cliente conectado: " + socket.getRemoteSocketAddress());
            }

            @Override
            public void clientDisconnected(Socket socket) {
                System.out.println("Cliente desconectado: " + socket.getRemoteSocketAddress());
            }
        });
    }

    public Servidor(int puerto) {
        this();
        this.puerto = puerto;
    }

    public void iniciar() throws Exception {
        try {
            invocador.registerGlobal(IRemotaCalculoCosto.class, calculo);
            servidor.bind(puerto, invocador);
            System.out.println("Servidor LipeRMI iniciado en el puerto: " + puerto);
        } catch (LipeRMIException ex) {
            throw new Exception("Error al registrar servicio: " + ex.getMessage(), ex);
        } catch (IOException ex) {
            throw new Exception("Error E/S: " + ex.getMessage(), ex);
        }
    }

    public void detener() {
        if (servidor != null) {
            servidor.close();
            System.out.println("Servidor detenido.");
        }
    }

    public static void main(String[] args) {
        Principal.main(args);
    }
}
