package com.example.jdmon.lightbot;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread{

    private BufferedReader in;
    private PrintWriter out;
    private String moves_to_send;
    private boolean send_data_switch;

    public void create_conection(){

        try {
            Socket socket = new Socket("172.18.189.221", 8888);
            //in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        create_conection();
        send_data_switch = false;

        while(true){
            if(send_data_switch){
                send_data_client(moves_to_send);
                send_data_switch=false;
            }
        }
    }

    private void send_data_client(String data){
        try {
            out.println(data);
            out.flush();
        }catch(Exception e){
        }
    }

    public void send_data(String moves){
        this.moves_to_send=moves;
        this.send_data_switch=true;
    }

}

   /*
    public String read(){

        String result = "";
        try {
            result = in.readLine();
        }catch (IOException s){
            s.printStackTrace();
        }
        return result;
    }
    */