package midasClient;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.DecimalFormat;

public class Client {
	private final String server_ip = "192.168.0.10";
	private final int firstServerPort = 52000;
	private int secondServerPort;
	private int id;
	private String nickname = "asd";
	private boolean isConnected = false;
	private Socket firstClientSocket;
	public static Socket secondClientSocket;
	
	public void ConnectWithServer() {
		try {
			//52000포트로 첫번째 연결을 시도한다.
			firstClientSocket = new Socket(server_ip,firstServerPort);
			System.out.println("first socket conneted");
			
			//두번째 포트 번호를 받는다.
			secondServerPort = Integer.parseInt(ReceiveData(firstClientSocket,3));
			System.out.println("second port is "+secondServerPort);
			
			//첫번째 소켓은 연결을 끊는다.
			firstClientSocket.close();
			
			//두번째 포트로 다시 연결을 시도한다.
			secondClientSocket = new Socket(server_ip, secondServerPort);
			isConnected = true;
			
			//서버에게 자신의 닉네임을 알려준다.
			SendData(secondClientSocket,nickname,3);
			
			//서버로부터 id를 할당받는다.
			id = Integer.parseInt(ReceiveData(secondClientSocket,5));

			System.out.println("my id is "+id+". Connect Success!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public String ReceiveData(Socket socket, int format_length) {
		try {
			byte arrlen[] = new byte[format_length];
	        InputStream in;
	
			in = socket.getInputStream();
			in.read(arrlen);
	        int data_len = Integer.parseInt(new String(arrlen));
	        byte textBuffer[] = new byte[data_len];
	        in.read(textBuffer);
	        String str = new String(textBuffer);
	        return str;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void SendData(Socket socket,String text, int format_length) {
		BufferedWriter out;
		try {
			StringBuilder sb = new StringBuilder("");
			for(int i=0; i<format_length; i++)
				sb.append("0");
			String format = sb.toString();
			DecimalFormat df = new DecimalFormat(format);
			String text_len = df.format(text.length());
			String data = text_len + text;
			out = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()));
			out.write(data);
	        out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
