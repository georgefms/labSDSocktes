package sockets;


import java.net.*;
import java.io.*;
import java.util.Arrays;

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

            System.out.println("Array recebido pelo usuário, de forma ordenada: ");
            printArray(getMessage(socket));

        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("\n"+"acabo o servidor");
    }

    public static int[] getMessage(Socket s)
            throws IOException, ClassNotFoundException {
        InputStream is = s.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        int[] myMessageArray = (int[])ois.readObject();
        return myMessageArray;
    }

    public static void printArray(int arr[]){

        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
