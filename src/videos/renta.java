package videos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class renta extends javax.swing.JFrame {
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Limpiar;
    private javax.swing.JTextField id_vid;
    private javax.swing.JTextField id_cl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public renta() {
    	super("Renta de videos");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        id_vid = new javax.swing.JTextField();
        id_cl = new javax.swing.JTextField();
        Limpiar = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        MiOyente1 guardar= new MiOyente1();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        Limpiar.setText("Limpiar");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_cl.setText(null);
                id_vid.setText(null);
            }
        });

        Guardar.setText("Realizar Renta");
        Guardar.addActionListener(guardar);

        jLabel3.setText("Id Video:");

        jLabel2.setText("Id Cliente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createSequentialGroup()
                  .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(18,18,18)
                  .addComponent(id_cl, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGroup(layout.createSequentialGroup()
                  .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(18,18,18)
                  .addComponent(id_vid, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18,18,18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18,18,18)
                        .addComponent(id_cl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18,18,18)
                        .addComponent(id_vid, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))      
       );
        

        pack();
        setVisible(true);
    }
    class MiOyente1 implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		conexion renta=new conexion();
    		renta.TxRe(id_cl.getText(),id_vid.getText());
    	}
    }

    /**
     * @param args the command line arguments
     */
    //Autor: Luis Fernando Sapiéns Ochoa
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
                new renta().setVisible(true);
            }
        });
    }
}
