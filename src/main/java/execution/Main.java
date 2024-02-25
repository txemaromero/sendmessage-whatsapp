package execution;

import java.io.IOException;
import java.util.function.BooleanSupplier;

import sendmessage.WaitUtils;
import sendmessage.WhatsApp;

public class Main {

	public static void main(String[] args) {
		
		String chatName = "to complete";
		String text = "to complete";
		
		final int MAXTIMEOUTMS = 5000;
        
    	System.out.println("Press enter key to not send to WhatsApp ...");
    	
    	BooleanSupplier anyKeyPressed = () -> {
			try {
				return (System.in.available() > 0);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		};
    	boolean pressed = WaitUtils.waitUntil(anyKeyPressed, MAXTIMEOUTMS);
    	
    	if (!pressed)
    	{
    		WhatsApp.send(chatName, text);
    	}
    	else
    	{	
    		System.out.print("\nApplication execution ended\n");
    	}
	}

}
