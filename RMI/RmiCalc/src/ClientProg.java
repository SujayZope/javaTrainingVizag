import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ClientProg {

	public static void main(String[] args) {
		int a, b, c;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2 Number  ");
		a = sc.nextInt();
		b = sc.nextInt();

		try {
			Calc calc = (Calc) Naming.lookup("localhost");
			System.out.println("Client Programming...");
			System.out.println("Sum  " + calc.sum(a, b));
			System.out.println("Sub  " + calc.sub(a, b));
			System.out.println("Multi  " + calc.multi(a, b));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}