package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Cliente {
    private String nome;
    private String endereco;
    private String matricula;

    public Cliente(String nome, String endereco, String matricula) {
        this.nome = nome;
        this.endereco = endereco;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}

class CadastroClientesModel {
    private List<Cliente> listaClientes;
    private Connection connection;

    public CadastroClientesModel() {
        listaClientes = new ArrayList<>();
        conectarAoBanco();
    }

    private void conectarAoBanco() {
        try {
            String url = "jdbc:mysql://localhost:3306/nome_do_seu_banco";
            String user = "seu_usuario";
            String password = "sua_senha";

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserirCliente(String nome, String endereco, String matricula) {
        String query = "INSERT INTO clientes (nome, endereco, matricula) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nome);
            statement.setString(2, endereco);
            statement.setString(3, matricula);
            statement.executeUpdate();
            System.out.println("Cliente inserido no banco de dados.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métodos para buscar e excluir clientes
    // ...

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
}
