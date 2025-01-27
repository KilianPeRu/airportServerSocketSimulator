/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author K-Client
 */
public class Servidor implements Runnable {

    int port;
    ArrayList<Socket> socketsCliente = new ArrayList<>();
    Map<Socket, ObjectOutputStream> streams = new HashMap<>();

    public Servidor(int port) {
        this.port = port;
    }

    //START THE SERVER
    @Override
    public void run() {
        ServerSocket socketServer;
        Socket socketCliente;
        DataInputStream in;

        try {
            socketServer = new ServerSocket(port);

            while (true) {
                socketCliente = socketServer.accept();
                socketsCliente.add(socketCliente);
                System.out.println("Conectado: " + socketCliente);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //SEND UPDATE OF THE PRICES
    public void update(ArrayList<Aeropuerto> vuelos) {
        for(Socket socket : socketsCliente) {
            try {
                ObjectOutputStream obj;
                if (streams.containsKey(socket)) {
                    obj = streams.get(socket);
                } else {
                    obj = new ObjectOutputStream(socket.getOutputStream());
                    streams.put(socket, obj);
                }
                for (Aeropuerto aeropuerto : vuelos) {
                    obj.writeObject(aeropuerto);
                    obj.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
