import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor2 {
    /*public void rodar() {
        System.out.println("Servidor iniciado");
        DatagramSocket socketEntrada = new DatagramSocket(50000);

        while (true){
            System.out.println("Servidor aguardando menssagens");
            byte[] bufferEntrada = new byte[256];
            DatagramPacket packetEntrada =  new DatagramPacket(bufferEntrada, bufferEntrada.length);
            try {
                socketEntrada.receive(packetEntrada);
            }catch (IOException ioException) {
                System.out.println("Erro ao tentar obter pacote do cliente");
            }

            System.out.println("Conversão de bytes para objeto realizada com sucesso");
            byte[] bufferCalculadora = packetEntrada.getData();
            ByteArrayInputStream bais = new ByteArrayInputStream(bufferCalculadora);
            ObjectInputStream ois = null;

            try {
                ois = new ObjectInputStream(bais);
            }catch (IOException ioException){
                System.out.println("Erro ao tentar criar o conversor de byes para obj");
            }

            Calculadora calculadora = null;
          try {
              calculadora = (Calculadora) ois.readObject();
          }catch (ClassNotFoundException | IOException exception)
          {
              System.out.println("Erro ao tentar conerter de bytes para obj");
          }


            System.out.println("Operação realizada com sucesso");
            Resposta resposta = new Resposta();

            if (calculadora.getOperacao() == '+'){
                resposta.setResultado( calculadora.getX() + calculadora.getY());
                resposta.setMenssagem("Operação foi realizada com sucesso!");
            }else if (calculadora.getOperacao() == '*'){
                resposta.setResultado( calculadora.getX() * calculadora.getY());
                resposta.setMenssagem("Operação foi realizada com sucesso!");
            } else if (calculadora.getOperacao() == '-')  {
                resposta.setResultado( calculadora.getX() - calculadora.getY());
                resposta.setMenssagem("Operação foi realizada com sucesso!");
            } else if (calculadora.getOperacao() == '/') {
                resposta.setResultado( calculadora.getX() / calculadora.getY());
                resposta.setMenssagem("Operação foi realizada com sucesso!");
            } else {
                resposta.setMenssagem("Operação não implementaa no servidor");
            }



            System.out.println("Conversão Objeto para Bytes");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();


            ObjectOutputStream oos = new ObjectOutputStream( baos );
            oos.writeObject(resposta);
            byte[] bufferResposta = baos.toByteArray();

            System.out.println("Enviando o pacote...");
            DatagramPacket pacoteSaida = new DatagramPacket(bufferResposta, bufferResposta.length, packetEntrada.getAddress(), packetEntrada.getPort());
            DatagramSocket socketSaida = new DatagramSocket();
            socketSaida.send(pacoteSaida);
        }

    }

    public static void main(String[] args)  throws IOException, ClassNotFoundException{
        Servidor2 servidor = new Servidor2();
        servidor.rodar();
    }*/
}
