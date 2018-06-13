package downloader;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;

public class DownloadThread extends Thread {

	private DownloadInfo info;
	private DownloaderUI ui;
	public DownloadThread(DownloadInfo info,DownloaderUI ui){
		this.info=info;
		this.ui=ui;
	}
	
	public void run(){
		try {
			URL url=new URL(info.getMyurl());
			URLConnection conn=url.openConnection();
			conn.setRequestProperty("Range","bytes="+info.getStart()+"-"+info.getEnd());
			InputStream is=conn.getInputStream();
			RandomAccessFile rdf=new RandomAccessFile(info.getLocal(), "rw");
			rdf.seek(info.getStart());
			
			byte[] buff=new byte[1024*100];
			int len=0;
			
			while((len=is.read(buff))!=-1){
				rdf.write(buff, 0, len);
				ui.updateBarsValues(info.getIndex(),len);
			}
			rdf.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
