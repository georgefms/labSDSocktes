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
            System.out.println("Digite a quantidade de números: ");
            int num = scanner.nextInt();
            int array[] = new int[num];
            System.out.println("Insira os itens do array");
            for (int i = 0 ; i < array.length; i++ ) {
                array[i] = scanner.nextInt();
            }
            System.out.println("Array Inserido");
            printArray(array);

            scanner.close();

            System.out.println("Enviando mensagem para o servidor ...");
            sendMessage(socket, array);
            System.out.println("Enviado");
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Acabo o Cliente");
    }

    public static void printArray(int arr[]){

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sendMessage(Socket s, int[] myMessageArray)
            throws IOException {
        OutputStream os = s.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(myMessageArray);
    }
}
