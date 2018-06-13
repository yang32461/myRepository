package downloader;

import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Downloader {

	private String myurl;
	private String local;

	private int count;
	private int length;
	boolean isgoon=true;
	
	private List<DownloadInfo> infos;
	
	
	
	public Downloader(List<DownloadInfo> infos) {
		this.infos = infos;
	}
	
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public List<DownloadInfo> getInfos() {
		return infos;
	}

	public void setInfos(List<DownloadInfo> infos) {
		this.infos = infos;
	}

	public Downloader(String myurl,String local,int count){
		this.myurl=myurl;
		this.local=local;
		this.count=count;
		
		PrepareDownload();
		countDownloadInfo();
	}

	public void PrepareDownload(){
		try {
			URL url=new URL(myurl);
				URLConnection conn=url.openConnection();
				length=conn.getContentLength();
				RandomAccessFile rdf=new RandomAccessFile(local, "rw");
				rdf.setLength(length);
//				rdf.write(b);
				rdf.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void countDownloadInfo(){
		infos=new ArrayList<>();
		int block=length/count;
		DownloadInfo info=null;
		for(int i=0;i<count;i++){
			info=new DownloadInfo();
			info.setMyurl(myurl);
			info.setLocal(local);
			info.setIndex(i);
			info.setStart(i*block);
			if(i<count-1){
				info.setEnd((i+1)*block);
			}else{
				info.setEnd(length-1);
			}
			infos.add(info);
		}
	}
	
	public void downloadinfos(List<DownloadInfo> infolist,DownloaderUI ui){
		DownloaderUI dUI = new DownloaderUI();
		System.out.println(dUI.isIsgoon());
			for(DownloadInfo info:infolist){
				DownloadThread downloadThread= new DownloadThread(info,ui);
				downloadThread.start();
				if((dUI.isIsgoon())==false){
					try {
						downloadThread.wait();
					} catch (Exception e) {
						
						e.printStackTrace();
					}
				}
				
				
			
//			for(DownloadInfo info:infolist){
//					DownloadThread downloadThread= new DownloadThread(info,ui);
//					downloadThread.start();
//			}
//		}else{
//			DownloadInfo info=(DownloadInfo) infolist;
//			DownloadThread downloadThread1= new DownloadThread(info,ui);
//			downloadThread1.start();
//			
		}
	}
}