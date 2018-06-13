package downloader;

public class DownloadInfo {

	private int start;
	private int end;
	private int index;
	private String myurl;
	private String local;
	
	public String getMyurl() {
		return myurl;
	}
	public void setMyurl(String myurl) {
		this.myurl = myurl;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	
	
	
}
