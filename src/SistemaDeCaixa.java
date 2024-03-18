import java.util.HashMap;

public class SistemaDeCaixa {

    
    private HashMap<String, Cliente> bancoDeDados = new HashMap<>();

   
    private HashMap<String, Cliente> cacheDeClientes = new HashMap<>();

    
    public Cliente buscarClientePorCPF(String cpf) {
       
        if (cacheDeClientes.containsKey(cpf)) {
            System.out.println("Cliente encontrado no cache.");
            return cacheDeClientes.get(cpf);
        }

       
        if (bancoDeDados.containsKey(cpf)) {
            
            Cliente cliente = bancoDeDados.get(cpf);
            cacheDeClientes.put(cpf, cliente);
            System.out.println("Cliente encontrado no banco de dados.");
            return cliente;
        } else {
            System.out.println("Cliente não encontrado.");
            return null;
        }
    }

   
    public void adicionarCliente(Cliente cliente) {
        bancoDeDados.put(cliente.getCpf(), cliente);
    }

    public boolean verificarClienteExistente(String cpf) {
        return bancoDeDados.containsKey(cpf);
    }
    
    public static class Cliente {
        private String nome;
        private String cpf;
        private String celular;
        private String email;

        public Cliente(String nome, String cpf, String celular, String email) {
            this.nome = nome;
            this.cpf = cpf;
            this.celular = celular;
            this. email = email;
        }

        public String getNome() {
            return nome;
        }

        public String getCpf() {
            return cpf;
        }

        public String getCelular() {
            return celular;
        }

        public String getEmail() {
            return email;
        }
    }

    //public static void main(String[] args) {
       
       // SistemaDeCaixa sistema = new SistemaDeCaixa();

        //sistema.adicionarCliente(new Cliente("João", "123.456.789-00","8582","ease@gmaill"));


        
        //*Cliente cliente = sistema.buscarClientePorCPF("123.456.789-00");
        //if (cliente != null) {
            //System.out.println("Cliente encontrado: " + cliente.getNome()+cliente.getCpf()+cliente.getCelular()+cliente.getEmail());
        //} else {
            //System.out.println("Cliente não encontrado.");
        
    //}
}
