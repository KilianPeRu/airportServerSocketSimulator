/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author K-Client
 */
public class Cliente extends Observable implements Runnable {

    int port;
    ArrayList<Aeropuerto> vuelos = new ArrayList<>();

    public Cliente(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        String ipHost = "localhost";
        DataInputStream in;

        try{
            Socket socket = new Socket(ipHost, port);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            while(true){
                this.setChanged();
                this.notifyObservers(ois.readObject());
                this.clearChanged();
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
