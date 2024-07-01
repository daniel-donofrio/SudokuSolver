package presentacion;

import java.awt.Color;
import javax.swing.BorderFactory;
import modelo.Sudoku;

public class SudokuInterface extends javax.swing.JFrame {

    public static TableroSudoku tableroSudoku;
    private boolean estadoCargar;

    private int xPos;
    private int yPos;

    public SudokuInterface() {
        initComponents();
        iniciarComponentes();
        panelFondo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }

    public void iniciarComponentes() {
        tableroSudoku = new TableroSudoku();
        tableroSudoku.setTextoAltura(36);
        tableroSudoku.setTextoAncho(36);
        tableroSudoku.setTextoMargen(4);
        tableroSudoku.setTamanioLetra(27);
        //color de bordes
        tableroSudoku.setColorPanelFondo(new Color(0, 0, 0));

        tableroSudoku.setTextoColorFondo1(Color.WHITE);
        tableroSudoku.setTextoColor1(new Color(0, 102, 102));
        tableroSudoku.setTextoColorFondo2(new Color(0,150,150));
        tableroSudoku.setTextoColor2(Color.WHITE);

        panelFondo.add(tableroSudoku);
        tableroSudoku.setLocation(30, 60);
        tableroSudoku.setVisible(true);
        tableroSudoku.crearSudoku();

        tableroSudoku.generarSudoku();
        estadoCargar = true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelCrear = new javax.swing.JPanel();
        lblCrear = new javax.swing.JLabel();
        panelComprobar = new javax.swing.JPanel();
        lblComprobar = new javax.swing.JLabel();
        panelResolver = new javax.swing.JPanel();
        lblResolver = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelGenerar = new javax.swing.JPanel();
        lblGenerar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        panelFondo.setBackground(new java.awt.Color(0, 153, 153));
        panelFondo.setPreferredSize(new java.awt.Dimension(540, 420));
        panelFondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelFondoMouseDragged(evt);
            }
        });
        panelFondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelFondoMousePressed(evt);
            }
        });
        panelFondo.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SUDOKU SOLVER");
        panelFondo.add(jLabel1);
        jLabel1.setBounds(80, 20, 230, 20);

        panelCrear.setBackground(new java.awt.Color(0, 102, 102));

        lblCrear.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lblCrear.setForeground(new java.awt.Color(255, 255, 255));
        lblCrear.setText("    CARGAR NUEVO");
        lblCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCrearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCrearMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCrearMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelCrearLayout = new javax.swing.GroupLayout(panelCrear);
        panelCrear.setLayout(panelCrearLayout);
        panelCrearLayout.setHorizontalGroup(
            panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCrear, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCrearLayout.setVerticalGroup(
            panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelFondo.add(panelCrear);
        panelCrear.setBounds(30, 420, 160, 40);

        panelComprobar.setBackground(new java.awt.Color(0, 102, 102));

        lblComprobar.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lblComprobar.setForeground(new java.awt.Color(255, 255, 255));
        lblComprobar.setText("      COMPROBAR");
        lblComprobar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblComprobar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblComprobarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblComprobarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblComprobarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelComprobarLayout = new javax.swing.GroupLayout(panelComprobar);
        panelComprobar.setLayout(panelComprobarLayout);
        panelComprobarLayout.setHorizontalGroup(
            panelComprobarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelComprobarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblComprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelComprobarLayout.setVerticalGroup(
            panelComprobarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelComprobarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblComprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelFondo.add(panelComprobar);
        panelComprobar.setBounds(210, 420, 150, 40);

        panelResolver.setBackground(new java.awt.Color(0, 102, 102));

        lblResolver.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lblResolver.setForeground(new java.awt.Color(255, 255, 255));
        lblResolver.setText("        RESOLVER");
        lblResolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblResolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblResolverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblResolverMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblResolverMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelResolverLayout = new javax.swing.GroupLayout(panelResolver);
        panelResolver.setLayout(panelResolverLayout);
        panelResolverLayout.setHorizontalGroup(
            panelResolverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResolverLayout.createSequentialGroup()
                .addComponent(lblResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelResolverLayout.setVerticalGroup(
            panelResolverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelResolverLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelFondo.add(panelResolver);
        panelResolver.setBounds(210, 470, 150, 40);

        jLabel2.setBackground(new java.awt.Color(89, 43, 25));
        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(89, 43, 25));
        jLabel2.setText("x");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        panelFondo.add(jLabel2);
        jLabel2.setBounds(360, 10, 30, 30);

        panelGenerar.setBackground(new java.awt.Color(0, 102, 102));

        lblGenerar.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lblGenerar.setForeground(new java.awt.Color(255, 255, 255));
        lblGenerar.setText("          GENERAR");
        lblGenerar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGenerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblGenerarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblGenerarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblGenerarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelGenerarLayout = new javax.swing.GroupLayout(panelGenerar);
        panelGenerar.setLayout(panelGenerarLayout);
        panelGenerarLayout.setHorizontalGroup(
            panelGenerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGenerarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelGenerarLayout.setVerticalGroup(
            panelGenerarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGenerarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelFondo.add(panelGenerar);
        panelGenerar.setBounds(30, 470, 160, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblCrearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearMousePressed

        if (estadoCargar) {
            estadoCargar = false;
            tableroSudoku.limpiarTexto();
            lblCrear.setText("            LISTO");

        } else {
            if (tableroSudoku.cargarSudoku()) {
                estadoCargar = true;
                lblCrear.setText("    CARGAR NUEVO");
            }

        }

    }//GEN-LAST:event_lblCrearMousePressed

    private void lblComprobarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblComprobarMousePressed
        tableroSudoku.comprobar();
    }//GEN-LAST:event_lblComprobarMousePressed

    private void panelFondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFondoMousePressed

        xPos = evt.getX();
        yPos = evt.getY();
    }//GEN-LAST:event_panelFondoMousePressed

    private void panelFondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFondoMouseDragged
        this.setLocation(evt.getXOnScreen() - xPos, evt.getYOnScreen() - yPos);
    }//GEN-LAST:event_panelFondoMouseDragged

    private void lblResolverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResolverMousePressed
        tableroSudoku.resolver();
    }//GEN-LAST:event_lblResolverMousePressed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        System.exit(0);
    }//GEN-LAST:event_jLabel2MousePressed

    private void lblCrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearMouseEntered
        panelCrear.setBackground(new Color(0, 200, 200));
    }//GEN-LAST:event_lblCrearMouseEntered

    private void lblCrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearMouseExited
       panelCrear.setBackground(new Color(0,109,109));
    }//GEN-LAST:event_lblCrearMouseExited

    private void lblComprobarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblComprobarMouseEntered
       panelComprobar.setBackground(new Color(0, 200, 200));
    }//GEN-LAST:event_lblComprobarMouseEntered

    private void lblComprobarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblComprobarMouseExited
         panelComprobar.setBackground(new Color(0,109,109));
    }//GEN-LAST:event_lblComprobarMouseExited

    private void lblResolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResolverMouseEntered
         panelResolver.setBackground(new Color(0, 200, 200));
    }//GEN-LAST:event_lblResolverMouseEntered

    private void lblResolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResolverMouseExited
            panelResolver.setBackground(new Color(0,109,109));
    }//GEN-LAST:event_lblResolverMouseExited

    private void lblGenerarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGenerarMousePressed
        tableroSudoku.generarSudoku();
    }//GEN-LAST:event_lblGenerarMousePressed

    private void lblGenerarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGenerarMouseExited
        panelGenerar.setBackground(new Color(0,109,109));
    }//GEN-LAST:event_lblGenerarMouseExited

    private void lblGenerarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGenerarMouseEntered
        panelGenerar.setBackground(new Color(0, 200, 200));
    }//GEN-LAST:event_lblGenerarMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblComprobar;
    private javax.swing.JLabel lblCrear;
    private javax.swing.JLabel lblGenerar;
    private javax.swing.JLabel lblResolver;
    private javax.swing.JPanel panelComprobar;
    private javax.swing.JPanel panelCrear;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelGenerar;
    private javax.swing.JPanel panelResolver;
    // End of variables declaration//GEN-END:variables

}
