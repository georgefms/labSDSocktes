package sockets;

import com.sun.jdi.event.ExceptionEvent;

import java.net.*;
import java.io.*;
public class Servidor {
    public static void main(String[] args) {
        int port = 3005;
        int delay = 5;
        try{
            System.out.println("Iniciando Servidor TCP: ...");
            ServerSocket socketzin = new ServerSocket(port, delay, InetAddress.getByName("10.15.10.12"));
            System.out.println("Iniciado");

            System.out.println("Aguardando solicitação de conexão ...");
            Socket socket = socketzin.accept();
            System.out.println("Recebido");

            InputStream inputStream = socket.getInputStream(); //Canal Entrada de dados
            OutputStream outputStream = socket.getOutputStream(); //Canal Saida de dados
            byte[] buffer = new byte[30];

            System.out.println("Aguardando Receber mensagem ...");
            inputStream.read(buffer); //Aguarda o recebimento de dados
            System.out.println("OK");

            String msg = new String(buffer); //Mapeia bytes para String

            System.out.println("Mensagem recebida: "+msg);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("acabo o servidor");
    }

}
