import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {
    public void rodar() throws IOException, ClassNotFoundException {
        // DatagramSocket implenta tipo udp em java
        System.out.println("Servidor iniciado");
        DatagramSocket socketEntrada = new DatagramSocket(50000);

        while (true){
            System.out.println("Servidor aguardando menssagens");
            byte[] bufferEntrada = new byte[256];

            DatagramPacket packetEntrada =  new DatagramPacket(bufferEntrada, bufferEntrada.length);
            socketEntrada.receive(packetEntrada);

            System.out.println("Conversão de bytes para objeto realizada com sucesso");
            byte[] bufferCalculadora = packetEntrada.getData();

            //Guarda um buffer
            ByteArrayInputStream bais = new ByteArrayInputStream(bufferCalculadora);
            //ois = Object Input Stream
            ObjectInputStream ois = new ObjectInputStream(bais);
            Calculadora calculadora = (Calculadora) ois.readObject();

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
        Servidor servidor = new Servidor();
        servidor.rodar();
    }
}
