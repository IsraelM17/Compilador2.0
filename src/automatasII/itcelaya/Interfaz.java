package automatasII.itcelaya;

import javax.swing.*;
import javax.swing.plaf.synth.ColorType;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Archivos.CargaArchivo;
import Archivos.Delimitadores;
import Archivos.Operadores;
import Archivos.PalabrasReservadas;
import Automatas.AfdCadena;
import Automatas.AfdDigito;
import Automatas.AfdIdentificador;
import Automatas.AfdPR;
import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

public class Interfaz extends JFrame implements ActionListener {

    //Componentes gráficos
    public static JTextArea   txtOutput;
    JMenuBar    menuBar;
    JMenu       menuArchivo, menuAyuda;
    JMenuItem   menuAbrir, menuLenguaje;
    JButton     btnLexico, btnSintactico, btnCode, btnLimpiar;
    JScrollPane spCode, spOutput;
    RSyntaxTextArea txtCode;
    //TablaSimbolos Interfaz
    String[]            nombresColumna 	= {"ID Token","Token","Categoria", "Valor", "Linea"};
    Object[][]          datosSimbolos	= new Object[0][4];
    DefaultTableModel   modeloTabla     = new DefaultTableModel(datosSimbolos, nombresColumna);
    JTable              tablaSimbolos;
    JScrollPane         spTabla;

    CargaArchivo c= new CargaArchivo();
    public static boolean avanzarr = false;
    /**
     * Objeto array list para guardar en la tabla de simbolos
     */
    ArrayList<TablaSimbolosList> arrayList;

    /**
     * Declaracion de variables
     * Objetos para hacer referencia a las clases indicadas.
     */
    PalabrasReservadas  pr;
    Operadores          operador;
    Delimitadores       delimitador;
    AfdIdentificador    id;
    AfdDigito           digito;
    AfdCadena           cadena;
    AfdPR               afdPr;
    AnalizadorSintactico sin;

    /**
     * Variables de prueba para salida de texto ya validadcion de token.
     */
    String token    = "";
    String OutPut   = "", algo="";
    String codigo   = "";

    /*
     *Variables alternativas
     */
    int contadorId          = 51;
    int contadorDigito      = 101;
    int contadorCadena      = 151;

    public Interfaz()
    {
        this.setTitle("Analizador Léxico");
        this.setSize(900, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);

        menuBar         = new JMenuBar();
        menuArchivo     = new JMenu("Archvio");
        menuAyuda       = new JMenu("Ayuda");
        menuAbrir       = new JMenuItem("Abrir");
        menuLenguaje    = new JMenuItem("Lenguaje");

        menuBar.add(menuArchivo);
        menuBar.add(menuAyuda);
        menuArchivo.add(menuAbrir);
        menuAyuda.add(menuLenguaje);

        menuAbrir.addActionListener(this);
        menuLenguaje.addActionListener(this);

        this.setJMenuBar(menuBar);

        panelSuperior();
        panelCentral();
        panelInferior();
    }

    private void panelSuperior()
    {
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout(10));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        panelSuperior.setBackground(Color.white);

        JPanel panelSuperior11 = new JPanel();
        panelSuperior.setLayout(new FlowLayout(10));

        btnLexico       = new JButton("Léxico");
        btnSintactico   = new JButton("Sintáctico");
        btnCode         = new JButton("Guardar Código");
        btnLimpiar      = new JButton("Limpiar");

        btnLexico.setBackground(Color.yellow);
        btnSintactico.setBackground(Color.lightGray);
        btnSintactico.setForeground(Color.black);

        btnLexico.addActionListener(this);
        btnSintactico.addActionListener(this);
        btnCode.addActionListener(this);
        btnLimpiar.addActionListener(this);

        btnSintactico.setEnabled(false);

        panelSuperior11.add(btnLexico);
        panelSuperior11.add(btnSintactico);
        panelSuperior11.add(btnCode);
        panelSuperior11.add(btnLimpiar);
        panelSuperior11.setBackground(Color.white);
        panelSuperior.add(panelSuperior11, BorderLayout.WEST);
        this.getContentPane().add(panelSuperior, BorderLayout.NORTH);
    }

    private void panelCentral()
    {
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(1,2));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panelCentral.setBackground(Color.white);

        txtCode     = new RSyntaxTextArea(20, 60);
        spCode      = new JScrollPane(txtCode);

        tablaSimbolos  = new JTable(modeloTabla);
        spTabla    	   = new JScrollPane(tablaSimbolos);

        txtCode.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        txtCode.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(txtCode);

        panelCentral.add(sp);
        panelCentral.add(spTabla);
        this.getContentPane().add(panelCentral, BorderLayout.CENTER);
        pack();
    }

    private void panelInferior()
    {
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new GridLayout(1,1));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(3,10,3,10));
        panelInferior.setBackground(Color.white);

        txtOutput   = new JTextArea(5,0);
        spOutput    = new JScrollPane(txtOutput);
        spOutput.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

        txtOutput.setForeground(Color.red);
        txtOutput.setEditable(false);

        panelInferior.add(spOutput);
        this.getContentPane().add(panelInferior, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnLexico) {
            Settings.cadenaError = "";
            txtOutput.setText("");
            OutPut = "";
            avanzarr = false;
            arrayList   = new ArrayList();
            codigo      = txtCode.getText();
            //Limpia la tabla de simbolos (Parte gráfica) cada vez que analizamos
            try {
                for (int i = 0; i < tablaSimbolos.getRowCount(); i++) {
                    modeloTabla.removeRow(i);
                    i -= 1;
                }

                for (int i = 0; i< arrayList.size(); i++){
                    arrayList.remove(i);
                }

                analizar();
                if (avanzarr) {
                    btnSintactico.setEnabled(true);
                    btnSintactico.setBackground(Color.yellow);
                    btnLexico.setBackground(Color.green);
                } else {
                    btnLexico.setBackground(Color.red);
                    btnSintactico.setEnabled(false);
                    btnSintactico.setBackground(Color.lightGray);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else if (e.getSource() == btnSintactico){
            Settings.contador = 0;
            Settings.cadena = "";
            Settings.cadenaError = "";

            getDatosTabla();
            JOptionPane.showMessageDialog(null, "Analisis Sintáctico Completo");
            mostrarError();
        }
        else if (e.getSource() == btnLimpiar){
            txtCode.setText("");
            txtOutput.setText("");
            for (int i = 0; i < tablaSimbolos.getRowCount(); i++) {
                modeloTabla.removeRow(i);
                i-=1;
            }
        }
        else if (e.getSource() == menuAbrir){
            /**
             * En este método, permitimos la apertura de un archivo con extensión .txt
             */
            c.abreArchi();
            txtCode.setText("");
            txtCode.setText(c.devolver());
        }
        else if (e.getSource() == menuLenguaje){
            try {
                File path = new File ("lenguaje.pdf");
                Desktop.getDesktop().open(path);
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (e.getSource() == btnCode ){}
    }

    /**
     * Sección de Código. (Lógica del programa)
     */

    private void analizar()throws Exception {

        codigo  =  txtCode.getText();
        token    = "";

        int i           = 0;
        int linea       = 1;

        operador            = new Operadores();
        pr                  = new PalabrasReservadas();
        delimitador         = new Delimitadores();

        do{
            if (i == codigo.length()){
                analizarToken(token, linea);
                token = "";
            }
            //Si se encuentra un espacio se analiza el token obtenido
            else if(Character.toString(codigo.charAt(i)).equals(" ")){
                analizarToken(token, linea);
                token = "";
            }
            //Si se encuentra un salto de línea se analiza el token obtenido
            else if(Character.toString(codigo.charAt(i)).equals("\n")){
                analizarToken(token, linea);
                token = "";
                linea += 1;
            }
            //si se encuentra un # no toma en cuenta nada
            else  if(Character.toString(codigo.charAt(i)).equals("#")){
                //i++;
                while(Character.toString(codigo.charAt(i)).compareTo("\n") != 0)
                    i ++;
                linea += 1;
            }

            else if(delimitador.analizar(Character.toString(codigo.charAt(i)))){
                meterDatosTabla(delimitador.valor,Character.toString(codigo.charAt(i)),"Delimitador","--", linea);
            }
            //En todo caso contrario se van uniendo los chars hasta juntar un token delimitado por las condiciones anteriores
            else
                token += Character.toString(codigo.charAt(i));
            i++;
        }while(i <= codigo.length());
        JOptionPane.showMessageDialog(null,"Análisis Léxico completo");
        txtOutput.setText(OutPut);
        if(txtOutput.getText().equals(""))
            avanzarr = true;
    }

    private void analizarToken(String token, int linea){

        id      = new AfdIdentificador(token);
        digito  = new AfdDigito(token);
        //cadena  = new AfdCadena(token);

        //Primero buscamos si el token analizado se encuentra en nuestro archivo de PalabrasReservadas
        if (pr.analizar(token))
        {
            meterDatosTabla(pr.valor,token,"PR","--", linea);
            System.out.println(token+" es una palabra reservada");
        }
        //En caso contrario se pregunta si el token es un ID
        else if(id.aceptado)
        {
            meterDatosTabla((contadorId), token, "ID","--",linea);
            contadorId += 1;
            System.out.println(token+" es un identificador");
        }
        //En caso contrario se Analiza en el AFDDigito para ver si es aceptado
        else if(token.compareTo("")!=0 && digito.aceptado)
        {
            meterDatosTabla(contadorDigito, token, "DIGITO","--",linea);
            contadorDigito += 1;
            System.out.println(token + " es un dígito");
        }
        //En caso contrario se analiza en el archivo de Operadores
        else if(operador.analizar(token))
        {
            meterDatosTabla(operador.valor,token,"OPERADOR","--", linea);
            System.out.println(token+" es un operador");
        }
        //Si se lee un algo diferente a un espacio por ende no esta en nuestro lenguaje.
        else if(token.compareTo("")!=0){
            OutPut += "Error 69 en linea "+linea+":"+token+" no esta en el lenguaje\n";
            linea += 1;
        }

        else if(token.compareTo("")!=0){
            OutPut += "Error 69 en linea "+linea+":"+token+" no esta en el lenguaje\n";
            linea += 1;
        }

    }

    public void meterDatosTabla(int posicion, String nombre, String categoria, String valor, int linea)
    {
        TablaSimbolosList ts = new TablaSimbolosList();

        ts.setIdToken(posicion);
        ts.setToken(nombre);
        ts.setCategoria(categoria);
        ts.setValor(valor);
        ts.setLinea(linea);
        arrayList.add(ts);

        Object[]  rowInfo = {posicion, nombre, categoria, valor, linea};
        modeloTabla.addRow(rowInfo);
        /*
        if(!buscarToken(nombre, categoria)){

        }
                */
    }

    public void getDatosTabla(){

        int Col = 0;
        for(int r=0;r<tablaSimbolos.getRowCount();r++){
            String value = tablaSimbolos.getValueAt(r,Col).toString();
            Settings.cadena += value+" ";
        }

        Settings.token = Settings.cadena.split(" ");
        System.out.println(Settings.cadena);

        sin = new AnalizadorSintactico();
        sin.lecturaTabla(Settings.cadena);
    }

    public static void mostrarError(){
        System.out.println(Settings.cadenaError);
        txtOutput.setText(Settings.cadenaError);
    }

}
