package hytc;

public class Tickets {

	
	public static void main(String[] args) {
		TicketsSale ts1=new TicketsSale(50,1);
		TicketsSale ts2=new TicketsSale(50,1);
		TicketsSale ts3=new TicketsSale(50,1);
		TicketsSale ts4=new TicketsSale(50,1);
		
		
		ts1.start();
		ts2.start();
		ts3.start();
		ts4.start();
		
		try {
			ts1.join();
			ts2.join();
			ts3.join();
			ts4.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
