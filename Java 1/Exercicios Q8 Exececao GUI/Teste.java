package classes;

//Pedro Cristovao

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JScrollPane;

public class Teste implements ActionListener{
    
    private static BDVeiculos bd = new BDVeiculos();
    
    static Teste tst = new Teste(); 
    
    // Elementos Tela inaicial
    static JFrame formGestaoVeiculos = new JFrame();
    static JButton btPasseio = new JButton();
    static JButton btCarga = new JButton();
    static JButton btSairSistma = new JButton();
    
    // Elementos Menu Veiculos de passeio   
    static JFrame formMenuPasseio = new JFrame();
    static JButton btMenuPasseioCadastrar = new JButton();
    static JButton btMenuPasseioConsultar = new JButton();
    static JButton btMenuPasseioImprimir = new JButton();
    static JButton btMenuPasseioSair = new JButton();
    
    // Elementos de campos em comum Passeio e Carga
    static JLabel lblPlaca = new JLabel(); 
    static JTextField txtPlaca = new JTextField(8);
    static JLabel lblMarca = new JLabel();
    static JTextField txtMarca = new JTextField(8);
    static JLabel lblModelo = new JLabel();
    static JTextField txtModelo = new JTextField(8);
    static JLabel lblCor = new JLabel();
    static JTextField txtCor = new JTextField(8);
    static JLabel lblQtdRodas = new JLabel();
    static JTextField txtQtdRodas = new JTextField(8);
    static JLabel lblVelocMax = new JLabel();
    static JTextField txtVelocMax = new JTextField(8);
    static JLabel lblQtdPistoes = new JLabel();
    static JTextField txtQtdPistoes = new JTextField(8);
    static JLabel lblPotencia = new JLabel();
    static JTextField txtPotencia = new JTextField(8);
    
    // Elementos Cadastro de Passeio
    static JFrame formCadastroPasseio = new JFrame();
    static JLabel lblQtdPassageiros = new JLabel();
    static JTextField txtQtdPassageiros = new JTextField(8);
    static JButton btCadastrarPasseio = new JButton();
    static JButton btLimparPasseio = new JButton();
    static JButton btNovoPasseio = new JButton();
    static JButton btSairPasseio = new JButton();
    
    // Elementos Consultar / Excluir Passeio
    static JFrame formConsularExcPasseio = new JFrame();
    static JButton btConsExcPasseioConsultar = new JButton();
    static JButton btConsExcPasseioExcluir = new JButton();
    static JButton btConsExcPasseioSair = new JButton();  
    
    // Elementos Imprimir/Excluir todos Passeio (com tabela)
    static JFrame formImprimirPasseio = new JFrame();
    static JButton btImprimiPasseio = new JButton();
    static JButton btExcluirTodos = new JButton();
    static JButton btSairDaJanImprimir = new JButton();
    static DefaultTableModel modeloTabelaPasseio;
    static JTable tabelaPasseio;
    static JScrollPane barraRolagemTabPasseio;
    
    // Elementos Menu Veiculos de Carga   
    static JFrame formMenuCarga = new JFrame();
    static JButton btMenuCargaCadastrar = new JButton();
    static JButton btMenuCargaConsultar = new JButton();
    static JButton btMenuCargaImprimir = new JButton();
    static JButton btMenuCargaSair = new JButton();
    
    // Elementos Cadastro de Carga
    static JFrame formCadastroCarga = new JFrame();
    static JLabel lblTara = new JLabel();
    static JTextField txtTara = new JTextField(8);
    static JLabel lblCargaMaxima = new JLabel(); 
    static JTextField txtCargaMaxima = new JTextField(8);
    static JButton btCadastrarCarga = new JButton();
    static JButton btLimparCarga = new JButton();
    static JButton btNovoCarga = new JButton();
    static JButton btSaircCarga = new JButton();
    
    // Elementos Consultar / Excluir Carga
    static JFrame formConsularExcCarga = new JFrame();
    static JButton btConsExcCargaConsultar = new JButton();
    static JButton btConsExcCargaExcluir = new JButton();
    static JButton btConsExcCargaSair = new JButton();  
    
    // Elementos Imprimir/Excluir todos Carga(com tabela)
    static JFrame formImprimirCarga = new JFrame();
    static JButton btImprimiCarga = new JButton();
    static JButton btExcluirTodosCarga = new JButton();
    static JButton btSairDaJanImprimirCarga = new JButton();
    static DefaultTableModel modeloTabelaCarga;
    static JTable tabelaCarga;
    static JScrollPane barraRolagemTabCarga;
    
    public static void janelaInicial(){
        formGestaoVeiculos.setSize(300, 200);
        formGestaoVeiculos.setTitle("Gestão de Veículos");
        formGestaoVeiculos.setLocationRelativeTo(null);
        
        btPasseio.setText("Passeio");
        btPasseio.setMnemonic('P');
        btPasseio.addActionListener(tst);
        
        btCarga.setText("Carga");
        btCarga.setMnemonic('C');
        btCarga.addActionListener(tst);
        
        btSairSistma.setText("Sair");
        btSairSistma.setMnemonic('S');
        btSairSistma.addActionListener(tst);
        
        formGestaoVeiculos.add(btPasseio);
        formGestaoVeiculos.add(btCarga);
        formGestaoVeiculos.add(btSairSistma);
        
        formGestaoVeiculos.setLayout(new FlowLayout());
        formGestaoVeiculos.setVisible(true);
    }
     
    /*######################  Janelas Passeio  ################################*/
    
    public static void janelaMenuPasseio(){
        formMenuPasseio.setSize(300, 200);
        formMenuPasseio.setTitle("Veiculos de Passeio");
        formMenuPasseio.setLocationRelativeTo(null);
        
        btMenuPasseioCadastrar.setText("Cadastrar");
        btMenuPasseioCadastrar.addActionListener(tst);
        
        btMenuPasseioConsultar.setText("Consultar");
        btMenuPasseioConsultar.addActionListener(tst);
        
        btMenuPasseioImprimir.setText("Imprimir");
        btMenuPasseioImprimir.addActionListener(tst);
        
        btMenuPasseioSair.setText("Sair");
        btMenuPasseioSair.addActionListener(tst);
        
        formMenuPasseio.add(btMenuPasseioCadastrar);
        formMenuPasseio.add(btMenuPasseioConsultar);
        formMenuPasseio.add(btMenuPasseioImprimir);
        formMenuPasseio.add(btMenuPasseioSair);
        
        formMenuPasseio.setLayout(new FlowLayout());
        formMenuPasseio.setVisible(true);
    }
    
    public static void janelaCadastroPasseio(){
        formCadastroPasseio.setSize(535, 141);
        formCadastroPasseio.setTitle("Cadastro de Passeio");
        formCadastroPasseio.setLocationRelativeTo(null);
        
        lblQtdPassageiros.setText("Qtd. Passageiros:");
        lblPlaca.setText("Placa:");
        lblMarca.setText("Marca:");
        lblModelo.setText("Modelo:");
        lblCor.setText("Cor:");
        lblQtdRodas.setText("Qtd. Rodas:");
        lblVelocMax.setText("Velocidade Max:");
        lblQtdPistoes.setText("Qtd. Pistões:");
        lblPotencia.setText("Potência:");
        
        btCadastrarPasseio.setText("Cadastrar");
        btLimparPasseio.setText("Limpar");
        btNovoPasseio.setText("Novo");
        btSairPasseio.setText("Sair");
        
        btCadastrarPasseio.setMnemonic('C');
        btLimparPasseio.setMnemonic('L');
        btNovoPasseio.setMnemonic('N');
        btSairPasseio.setMnemonic('S');
        
        btCadastrarPasseio.addActionListener(tst);
        btLimparPasseio.addActionListener(tst);
        btNovoPasseio.addActionListener(tst);
        btSairPasseio.addActionListener(tst);
        
        btCadastrarPasseio.setEnabled(false);
        btLimparPasseio.setEnabled(false);
        btNovoPasseio.setEnabled(true);
        
        formCadastroPasseio.add(lblQtdPassageiros);
        formCadastroPasseio.add(txtQtdPassageiros);
        formCadastroPasseio.add(lblPlaca);
        formCadastroPasseio.add(txtPlaca);
        formCadastroPasseio.add(lblMarca);
        formCadastroPasseio.add(txtMarca);
        formCadastroPasseio.add(lblModelo);
        formCadastroPasseio.add(txtModelo);
        formCadastroPasseio.add(lblCor);
        formCadastroPasseio.add(txtCor);
        formCadastroPasseio.add(lblQtdRodas);
        formCadastroPasseio.add(txtQtdRodas);
        formCadastroPasseio.add(lblVelocMax);
        formCadastroPasseio.add(txtVelocMax);
        formCadastroPasseio.add(lblQtdPistoes);
        formCadastroPasseio.add(txtQtdPistoes);
        formCadastroPasseio.add(lblPotencia);
        formCadastroPasseio.add(txtPotencia);
        
        formCadastroPasseio.add(btCadastrarPasseio);
        formCadastroPasseio.add(btLimparPasseio);
        formCadastroPasseio.add(btNovoPasseio);  
        formCadastroPasseio.add(btSairPasseio);
        
        formCadastroPasseio.setLayout(new FlowLayout());
        formCadastroPasseio.setVisible(true); 
        
        habilitaCaixasTexto(false, new Passeio());
        limparCaixasTexto(new Passeio());
    }
   
    public static void janelaConsultarExcluirPasseio(){
        formConsularExcPasseio.setSize(535, 141);
        formConsularExcPasseio.setTitle("Consultar/Excluir Passeio");
        formConsularExcPasseio.setLocationRelativeTo(null);
        
        lblQtdPassageiros.setText("Qtd. Passageiros:");
        lblPlaca.setText("Placa:");
        lblMarca.setText("Marca:");
        lblModelo.setText("Modelo:");
        lblCor.setText("Cor:");
        lblQtdRodas.setText("Qtd. Rodas:");
        lblVelocMax.setText("Velocidade Max:");
        lblQtdPistoes.setText("Qtd. Pistões:");
        lblPotencia.setText("Potência:");
        
        btConsExcPasseioConsultar.setText("Consultar");
        btConsExcPasseioExcluir.setText("Excluir");
        btConsExcPasseioSair.setText("Sair");
        
        btConsExcPasseioConsultar.setMnemonic('C');
        btConsExcPasseioExcluir.setMnemonic('E');
        btConsExcPasseioSair.setMnemonic('S');
        
        btConsExcPasseioConsultar.addActionListener(tst);
        btConsExcPasseioExcluir.addActionListener(tst);
        btConsExcPasseioSair.addActionListener(tst);
        btConsExcPasseioExcluir.setEnabled(false);
        
        formConsularExcPasseio.add(lblPlaca);
        formConsularExcPasseio.add(txtPlaca);
        formConsularExcPasseio.add(lblQtdPassageiros);
        formConsularExcPasseio.add(txtQtdPassageiros);
        formConsularExcPasseio.add(lblMarca);
        formConsularExcPasseio.add(txtMarca);
        formConsularExcPasseio.add(lblModelo);
        formConsularExcPasseio.add(txtModelo);
        formConsularExcPasseio.add(lblCor);
        formConsularExcPasseio.add(txtCor);
        formConsularExcPasseio.add(lblQtdRodas);
        formConsularExcPasseio.add(txtQtdRodas);
        formConsularExcPasseio.add(lblVelocMax);
        formConsularExcPasseio.add(txtVelocMax);
        formConsularExcPasseio.add(lblQtdPistoes);
        formConsularExcPasseio.add(txtQtdPistoes);
        formConsularExcPasseio.add(lblPotencia);
        formConsularExcPasseio.add(txtPotencia);
        
        formConsularExcPasseio.add(btConsExcPasseioConsultar);
        formConsularExcPasseio.add(btConsExcPasseioExcluir);
        formConsularExcPasseio.add(btConsExcPasseioSair);
        
        formConsularExcPasseio.setLayout(new FlowLayout());
        formConsularExcPasseio.setVisible(true);  
        limparCaixasTexto(new Passeio());
        habilitaCaixasTexto(false, new Passeio());
        txtPlaca.setEnabled(true);
    }
    
    public static void janelaImprimirExcluirTodosPasseio(){
        formImprimirPasseio = new JFrame();
        formImprimirPasseio.setTitle("Imprimir / Excluir Todos");
        formImprimirPasseio.setSize(550, 250);
        formImprimirPasseio.setLocationRelativeTo(null);
       
        modeloTabelaPasseio = new DefaultTableModel();
        tabelaPasseio = new JTable(modeloTabelaPasseio);
        barraRolagemTabPasseio = new JScrollPane(tabelaPasseio);
        
        btImprimiPasseio = new JButton();
        btExcluirTodos = new JButton();
        btSairDaJanImprimir = new JButton(); 

        modeloTabelaPasseio.addColumn("Placa");
        modeloTabelaPasseio.addColumn("Marca");
        modeloTabelaPasseio.addColumn("Modelo");
        modeloTabelaPasseio.addColumn("Cor");
        modeloTabelaPasseio.addColumn("Qtd. Rodas");
        modeloTabelaPasseio.addColumn("Veloc. Max");
        modeloTabelaPasseio.addColumn("Qtd Pist.");
        modeloTabelaPasseio.addColumn("Potenc.");
        modeloTabelaPasseio.addColumn("Qtd. Passag.");
     
        tabelaPasseio.setPreferredScrollableViewportSize(new Dimension(480, 150));
        
        formImprimirPasseio.add(barraRolagemTabPasseio);
        
        btImprimiPasseio.setText("Imprimir Todos");
        btImprimiPasseio.setMnemonic('I');
        btExcluirTodos.setText("Excluir Todos");
        btExcluirTodos.setMnemonic('E');
        btSairDaJanImprimir.setText("Sair");
        btSairSistma.setMnemonic('S');
       
        btImprimiPasseio.addActionListener(tst);
        btExcluirTodos.addActionListener(tst);
        btSairDaJanImprimir.addActionListener(tst);
        btImprimiPasseio.setEnabled(true);
        
        formImprimirPasseio.add(btImprimiPasseio);
        formImprimirPasseio.add(btExcluirTodos);
        formImprimirPasseio.add(btSairDaJanImprimir);
        
        formImprimirPasseio.setLayout(new FlowLayout());
        formImprimirPasseio.setVisible(true);
    }
    
    /*######################## Janelas Carga #################################*/
    
    public static void janelaMenuCarga(){
        formMenuCarga.setSize(300, 200);
        formMenuCarga.setTitle("Veiculos de Carga");
        formMenuCarga.setLocationRelativeTo(null);
        
        btMenuCargaCadastrar.setText("Cadastrar");
        btMenuCargaCadastrar.addActionListener(tst);
        
        btMenuCargaConsultar.setText("Consultar");
        btMenuCargaConsultar.addActionListener(tst);
        
        btMenuCargaImprimir.setText("Imprimir");
        btMenuCargaImprimir.addActionListener(tst);
        
        btMenuCargaSair.setText("Sair");
        btMenuCargaSair.addActionListener(tst);
        
        formMenuCarga.add(btMenuCargaCadastrar);
        formMenuCarga.add(btMenuCargaConsultar);
        formMenuCarga.add(btMenuCargaImprimir);
        formMenuCarga.add(btMenuCargaSair);
        
        formMenuCarga.setLayout(new FlowLayout());
        formMenuCarga.setVisible(true);
    }
    
    public static void janelaCadastroCarga(){
        formCadastroCarga.setSize(535, 141);
        formCadastroCarga.setTitle("Cadastro de Carga");
        formCadastroCarga.setLocationRelativeTo(null);        
        
        lblTara.setText("Tara");
        lblCargaMaxima.setText("Carga Máx.");
        lblPlaca.setText("Placa:");
        lblMarca.setText("Marca:");
        lblModelo.setText("Modelo:");
        lblCor.setText("Cor:");
        lblQtdRodas.setText("Qtd. Rodas:");
        lblVelocMax.setText("Veloc. Max:");
        lblQtdPistoes.setText("Qtd. Pistões:");
        lblPotencia.setText("Potência:");
        
        btCadastrarCarga.setText("Cadastrar");
        btLimparCarga.setText("Limpar");
        btNovoCarga.setText("Novo");
        btSaircCarga.setText("Sair");
        
        btCadastrarCarga.setMnemonic('C');
        btLimparCarga.setMnemonic('L');
        btNovoCarga.setMnemonic('N');
        btSaircCarga.setMnemonic('S');
        
        btCadastrarCarga.addActionListener(tst);
        btLimparCarga.addActionListener(tst);
        btNovoCarga.addActionListener(tst);
        btSaircCarga.addActionListener(tst);
        
        btCadastrarCarga.setEnabled(false);
        btLimparCarga.setEnabled(false);
        btNovoCarga.setEnabled(true);
        
        formCadastroCarga.add(lblTara);
        formCadastroCarga.add(txtTara);
        formCadastroCarga.add(lblCargaMaxima);
        formCadastroCarga.add(txtCargaMaxima);
        formCadastroCarga.add(lblPlaca);
        formCadastroCarga.add(txtPlaca);
        formCadastroCarga.add(lblMarca);
        formCadastroCarga.add(txtMarca);
        formCadastroCarga.add(lblModelo);
        formCadastroCarga.add(txtModelo);
        formCadastroCarga.add(lblCor);
        formCadastroCarga.add(txtCor);
        formCadastroCarga.add(lblQtdRodas);
        formCadastroCarga.add(txtQtdRodas);
        formCadastroCarga.add(lblVelocMax);
        formCadastroCarga.add(txtVelocMax);
        formCadastroCarga.add(lblQtdPistoes);
        formCadastroCarga.add(txtQtdPistoes);
        formCadastroCarga.add(lblPotencia);
        formCadastroCarga.add(txtPotencia);
        
        formCadastroCarga.add(btCadastrarCarga);
        formCadastroCarga.add(btLimparCarga);
        formCadastroCarga.add(btNovoCarga);  
        formCadastroCarga.add(btSaircCarga);
        
        formCadastroCarga.setLayout(new FlowLayout());
        formCadastroCarga.setVisible(true); 
        
        habilitaCaixasTexto(false, new Carga());
        limparCaixasTexto(new Carga());
    }
   
    public static void janelaConsultarExcluirCarga(){
        formConsularExcCarga.setSize(535, 141);
        formConsularExcCarga.setTitle("Consultar/Excluir Carga");
        formConsularExcCarga.setLocationRelativeTo(null);
        
        lblTara.setText("Tara");
        lblCargaMaxima.setText("Carga Máx.");
        lblPlaca.setText("Placa:");
        lblMarca.setText("Marca:");
        lblModelo.setText("Modelo:");
        lblCor.setText("Cor:");
        lblQtdRodas.setText("Qtd. Rodas:");
        lblVelocMax.setText("Vel. Max:");
        lblQtdPistoes.setText("Qtd. Pistões:");
        lblPotencia.setText("Potência:");
        
        btConsExcCargaConsultar.setText("Consultar");
        btConsExcCargaExcluir.setText("Excluir");
        btConsExcCargaSair.setText("Sair");
        
        btConsExcCargaConsultar.setMnemonic('C');
        btConsExcCargaExcluir.setMnemonic('E');
        btConsExcCargaSair.setMnemonic('S');
        
        btConsExcCargaConsultar.addActionListener(tst);
        btConsExcCargaExcluir.addActionListener(tst);
        btConsExcCargaSair.addActionListener(tst);
        btConsExcCargaExcluir.setEnabled(false);
        
        formConsularExcCarga.add(lblPlaca);
        formConsularExcCarga.add(txtPlaca);
        
        formConsularExcCarga.add(lblCargaMaxima);
        formConsularExcCarga.add(txtCargaMaxima);
        formConsularExcCarga.add(lblTara);
        formConsularExcCarga.add(txtTara);
        formConsularExcCarga.add(lblMarca);
        formConsularExcCarga.add(txtMarca);
        formConsularExcCarga.add(lblModelo);
        formConsularExcCarga.add(txtModelo);
        formConsularExcCarga.add(lblCor);
        formConsularExcCarga.add(txtCor);
        formConsularExcCarga.add(lblQtdRodas);
        formConsularExcCarga.add(txtQtdRodas);
        formConsularExcCarga.add(lblVelocMax);
        formConsularExcCarga.add(txtVelocMax);
        formConsularExcCarga.add(lblQtdPistoes);
        formConsularExcCarga.add(txtQtdPistoes);
        formConsularExcCarga.add(lblPotencia);
        formConsularExcCarga.add(txtPotencia);
        
        formConsularExcCarga.add(btConsExcCargaConsultar);
        formConsularExcCarga.add(btConsExcCargaExcluir);
        formConsularExcCarga.add(btConsExcCargaSair);
        
        formConsularExcCarga.setLayout(new FlowLayout());
        formConsularExcCarga.setVisible(true);  
        limparCaixasTexto(new Carga());
        habilitaCaixasTexto(false, new Carga());
        txtPlaca.setEnabled(true);
    }

    public static void janelaImprimirExcluirTodosCarga(){
        formImprimirCarga = new JFrame();
        formImprimirCarga.setTitle("Imprimir / Excluir Todos");
        formImprimirCarga.setSize(550, 250);
        formImprimirCarga.setLocationRelativeTo(null);
        
        modeloTabelaCarga = new DefaultTableModel();
        tabelaCarga = new JTable(modeloTabelaCarga);
        barraRolagemTabCarga = new JScrollPane(tabelaCarga);
        btImprimiCarga = new JButton();
        btExcluirTodosCarga = new JButton();
        btSairDaJanImprimirCarga = new JButton(); 
        
        modeloTabelaCarga.addColumn("Placa");
        modeloTabelaCarga.addColumn("Marca");
        modeloTabelaCarga.addColumn("Modelo");
        modeloTabelaCarga.addColumn("Cor");
        modeloTabelaCarga.addColumn("Qtd. Rodas");
        modeloTabelaCarga.addColumn("Veloc. Max");
        modeloTabelaCarga.addColumn("Qtd Pist.");
        modeloTabelaCarga.addColumn("Potenc.");
        modeloTabelaCarga.addColumn("Tara");
        modeloTabelaCarga.addColumn("Carga Máx");
        
        tabelaCarga.setPreferredScrollableViewportSize(new Dimension(480, 150));
        
        formImprimirCarga.add(barraRolagemTabCarga);
        
        btImprimiCarga.setText("Imprimir Todos");
        btImprimiCarga.setMnemonic('I');
        btExcluirTodosCarga.setText("Excluir Todos");
        btExcluirTodosCarga.setMnemonic('E');
        btSairDaJanImprimirCarga.setText("Sair");
        btSairDaJanImprimirCarga.setMnemonic('S');
       
        btImprimiCarga.addActionListener(tst);
        btExcluirTodosCarga.addActionListener(tst);
        btSairDaJanImprimirCarga.addActionListener(tst);
        btImprimiCarga.setEnabled(true);
        
        formImprimirCarga.add(btImprimiCarga);
        formImprimirCarga.add(btExcluirTodosCarga);
        formImprimirCarga.add(btSairDaJanImprimirCarga);
        
        formImprimirCarga.setLayout(new FlowLayout());
        formImprimirCarga.setVisible(true);
    }
    
    /*###################### Validação de campos #############################*/
    
    public static void limparCaixasTexto(Veiculo v){
        
        if (v instanceof Passeio){
            txtQtdPassageiros.setText("");
        } else
        if (v instanceof Carga){
            txtCargaMaxima.setText("");
            txtTara.setText("");
        }
        
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtCor.setText("");
        txtQtdRodas.setText("");
        txtVelocMax.setText("");
        txtQtdPistoes.setText("");
        txtPotencia.setText("");
    }
    
    public static void habilitaCaixasTexto(boolean habilita, Veiculo v){
        
        if (v instanceof Passeio){
            txtQtdPassageiros.setEnabled(habilita);
        } else
        if (v instanceof Carga){
            txtCargaMaxima.setEnabled(habilita);
            txtTara.setEnabled(habilita);
        }
        
        txtPlaca.setEnabled(habilita);
        txtMarca.setEnabled(habilita);
        txtModelo.setEnabled(habilita);
        txtCor.setEnabled(habilita);
        txtQtdRodas.setEnabled(habilita);
        txtVelocMax.setEnabled(habilita);
        txtQtdPistoes.setEnabled(habilita);
        txtPotencia.setEnabled(habilita);
    }
    
    public static boolean haCamposVazios(Veiculo v, JFrame janela){
        boolean vazio = false;
        String campoVazio = "";
        
        if (v instanceof Passeio){
            if(txtQtdPassageiros.getText().isEmpty())
                campoVazio = campoVazio + " - Qtd Passageiro";
        } else
        if (v instanceof Carga){
            if(txtCargaMaxima.getText().isEmpty())campoVazio = campoVazio + " - Carga Max";     
            if(txtTara.getText().isEmpty())campoVazio = campoVazio + " - Tara";       
        }

        if(txtMarca.getText().isEmpty())
            campoVazio = campoVazio + " - Marca";
        if(txtModelo.getText().isEmpty());
            campoVazio = campoVazio + " - Modelo";
        if(txtCor.getText().isEmpty());
            campoVazio = campoVazio + " - Cor";
        if(txtQtdRodas.getText().isEmpty());
            campoVazio = campoVazio + " - Rodas";
        if(txtVelocMax.getText().isEmpty());
            campoVazio = campoVazio + " - Veloc. Max.";
        if(txtQtdPistoes.getText().isEmpty());
            campoVazio = campoVazio + " - Pistões";
        if(txtPotencia.getText().isEmpty());
            campoVazio = campoVazio + " - Potência";
        
        if (campoVazio != ""){
            JOptionPane.showMessageDialog(janela, 
                "Preencha os campos:"+campoVazio+"!", "Atenção!", 
                 JOptionPane.WARNING_MESSAGE);
            vazio = true;
        }
        return vazio;      
    }
   
    public static boolean campoNumericoInvalido(JTextField campo){
        int valor = 0;
        boolean erro = true;
        
        try{
            valor = Integer.parseInt(campo.getText());
            erro = false;
        }catch(NumberFormatException nfe){
            valor = 0;
        }
        return erro;
    }
    
    public static boolean haCamposNumericosInvalidos(Veiculo v, JFrame janela){
        int valor = 0;
        String camposInvalidos = "";
        boolean erro = false;
        
        if (v instanceof Passeio){
            if (campoNumericoInvalido(txtQtdPassageiros)){
                camposInvalidos = camposInvalidos + " - Passageiros";
            }
        } else
        if (v instanceof Carga){
            if (campoNumericoInvalido(txtCargaMaxima)){
                camposInvalidos = camposInvalidos + " - Carga Max.";
            } 
            if (campoNumericoInvalido(txtTara)){
                camposInvalidos = camposInvalidos + " - Tara";
            }        
        }
        
        if (campoNumericoInvalido(txtQtdRodas)){
            camposInvalidos = camposInvalidos + " - Qtd. Rodas";
        }
        if (campoNumericoInvalido(txtVelocMax)){
            camposInvalidos = camposInvalidos + " - Veloc. Máx";
        }
        if (campoNumericoInvalido(txtQtdPistoes)){
            camposInvalidos = camposInvalidos + " - Qtd. Pistões";
        }
        if (campoNumericoInvalido(txtPotencia)){
            camposInvalidos = camposInvalidos + " - Potência";
        }

        if (camposInvalidos != ""){
            JOptionPane.showMessageDialog(janela, 
                "Valores númericos inválidos para :"+camposInvalidos+"!", "Atenção!", 
                 JOptionPane.WARNING_MESSAGE);
            erro = true;
        }
        return erro;
    }
    
    public void actionPerformed(ActionEvent evt){

        // ############## Botoes Menu Inicial ##############
        
        if (evt.getSource().equals(btPasseio)){
           janelaMenuPasseio();
        }
       
        if (evt.getSource().equals(btCarga)){
           janelaMenuCarga();
        }
       
        if (evt.getSource().equals(btSairSistma)){
           System.exit(0);
        }
       
        // ############## Botões Menu Passeio ##############
       
        if (evt.getSource().equals(btMenuPasseioCadastrar)){
            janelaCadastroPasseio();
        }
       
        if (evt.getSource().equals(btMenuPasseioConsultar)){
            janelaConsultarExcluirPasseio();
        }
       
        if (evt.getSource().equals(btMenuPasseioImprimir)){
           janelaImprimirExcluirTodosPasseio();
        }
       
        if (evt.getSource().equals(btMenuPasseioSair)){
            formMenuPasseio.dispose();
        }
       
        //############## Botões Janela Cadastrar Passeio ##############
       
        if (evt.getSource().equals(btCadastrarPasseio)){
            Passeio p = new Passeio();
            if (!haCamposVazios(p, formCadastroPasseio)&&(!haCamposNumericosInvalidos(p, formCadastroPasseio))){  
                p.setPlaca(txtPlaca.getText()); 
                p.setMarca(txtMarca.getText());
                p.setModelo(txtModelo.getText());
                p.setCor(txtCor.getText());
                p.setQtdRodas(Integer.parseInt(txtQtdRodas.getText()));
                p.setQtdePassageiros(Integer.parseInt(txtQtdPassageiros.getText()));
                p.getMotor().setQtdPist(Integer.parseInt(txtQtdPistoes.getText()));
                p.getMotor().setPotencia(Integer.parseInt(txtPotencia.getText()));
                
                try{
                    p.setVelocMax(Integer.parseInt(txtVelocMax.getText()));
                }
                catch(VelocException exceptionVelocidadeMaxima){
                    exceptionVelocidadeMaxima.concertaVelocMax(p, 100);
                }

                try{
                    if (bd.cadPasseio(p)){
                        JOptionPane.showMessageDialog(formCadastroPasseio, 
                            "Cadastrado com sucesso!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                        habilitaCaixasTexto(false, p);
                        btCadastrarPasseio.setEnabled(false);
                        btLimparPasseio.setEnabled(false);
                        btNovoPasseio.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(formCadastroPasseio, 
                            "Não foi possível cadastrar o veículo!", "Atenção!", JOptionPane.WARNING_MESSAGE);
                    }       
                }catch(VeicExistException exectionVeiculoExiste){
                    JOptionPane.showMessageDialog(formCadastroPasseio, "Veiculo já está cadastado!", 
                               "Atenção!", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
       
        if (evt.getSource().equals(btLimparPasseio)){
           limparCaixasTexto(new Passeio());
           txtQtdPassageiros.requestFocus();
        }
        
        if (evt.getSource().equals(btNovoPasseio)){
            btCadastrarPasseio.setEnabled(true);
            btLimparPasseio.setEnabled(true);
            btNovoPasseio.setEnabled(false);
            habilitaCaixasTexto(true, new Passeio());
            limparCaixasTexto(new Passeio());
            txtQtdPassageiros.requestFocus();
        }
       
        if (evt.getSource().equals(btSairPasseio)){
           formCadastroPasseio.dispose();
        } 
      
        //############## Botões Janela Consultar/excluir Passeio ##############
    
        if (evt.getSource().equals(btConsExcPasseioConsultar)){
            Passeio p = new Passeio();

            if (txtPlaca.getText().isEmpty()){
                JOptionPane.showMessageDialog(formConsularExcPasseio, "Digite a placa!", 
                               "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                p.setPlaca(txtPlaca.getText());

                if (bd.pesquisaPasseio(p) != null){
                    p = bd.pesquisaPasseio(p);
                    txtQtdPassageiros.setText(Integer.toString(p.getQtdePassageiros()));
                    txtMarca.setText(p.getMarca());
                    txtModelo.setText(p.getModelo());
                    txtCor.setText(p.getCor());
                    txtQtdRodas.setText(Integer.toString(p.getQtdRodas()));
                    txtVelocMax.setText(Integer.toString(p.getVelocMax()));
                    txtQtdPistoes.setText(Integer.toString(p.getMotor().getQtdPist()));
                    txtPotencia.setText(Integer.toString(p.getMotor().getPotencia()));
                    habilitaCaixasTexto(false, p);
                    btConsExcPasseioExcluir.setEnabled(true);
                } else {
                   JOptionPane.showMessageDialog(formConsularExcPasseio, "Veiculo Não cadastrado!", 
                               "Atenção!", JOptionPane.WARNING_MESSAGE); 
                }
            }
        }

        if (evt.getSource().equals(btConsExcPasseioExcluir)){
           Passeio p = new Passeio(); 
            
            if (txtPlaca.getText().isEmpty()){
                JOptionPane.showMessageDialog(formConsularExcPasseio, "Digite a placa!", 
                   "Atenção!", JOptionPane.WARNING_MESSAGE);
                txtPlaca.requestFocus();
            } else {
                p.setPlaca(txtPlaca.getText());
               
                if (bd.pesquisaPasseio(p) != null){
                    
                    int respConfExclusao = JOptionPane.showConfirmDialog(formConsularExcPasseio, "Confirma exclusão?", 
                            "Confirmação", JOptionPane.YES_NO_OPTION);
                    
                    if (respConfExclusao == 0){
                        if (bd.excPasseioPlaca(p) != null){
                            JOptionPane.showMessageDialog(formConsularExcPasseio, "Veiculo Excluído!!", 
                                 "Atenção!", JOptionPane.WARNING_MESSAGE); 
                            limparCaixasTexto(p);
                            txtPlaca.setEnabled(true);
                            btConsExcPasseioExcluir.setEnabled(false);
                        } else {
                            JOptionPane.showMessageDialog(formConsularExcPasseio, "Erro ao excluir!!!", 
                                "Atenção!", JOptionPane.WARNING_MESSAGE); 
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(formConsularExcPasseio, "Veiculo inexistente!", 
                       "Atenção!", JOptionPane.WARNING_MESSAGE); 
                }
           }
        }

        if (evt.getSource().equals(btConsExcPasseioSair)){
            formConsularExcPasseio.dispose();
        }
        
        //############## Botões Janela Imprimir Excluir Todos Passeio ############
        
        if (evt.getSource().equals(btImprimiPasseio)){
            Passeio p = new Passeio();
            int i = 0;
                                               
            while (p != null){
                p = bd.pesquisaPasseioPorIndice(i);
                if (p != null){
                    modeloTabelaPasseio.insertRow(i, new Object[]{p.getPlaca(),  
                    p.getMarca(), p.getModelo(), p.getCor(), p.getQtdRodas(), p.getVelocMax(),  
                    p.getMotor().getQtdPist(), p.getMotor().getPotencia(), p.getQtdePassageiros()});
                }
                i++; 
            }
            
            if (modeloTabelaPasseio.getRowCount() == 0){
                JOptionPane.showMessageDialog(formImprimirPasseio, "Não veiculos cadastrados!!", 
                   "Atenção!", JOptionPane.WARNING_MESSAGE);
            }
            
            btImprimiPasseio.setEnabled(false);
        }
             
        if (evt.getSource().equals(btExcluirTodos)){
            Passeio p = new Passeio();
            
            if (modeloTabelaPasseio.getRowCount() > 0){      
                int respConfExclusao = JOptionPane.showConfirmDialog(formImprimirPasseio, "Excluir tudo?", 
                    "Confirmação", JOptionPane.YES_NO_OPTION);
                
                    if (respConfExclusao == 0){

                    for (int linha = 0;linha < modeloTabelaPasseio.getRowCount(); linha++){
                        p.setPlaca(tabelaPasseio.getModel().getValueAt(linha, 0).toString());
                        bd.excPasseioPlaca(p);
                    }   
                    modeloTabelaPasseio.setRowCount(0);
                }
            } else {
                JOptionPane.showMessageDialog(formImprimirPasseio, "Ops! Nada aqui para excluir!", 
                   "Atenção!", JOptionPane.WARNING_MESSAGE); 
            }
        }
        
        if (evt.getSource().equals(btSairDaJanImprimir)){
           formImprimirPasseio.dispose();
        }
        
        /*############################ Carga #################################*/
        
        // ############## Botões Menu Carga ##############
       
        if (evt.getSource().equals(btMenuCargaCadastrar)){
            janelaCadastroCarga();
        }
       
        if (evt.getSource().equals(btMenuCargaConsultar)){
            janelaConsultarExcluirCarga();
        }
       
        if (evt.getSource().equals(btMenuCargaImprimir)){
           janelaImprimirExcluirTodosCarga();
        }
       
        if (evt.getSource().equals(btMenuCargaSair)){
            formMenuCarga.dispose();
        }
        
        //############## Botões Janela Cadastrar Carga ##############
       
        if (evt.getSource().equals(btCadastrarCarga)){
            Carga c = new Carga();
            if (!haCamposVazios(c, formCadastroCarga)&&(!haCamposNumericosInvalidos(c, formCadastroCarga))){  
                c.setPlaca(txtPlaca.getText()); 
                c.setMarca(txtMarca.getText());
                c.setModelo(txtModelo.getText());
                c.setCor(txtCor.getText());
                c.setQtdRodas(Integer.parseInt(txtQtdRodas.getText()));
                c.setTara(Integer.parseInt(txtTara.getText()));
                c.setCargaMax(Integer.parseInt(txtCargaMaxima.getText()));
                c.getMotor().setQtdPist(Integer.parseInt(txtQtdPistoes.getText()));
                c.getMotor().setPotencia(Integer.parseInt(txtPotencia.getText()));
                
                try{
                    c.setVelocMax(Integer.parseInt(txtVelocMax.getText()));
                }
                catch(VelocException exceptionVelocidadeMaxima){
                    exceptionVelocidadeMaxima.concertaVelocMax(c, 95);
                }

                try{
                    if (bd.cadCarga(c)){
                        JOptionPane.showMessageDialog(formCadastroCarga, "Cadastrado com sucesso!",
                            "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                        habilitaCaixasTexto(false, c);
                        btCadastrarCarga.setEnabled(false);
                        btLimparCarga.setEnabled(false);
                        btNovoCarga.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(formCadastroCarga, 
                            "Não foi possível cadastrar o veículo!", "Atenção!", JOptionPane.WARNING_MESSAGE);
                    }       
                }catch(VeicExistException exectionVeiculoExiste){
                    JOptionPane.showMessageDialog(formCadastroCarga, "Veiculo já está cadastado!", 
                       "Atenção!", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
       
        if (evt.getSource().equals(btLimparCarga)){
           limparCaixasTexto(new Carga());
           txtTara.requestFocus();
        }
        
        if (evt.getSource().equals(btNovoCarga)){
            btCadastrarCarga.setEnabled(true);
            btLimparCarga.setEnabled(true);
            btNovoCarga.setEnabled(false);
            habilitaCaixasTexto(true, new Carga());
            limparCaixasTexto(new Carga());
            txtTara.requestFocus();
        }
       
        if (evt.getSource().equals(btSaircCarga)){
           formCadastroCarga.dispose();
        }
        
        //############## Botões Janela Consultar/excluir Carga ##############
    
        if (evt.getSource().equals(btConsExcCargaConsultar)){
            Carga c = new Carga();

            if (txtPlaca.getText().isEmpty()){
                JOptionPane.showMessageDialog(formConsularExcCarga, "Digite a placa!", 
                    "Atenção!", JOptionPane.WARNING_MESSAGE);
            } else {
                c.setPlaca(txtPlaca.getText());

                if (bd.pesquisaCarga(c) != null){
                    c = bd.pesquisaCarga(c);
                    txtTara.setText(Integer.toString(c.getTara()));
                    txtCargaMaxima.setText(Integer.toString(c.getCargaMax()));
                    txtMarca.setText(c.getMarca());
                    txtModelo.setText(c.getModelo());
                    txtCor.setText(c.getCor());
                    txtQtdRodas.setText(Integer.toString(c.getQtdRodas()));
                    txtVelocMax.setText(Integer.toString(c.getVelocMax()));
                    txtQtdPistoes.setText(Integer.toString(c.getMotor().getQtdPist()));
                    txtPotencia.setText(Integer.toString(c.getMotor().getPotencia()));
                    habilitaCaixasTexto(false, c);
                    btConsExcCargaExcluir.setEnabled(true);
                } else {
                   JOptionPane.showMessageDialog(formConsularExcCarga, "Veiculo Não cadastrado!", 
                               "Atenção!", JOptionPane.WARNING_MESSAGE); 
                }
            }
        }

        if (evt.getSource().equals(btConsExcCargaExcluir)){
           Carga c = new Carga(); 
            
            if (txtPlaca.getText().isEmpty()){
                JOptionPane.showMessageDialog(formConsularExcCarga, "Digite a placa!", 
                   "Atenção!", JOptionPane.WARNING_MESSAGE);
                txtPlaca.requestFocus();
            } else {
                c.setPlaca(txtPlaca.getText());
               
                if (bd.pesquisaCarga(c) != null){
                    
                    int respConfExclusao = JOptionPane.showConfirmDialog(formConsularExcCarga,  
                        "Confirma exclusão?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    
                    if (respConfExclusao == 0){
                        if (bd.excCargaPlaca(c) != null){
                            JOptionPane.showMessageDialog(formConsularExcCarga, "Veiculo Excluído!!", 
                                 "Atenção!", JOptionPane.WARNING_MESSAGE); 
                            limparCaixasTexto(c);
                            txtPlaca.setEnabled(true);
                            btConsExcCargaExcluir.setEnabled(false);
                        } else {
                            JOptionPane.showMessageDialog(formConsularExcCarga, "Erro ao excluir!!!", 
                                "Atenção!", JOptionPane.WARNING_MESSAGE); 
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(formConsularExcCarga, "Veiculo inexistente!", 
                       "Atenção!", JOptionPane.WARNING_MESSAGE); 
                }
            }
        }
        
        if (evt.getSource().equals(btConsExcCargaSair)){
            formConsularExcCarga.dispose();
        }
        
        //############## Botões Janela Imprimir Excluir Todos Carga ############
        
        if (evt.getSource().equals(btImprimiCarga)){
            Carga c = new Carga();
            int i = 0;
                                               
            while (c != null){
                c = bd.pesquisaCargaPorIndice(i);
                if (c != null){
                    modeloTabelaCarga.insertRow(i, new Object[]{c.getPlaca(),  
                    c.getMarca(), c.getModelo(), c.getCor(), c.getQtdRodas(), c.getVelocMax(),  
                    c.getMotor().getQtdPist(), c.getMotor().getPotencia(), c.getTara(),
                    c.getCargaMax()});
                }
                i++; 
            }
            
            if (modeloTabelaCarga.getRowCount() == 0){
                JOptionPane.showMessageDialog(formImprimirCarga, "Não veiculos cadastrados!!", 
                   "Atenção!", JOptionPane.WARNING_MESSAGE);
            }

            btImprimiCarga.setEnabled(false);
        }
             
        if (evt.getSource().equals(btExcluirTodosCarga)){
            Carga c = new Carga();
            
            if (modeloTabelaCarga.getRowCount() > 0){      
                int respConfExclusao = JOptionPane.showConfirmDialog(formImprimirCarga, "Excluir tudo?", 
                    "Confirmação", JOptionPane.YES_NO_OPTION);
                
                    if (respConfExclusao == 0){

                    for (int linha = 0;linha < modeloTabelaCarga.getRowCount(); linha++){
                        c.setPlaca(tabelaCarga.getModel().getValueAt(linha, 0).toString());
                        bd.excCargaPlaca(c);
                    }   
                    modeloTabelaCarga.setRowCount(0);
                }
            } else {
                JOptionPane.showMessageDialog(formImprimirCarga, "Ops! Nada aqui para excluir!", 
                   "Atenção!", JOptionPane.WARNING_MESSAGE); 
            }
        }
        
        if (evt.getSource().equals(btSairDaJanImprimirCarga)){
           formImprimirCarga.dispose();
        }
    }

    public static void main(String args[]){
        
       janelaInicial();
     
    }
}
