import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser{
	

    private final JFileChooser fileChooser = new JFileChooser();              
    private JFrame frm;
	public FileChooser(JFrame frame)//flag 0이면 오픈 1이면 저장
	{
		fileChooser.setFileFilter(new FileNameExtensionFilter(".dat", ".dat"));	
		this.frm = frm;
    }
	
	void openFile(final TappedPane pane){
		int returnVal = fileChooser.showOpenDialog(frm);
        if( returnVal == JFileChooser.APPROVE_OPTION)
        {
			try {
				FileInputStream fis = new FileInputStream(fileChooser.getSelectedFile().toString());
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				PanelInformation document = (PanelInformation)ois.readObject();
				// 가져 오고 나서 리스트에 추가 
				pane.addInfo(document);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        else
        {
            System.out.println("취소합니다");
        }
	}
	
	void saveFile(PanelInformation panelInformation){
		int returnVal = fileChooser.showSaveDialog(frm);
        if( returnVal == JFileChooser.APPROVE_OPTION)
        {
        	try {
        		panelInformation.setDocumentName(fileChooser.getSelectedFile().toString()); 
        		FileOutputStream fos = new FileOutputStream(panelInformation.getDocumentName() + ".dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(panelInformation);
				oos.close();
        	} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        else
        {
            System.out.println("취소합니다");
        }
	}

    
}