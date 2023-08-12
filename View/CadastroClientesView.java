import java.util.List;
import java.util.Scanner;

class CadastroClientesView {
    private Scanner scanner;

    public CadastroClientesView() {
        scanner = new Scanner(System.in);
    }

    public int exibirMenu() {
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Inserir cliente");
        System.out.println("2 - Buscar cliente");
        System.out.println("3 - Excluir cliente");
        System.out.println("4 - Exibir lista");
        System.out.println("5 - Sair");
        return scanner.nextInt();
    }

    public String lerNome() {
        System.out.print("Digite o nome: ");
        return scanner.next();
    }

    public String lerEndereco() {
        System.out.print("Digite o endereço: ");
        return scanner.next();
    }

    public String lerMatricula() {
        System.out.print("Digite a matrícula: ");
        return scanner.next();
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void mostrarLista(List<Cliente> listaClientes) {
        if (listaClientes.isEmpty()) {
            System.out.println("A lista está vazia.");
        } else {
            System.out.println("Lista de clientes:");
            for (Cliente cliente : listaClientes) {
                System.out.println("Nome: " + cliente.getNome() + ", Endereço: " + cliente.getEndereco() + ", Matrícula: " + cliente.getMatricula());
            }
        }
    }
}
