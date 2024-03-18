import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SistemaDeCaixaGUI extends JFrame {

    private SistemaDeCaixa sistemaDeCaixa;
    private JTextField campoCPF;
    private JTextArea areaDados;

    public SistemaDeCaixaGUI() {
        setTitle("Sistema de Caixa");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sistemaDeCaixa = new SistemaDeCaixa();

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panelBuscar = criarPainelBuscarCliente();
        tabbedPane.addTab("Buscar Cliente", panelBuscar);

        JPanel panelCadastro = criarPainelCadastroCliente();
        tabbedPane.addTab("Cadastro Cliente", panelCadastro);

        add(tabbedPane);
    }

    private JPanel criarPainelBuscarCliente() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelCPF = new JLabel("CPF:");
        campoCPF = new JTextField(15);
        JButton botaoBuscar = new JButton("Buscar");
        areaDados = new JTextArea(10, 30);
        areaDados.setEditable(false);

        botaoBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = campoCPF.getText();
                SistemaDeCaixa.Cliente cliente = sistemaDeCaixa.buscarClientePorCPF(cpf);
                if (cliente != null) {
                    areaDados.setText("Cliente encontrado:\n" +
                            "Nome: " + cliente.getNome() + "\n" +
                            "CPF: " + cliente.getCpf() + "\n" +
                            "Celular: " + cliente.getCelular() + "\n" +
                            "Email: " + cliente.getEmail());
                } else {
                    areaDados.setText("Cliente não encontrado.");
                }
            }
        });

        panel.add(labelCPF);
        panel.add(campoCPF);
        panel.add(botaoBuscar);
        panel.add(new JScrollPane(areaDados));

        return panel;
    }

    private JPanel criarPainelCadastroCliente() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField(15);
        JLabel labelCPF = new JLabel("CPF:");
        JTextField campoNovoCPF = new JTextField(15);
        JLabel labelCelular = new JLabel("Celular:");
        JTextField campoCelular = new JTextField(15);
        JLabel labelEmail = new JLabel("Email:");
        JTextField campoEmail = new JTextField(15);

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                String cpf = campoNovoCPF.getText();
                String celular = campoCelular.getText();
                String email = campoEmail.getText();
                SistemaDeCaixa.Cliente novoCliente = new SistemaDeCaixa.Cliente(nome, cpf, celular, email);
                sistemaDeCaixa.adicionarCliente(novoCliente);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            }
        });

        JButton botaoLimpar = new JButton("Limpar");
        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoNome.setText("");
                campoNovoCPF.setText("");
                campoCelular.setText("");
                campoEmail.setText("");
            }
        });

        panel.add(labelNome);
        panel.add(campoNome);
        panel.add(labelCPF);
        panel.add(campoNovoCPF);
        panel.add(labelCelular);
        panel.add(campoCelular);
        panel.add(labelEmail);
        panel.add(campoEmail);
        panel.add(botaoSalvar);
        panel.add(botaoLimpar);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SistemaDeCaixaGUI().setVisible(true);
            }
        });
    }
}
