package sockets;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try{
            System.out.println("Conectando ao Servidor TCP: ...");
            Socket socket = new Socket("10.15.10.12", 3005);
            System.out.println("OK");

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite sua msg: ");
            String clientmsg = scanner.nextLine();
            byte[] buffer = clientmsg.getBytes();

            System.out.println("Enviando mensagem para o servidor ...");
            outputStream.write(buffer);
            System.out.println("Enviado");
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Acabo o Cliente");
    }
}
