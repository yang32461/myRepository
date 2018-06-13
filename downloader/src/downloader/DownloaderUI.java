package downloader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class DownloaderUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String myurl;
	String local;
	private boolean flag=true;
	private boolean isgoon=true;
	
	int result = 0;
	File file = null;
	String path = null;
	JFileChooser fileChooser = new JFileChooser();
	FileSystemView fsv = FileSystemView.getFileSystemView(); 
	
	private List<DownloadInfo> infos=new ArrayList<>();
	
	private List<DownLoadInfo> info=new ArrayList<>();
	private JProgressBar[] progressBars;

	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public static void main(String[] args) {
					DownloaderUI frame = new DownloaderUI();
					frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public DownloaderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(61, 51, 32, 24);
		contentPane.add(lblUrl);
		
		JTextArea textURL = new JTextArea();
		textURL.setBounds(115, 52, 323, 24);
		contentPane.add(textURL);
		
		JLabel label = new JLabel("\u4FDD\u5B58");
		label.setBounds(61, 105, 54, 15);
		contentPane.add(label);
		
		JTextArea textLocal = new JTextArea();
		textLocal.setBounds(115, 101, 323, 24);
		contentPane.add(textLocal);
		
		JLabel label_1 = new JLabel("\u7EBF\u7A0B");
		label_1.setBounds(61, 148, 54, 15);
		contentPane.add(label_1);
		
		JTextArea textCount = new JTextArea();
		textCount.setBounds(115, 144, 323, 24);
		contentPane.add(textCount);
		
		JButton downloadBtn = new JButton("����");
		downloadBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				isgoon=true;
				myurl=textURL.getText();
				local=textLocal.getText();
				int count=0;
				count=Integer.parseInt(textCount.getText());
				//DownLoadInfo download=new DownLoadInfo(myurl,local,count);
				Downloader download=new Downloader(myurl,local,count);
				infos=download.getInfos();
				download.downloadinfos(infos,DownloaderUI.this);
				updateBars();
				
			}
		});
		downloadBtn.setBounds(55, 195, 93, 23);
		contentPane.add(downloadBtn);
		
		JButton pauseBtn = new JButton("��ͣ");
		pauseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isgoon=false;
				
			}
		});
		pauseBtn.setBounds(205, 195, 93, 23);
		contentPane.add(pauseBtn);
		
		JButton button = new JButton("\u9009\u62E9\u8DEF\u5F84");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileSystemView fsv = FileSystemView.getFileSystemView();  
				fileChooser.setCurrentDirectory(fsv.getHomeDirectory());   //�õ�����·��
				fileChooser.setDialogTitle("��ѡ��Ҫ�����·��...");
				fileChooser.setApproveButtonText("ȷ��");
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				result = fileChooser.showOpenDialog(button);
				if (JFileChooser.APPROVE_OPTION == result) {
				    	   path=fileChooser.getSelectedFile().getPath();
				    	   //System.out.println("path: "+path);
				    	   local=path;
				    	  //System.out.println("local:"+local);
				    	   textLocal.setText(local);
			}
			}
		});
		button.setBounds(345, 195, 93, 23);
		contentPane.add(button);
		
		
	}
	
	class DownLoadInfo extends Thread{
		String myurl;
		String local;
		int count;
		public DownLoadInfo(String myurl,String local,int count){
			this.myurl=myurl;
			this.local=local;
			this.count=count;
		}
		
		public void run(){
			
		}
	}
	
	public void updateBars(){
		progressBars=new JProgressBar[infos.size()];
		for(DownloadInfo info:infos){
			progressBars[info.getIndex()]=new JProgressBar();
			progressBars[info.getIndex()].setValue(0);
			progressBars[info.getIndex()].setMaximum(info.getEnd()+1-info.getStart());
			progressBars[info.getIndex()].setBounds(55, 228+(info.getIndex()*30), 323, 24);
			contentPane.add(progressBars[info.getIndex()]);
		}
		this.repaint();
	}
	
	public void updateBarsValues(int index,int len){
		progressBars[index].setValue(progressBars[index].getValue()+len);
	}
	
	public void onPause(){
		
	}

	public boolean isIsgoon() {
		return isgoon;
	}

	public void setIsgoon(boolean isgoon) {
		this.isgoon = isgoon;
	}
}


