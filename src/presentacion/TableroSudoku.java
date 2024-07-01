package presentacion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.Sudoku;

public class TableroSudoku extends JPanel {

    private JTextField[][] listaTexto;
    private int textoAncho;
    private int textoAltura;
    private int textoMargen;
    private int tamanioLetra;
    private Color colorPanelFondo;
    private Color textoColorFondo1;
    private Color textoColor1;
    private Color textoColorFondo2;
    private Color textoColor2;

    private Sudoku sudoku;
    private ArrayList<JTextField> listaTextoSeleccionado;
    private ArrayList<JTextField> listaTextoGenerado;
    public JTextField textoSeleccionado;

    public TableroSudoku() {
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        listaTexto = new JTextField[9][9];
        textoAncho = 35;
        textoAltura = 36;
        textoMargen = 4;
        tamanioLetra = 27;
        colorPanelFondo = Color.BLACK;
        textoColorFondo1 = Color.WHITE;
        textoColor1 = Color.BLACK;
        textoColorFondo2 = Color.WHITE;
        textoColor2 = Color.BLACK;
        sudoku = new Sudoku();
        listaTextoSeleccionado = new ArrayList<>();
        listaTextoGenerado = new ArrayList<>();
        textoSeleccionado = new JTextField();
    }

    public void crearSudoku() {
        this.setLayout(null);
        this.setSize(textoAncho * 9 + (textoMargen * 4), textoAltura * 9 + (textoMargen * 4));
        this.setBackground(colorPanelFondo);
        crearCamposTxt();
    }

    public void crearCamposTxt() {
        int x = textoMargen;
        int y = textoMargen;

        for (int i = 0; i < listaTexto.length; i++) {
            for (int j = 0; j < listaTexto[0].length; j++) {
                JTextField txt = new JTextField();
                this.add(txt);
                txt.setBounds(x, y, textoAncho, textoAltura);
                txt.setBackground(textoColorFondo1);
                txt.setForeground(textoColor1);
                txt.setFont(new Font("Arial", Font.BOLD, tamanioLetra));
                txt.setEditable(false);
                txt.setCursor(new Cursor(Cursor.HAND_CURSOR));
                txt.setBorder(BorderFactory.createLineBorder(colorPanelFondo, 1));
                txt.setVisible(true);
                x += textoAncho;
                if ((j + 1) % 3 == 0) {
                    x += textoMargen;
                }
                listaTexto[i][j] = txt;
                generarEventos(txt);
            }
            x = textoMargen;
            y += textoAltura;
            if ((i + 1) % 3 == 0) {
                y += textoMargen;
            }
        }

    }

    public boolean textoGenerado(JTextField txt) {
        for (JTextField jTxt : listaTextoGenerado) {
            if (txt == jTxt) {
                return true;
            }
        }
        return false;
    }

    public void generarEventos(JTextField txt) {
        MouseListener evento = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                pressed(txt);
                textoSeleccionado = txt;

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        KeyListener eventoTecla = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (textoGenerado(txt)) {
                    return;
                } else {
                    if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                        txt.setText("");
                    }

                    if (e.getKeyChar() >= 49 && e.getKeyChar() <= 57) {
                        txt.setText(String.valueOf(e.getKeyChar()));
                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        txt.addMouseListener(evento);
        txt.addKeyListener(eventoTecla);
    }

    //Cambiar colores al presionar la casilla
    public void pressed(JTextField txt) {

        for (JTextField jTxt : listaTextoSeleccionado) {
            jTxt.setBackground(textoColorFondo1);
            jTxt.setForeground(textoColor1);
            jTxt.setBorder(BorderFactory.createLineBorder(colorPanelFondo, 1));
        }
        listaTextoSeleccionado.clear();

        for (JTextField jTxt : listaTextoGenerado) {
            jTxt.setForeground(new Color(0, 0, 0));
        }

        for (int i = 0; i < listaTexto.length; i++) {
            for (int j = 0; j < listaTexto[0].length; j++) {
                if (listaTexto[i][j] == txt) {
                    for (int k = 0; k < listaTexto.length; k++) { 
                        listaTextoSeleccionado.add(listaTexto[k][j]);
                    }
                    for (int k = 0; k < listaTexto[0].length; k++) {
                        listaTextoSeleccionado.add(listaTexto[i][k]);

                    }
                    int posI = sudoku.subCuadranteActual(i);
                    int posJ = sudoku.subCuadranteActual(j);
                    for (int k = posI - 3; k < posI; k++) {
                        for (int l = posJ - 3; l < posJ; l++) {
                            listaTextoSeleccionado.add(listaTexto[k][l]);
                        }
                    }

                    listaTexto[i][j].setBackground(textoColorFondo2);
                    listaTexto[i][j].setForeground(textoColor2);
                    listaTexto[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                    return;
                }

            }
        }

    }

    public void generarSudoku() {
        limpiarTexto();
        sudoku.generarSudoku();
        int[][] sudokuGenerado = sudoku.getSudoku();
        for (int i = 0; i < listaTexto.length; i++) {
            for (int j = 0; j < listaTexto[0].length; j++) {
                if (sudokuGenerado[i][j] != 0) {
                    listaTexto[i][j].setText(String.valueOf(sudokuGenerado[i][j]));
                    listaTexto[i][j].setForeground(Color.BLACK);
                    listaTextoGenerado.add(listaTexto[i][j]);
                }
            }
        }
    }


    public boolean cargarSudoku() {
        sudoku.limpiarSudoku();
        for (int i = 0; i < listaTexto.length; i++) {
            for (int j = 0; j < listaTexto[0].length; j++) {
                if (!(listaTexto[i][j].getText().isEmpty())) {

                    int num = Integer.valueOf(listaTexto[i][j].getText());
                    if (sudoku.validarColumna(j, num) && sudoku.validarFila(i, num) && sudoku.validarCuadrante(i, j, num)) {
                        sudoku.getSudoku()[i][j] = num;
                        listaTexto[i][j].setForeground(Color.BLACK);
                        listaTextoGenerado.add(listaTexto[i][j]);
                    } else {
                        listaTextoGenerado.clear();
                        JOptionPane.showMessageDialog(null, "Sudoku Incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                } else {
                    listaTexto[i][j].setBackground(textoColorFondo1);
                    listaTexto[i][j].setForeground(textoColor1);
                    listaTexto[i][j].setBorder(BorderFactory.createLineBorder(colorPanelFondo, 1));
                }
            }
        }
        return true;

    }

    public void limpiarTexto() {
        for (int i = 0; i < listaTexto.length; i++) {
            for (int j = 0; j < listaTexto[0].length; j++) {
                listaTexto[i][j].setText("");
                listaTexto[i][j].setBackground(textoColorFondo1);
                listaTexto[i][j].setForeground(textoColor1);
                listaTexto[i][j].setBorder(BorderFactory.createLineBorder(colorPanelFondo, 1));

            }
        }
        listaTextoGenerado.clear();
    }


    public void comprobar() {
        int sudo[][] = new int[9][9];
        for (int i = 0; i < listaTexto.length; i++) {
            for (int j = 0; j < listaTexto[0].length; j++) {
                if (listaTexto[i][j].getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Sudoku incompleto", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    sudo[i][j] = Integer.parseInt(listaTexto[i][j].getText());
                }
            }
        }
        sudoku.setSudoku(sudo);
        if (sudoku.comprobarSudoku()) {
            JOptionPane.showMessageDialog(null, "Sudoku correcto", "Sudoku", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Solución incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    public void resolver(){
        sudoku.limpiarSudoku();
        for (int i = 0; i < listaTexto.length; i++) {
            for (int j = 0; j < listaTexto[0].length; j++) {
                for (JTextField txt:listaTextoGenerado) {
                    if(txt==listaTexto[i][j]){
                        sudoku.getSudoku()[i][j]=Integer.parseInt(txt.getText());
                    }
                }
            }
        }
        
        if(sudoku.resolverSudoku()){
            for (int i = 0; i < listaTexto.length; i++) {
                for (int j = 0; j < listaTexto[0].length; j++) {
                    listaTexto[i][j].setText(String.valueOf(sudoku.getSudoku()[i][j]));
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"No hay solución","Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public Sudoku getSudoku() {
        return sudoku;
    }

    public void setSudoku(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

    public ArrayList<JTextField> getListaTextoSeleccionado() {
        return listaTextoSeleccionado;
    }

    public void setListaTextoSeleccionado(ArrayList<JTextField> listaTextoSeleccionado) {
        this.listaTextoSeleccionado = listaTextoSeleccionado;
    }

    public JTextField[][] getListaTexto() {
        return listaTexto;
    }

    public void setListaTexto(JTextField[][] listaTexto) {
        this.listaTexto = listaTexto;
    }

    public int getTextoAncho() {
        return textoAncho;
    }

    public void setTextoAncho(int textoAncho) {
        this.textoAncho = textoAncho;
    }

    public int getTextoAltura() {
        return textoAltura;
    }

    public void setTextoAltura(int textoAltura) {
        this.textoAltura = textoAltura;
    }

    public int getTextoMargen() {
        return textoMargen;
    }

    public void setTextoMargen(int textoMargen) {
        this.textoMargen = textoMargen;
    }

    public int getTamanioLetra() {
        return tamanioLetra;
    }

    public void setTamanioLetra(int tamanioLetra) {
        this.tamanioLetra = tamanioLetra;
    }

    public Color getColorPanelFondo() {
        return colorPanelFondo;
    }

    public void setColorPanelFondo(Color colorPanelFondo) {
        this.colorPanelFondo = colorPanelFondo;
    }

    public Color getTextoColorFondo1() {
        return textoColorFondo1;
    }

    public void setTextoColorFondo1(Color textoColorFondo1) {
        this.textoColorFondo1 = textoColorFondo1;
    }

    public Color getTextoColor1() {
        return textoColor1;
    }

    public void setTextoColor1(Color textoColor1) {
        this.textoColor1 = textoColor1;
    }

    public Color getTextoColorFondo2() {
        return textoColorFondo2;
    }

    public void setTextoColorFondo2(Color textoColorFondo2) {
        this.textoColorFondo2 = textoColorFondo2;
    }

    public Color getTextoColor2() {
        return textoColor2;
    }

    public void setTextoColor2(Color textoColor2) {
        this.textoColor2 = textoColor2;
    }

}
