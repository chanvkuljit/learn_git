        try (ServerSocket ss = new ServerSocket(5000)) {
            System.out.println("Server started");
            
            while (true) {
                System.out.println("Waiting for a client...");
                Socket s = ss.accept();
                System.out.println("Client accepted: " + s.getInetAddress());
                
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                Scanner sc = new Scanner(System.in);
                
                String clientMessage = "";
                
                while (true) {
                    clientMessage = dis.readUTF();
                    System.out.println("Client: " + clientMessage);
                    
                    if (clientMessage.equalsIgnoreCase("Over")) {
                        System.out.println("Client disconnected");
                        break;
                    }
                }
                
                s.close();
                sc.close();
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
