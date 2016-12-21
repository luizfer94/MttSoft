package videos;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class videos extends javax.swing.JFrame{
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
	public videos(){
		super("Video Club, Sapiéns Ochoa Luis Fernando");
		initComponents();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
	@SuppressWarnings("unchecked")
	private void initComponents() {
		jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        
        MiOyente1 renta= new MiOyente1();
        MiOyente2 TxMem= new MiOyente2();
        MiOyente3 TxType=new MiOyente3();
        MiOyente4 TxCl=new MiOyente4();
        MiOyente5 Exit= new MiOyente5();
        
        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );
        
        jTextArea1.setColumns(20);
        jTextArea1.setRows(20);
        jScrollPane1.setViewportView(jTextArea1);
        
        jLabel1.setText("Info: ");
        jLabel3.setText("Id del Cliente: ");
        jButton1.setText("Renta");
        jButton1.addActionListener(renta);
        jButton2.setText("Renta X cliente");
        jButton2.addActionListener(TxCl);

        jButton3.setText("Total x Membresia");
        jButton3.addActionListener(TxMem);
        jButton4.setText("Total x Dia");
        jButton4.addActionListener(TxType);
        jLabel2.setText("Consultas:");
        jLabel4.setText("Dia (yyyy-mm-dd) :");
        jLabel5.setText("Id Cliente: ");
        jLabel6.setText("Realizar: ");
        
		jButton5.setText("Salir");
        jButton5.addActionListener(Exit);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(18,18,18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18,18,18))
                             .addGroup(layout.createSequentialGroup())
                        		.addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        		.addGap(30,30,30)
                        		.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        		.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        		.addGap(30,30,30)
                        		.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jLabel6,javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addComponent(jButton3))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    	.addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    		.addComponent(jTextField1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    )//.addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,false)
                		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton4)
                .addComponent(jButton5))
                )))
        );
        	
        pack();
        setVisible(true);
    }
	class MiOyente1 implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		jTextArea1.setText(null);
    		renta rentas=new renta();
    		rentas.setVisible(true);
    		
    	}
    } 
	class MiOyente2 implements ActionListener{
		public void actionPerformed(ActionEvent e){
    		jTextArea1.setText(null);
    		jTextArea1.setText("Tipos\tFecha\tTotalxTipo\n");
			String [] array=new String[3];
			int y=0;
			conexion conexiones= new conexion();
			array = conexiones.TxMem(jTextField1.getText());
			while(y!=2){
				jTextArea1.append(array[y]);
				y++;
			}
		}
	}
	class MiOyente3 implements ActionListener{
		public void actionPerformed(ActionEvent e){
    		jTextArea1.setText(null);
    		jTextArea1.setText("Membresia\tFecha\tTotalxTipo\n");
			String [] array=new String[3];
			int y=0;
			String day = jTextField1.getText();
			conexion conexiones= new conexion();
			if(jTextField1.getText() == null )
				day = conexiones.now();
			array = conexiones.TxType(day);
			while(y!=3){
				jTextArea1.append(array[y]);
				y++;
			}
		}
	}
	class MiOyente4 implements ActionListener{     
		public void actionPerformed(ActionEvent e){
    		jTextArea1.setText(null);
    		jTextArea1.setText("ID\tNombre\t\tFecha\tTotal\n");
			String y=null;
			conexion conexiones= new conexion();
			String day = jTextField1.getText();
			if(day == null )
				day = conexiones.now();
			System.out.println(day);
			y=conexiones.TxCl(jTextField2.getText(),day);
				jTextArea1.append(y);
		}
	}
	class MiOyente6 implements ActionListener{     
		public void actionPerformed(ActionEvent e){
    		jTextArea1.setText(null);
    		jTextArea1.setText("ID\tNombre\t\tFecha\tTotal\n");
			String [] array=new String[4];
			int y=0;
			conexion conexiones= new conexion();
			//array = conexiones.TxCl(jTextField2.getText());
			while(y!=3){
				jTextArea1.append(array[y]);
				y++;
			}
		}
	}
	class MiOyente5 implements ActionListener{
		public void actionPerformed(ActionEvent e){
    		System.exit(0);    		
		}
	}
	// Alumno: Luis Fernando Sapiéns Ochoa
public static void main(String args[]) {
        
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(videos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(videos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(videos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(videos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new videos().setVisible(true);
            }
        });
    }
	}

