import java.io.*;
import java.net.*;

public class Cliente {
    public void rodar() throws IOException, ClassNotFoundException {
        System.out.println("Criando obj a ser enviado");
        Calculadora calculadora = new Calculadora();
        calculadora.setX(20);
        calculadora.setOperacao('^');
        calculadora.setY(10);


        System.out.println("Conversão Objeto para Bytes");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject(calculadora);
        byte[] bufferCalculadora = baos.toByteArray();

        System.out.println("Enviando o pacote...");
        InetSocketAddress endereco = new InetSocketAddress("127.0.0.1", 50000);
        DatagramPacket pacoteSaida = new DatagramPacket(bufferCalculadora, bufferCalculadora.length, endereco);
        DatagramSocket socket = new DatagramSocket();
        socket.send(pacoteSaida);

        System.out.println("Aguardando menssagens");
        byte[] bufferEntrada = new byte[256];
        DatagramPacket packetEntrada =  new DatagramPacket(bufferEntrada, bufferEntrada.length);
        socket.receive(packetEntrada);

        System.out.println("Conversão de bytes para objeto realizada com sucesso");
        byte[] bufferResposta = packetEntrada.getData();
        ByteArrayInputStream bais = new ByteArrayInputStream(bufferResposta);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Resposta resposta = (Resposta) ois.readObject();

        System.out.println("Imprimdo a resposta...");
        System.out.println("X: " + calculadora.getX());
        System.out.println(calculadora.getOperacao());
        System.out.println("Y: " + calculadora.getY());
        System.out.println("Resultado: " + resposta.getResultado());
        System.out.println("Mensagem: " + resposta.getMenssagem());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cliente cliente = new Cliente();
        cliente.rodar();
    }
}
