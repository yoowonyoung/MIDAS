import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wonjerry
 */
public class DialgFrame extends javax.swing.JFrame {

    /**
     * Creates new form DialgFrame
     */
	
	private PanelInformation info;
	private int tabNum;
    public DialgFrame(PanelInformation info, int tabnum) {
    	this.info = info;
    	this.tabNum = tabNum;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        String[] list = new String[info.getClassList().size()];
        System.out.println("in dialog : " + info.getClassList());
        for(int i=0; i<info.getClassList().size(); i++){
        	list[i] = info.getClassList().get(i).getClassName();
        }
        info.getClassList().get(0).getClassName();
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(list));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(list));
        jComboBox2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
	            String str = (String)jComboBox2.getSelectedItem();
	            for(ClassObject ele : info.getClassList()){
	            	if(ele.getClassName().equals(str)){
	            		info.setDstObject(ele);
	            		break;
	            	}
	            }
	            
			}
        	
        });

        jLabel1.setText("Source");

        jLabel2.setText("Destination");
        
        jButton1.setText("Ok");
        jButton1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ClassObject class1 = info.getSrcObject();
				ClassObject class2 = info.getDstObject();
				if(class1.getClassLocation().calculateUpDown(class2.getClassLocation())){
					Location class1Location = class1.getClassLocation();
					Location class2Location = class2.getClassLocation();
					System.out.println("in dialogFrame class1 : " + class1Location);
					System.out.println("in dialogFrame class2 : " + class2Location);
					Location location = new Location((class1Location.getStartX()+class1Location.getEndX())/2,class1Location.getStartY(),(class2Location.getStartX()+class2Location.getEndX())/2,class2Location.getEndY());
					//((EditPanel)MainFrame.editPanel.getTabComponentAt(tabNum)).setArrorwlocation(location);
					System.out.println("in dialogFrame location : " + location);
					info.addRelationshipArrow(new RelationshipArrow(location, "Dependency"));
					MainFrame.editPanel.repaint();
				}
				DialgFrame.this.dispose();
			}
        	
        });
        

        jButton2.setText("Cancel");
        jButton2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DialgFrame.this.dispose();
			}
        	
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(98, 98, 98)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    	if(evt.getSource() == jComboBox1)
        {
            //항목의 반환형이 오브젝트의 참조값으로 반환되니 String으로 형변환 해줘야 합니다
            String str = (String)jComboBox1.getSelectedItem();
            for(ClassObject ele : info.getClassList()){
            	if(ele.getClassName().equals(str)){
            		info.setSrcObject(ele);
            		break;
            	}
            }
            
           
        }
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
