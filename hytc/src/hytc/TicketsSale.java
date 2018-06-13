package hytc;

public class TicketsSale extends Thread {

	private static int ticketsNum=50;
	private static int count=1;
	
	public void run(){
		while(ticketsNum>0){
			System.out.println(Thread.currentThread().getName() + "\t当前票号：" + count);
			System.out.println(Thread.currentThread().getName() + "\t当前余票：" + ticketsNum);
			ticketsNum--;
			count++;
		}
		//System.out.println(Thread.currentThread().getName() + "\t当前票号：" + count);
	}
	
	public TicketsSale(int ticketsNum, int count){
		this.ticketsNum=ticketsNum;
		this.count=count;
	}
//	public static void main(String[] args) {
//		TicketsSale ts=new TicketsSale(50,1);
//		ts.start();
//
//	}
}
