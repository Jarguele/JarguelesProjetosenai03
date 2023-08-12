import java.util.List;

class CadastroClientesController {
    private CadastroClientesModel model;
    private CadastroClientesView view;

    public CadastroClientesController(CadastroClientesModel model, CadastroClientesView view) {
        this.model = model;
        this.view = view;
    }

    public void executar() {
        int opcao;
        do {
            opcao = view.exibirMenu();

            switch (opcao) {
                case 1:
                    String nome = view.lerNome();
                    String endereco = view.lerEndereco();
                    String matricula = view.lerMatricula();
                    model.inserirCliente(nome, endereco, matricula);
                    view.mostrarMensagem("Cliente inserido com sucesso!");
                    break;
                case 2:
                    matricula = view.lerMatricula();
                    if (model.buscarCliente(matricula)) {
                        view.mostrarMensagem("Cliente com matrícula " + matricula + " foi encontrado.");
                    } else {
                        view.mostrarMensagem("Cliente com matrícula " + matricula + " não foi encontrado.");
                    }
                    break;
                case 3:
                    matricula = view.lerMatricula();
                    if (model.excluirCliente(matricula)) {
                        view.mostrarMensagem("Cliente com matrícula " + matricula + " foi removido.");
                    } else {
                        view.mostrarMensagem("Cliente com matrícula " + matricula + " não foi encontrado.");
                    }
                    break;
                case 4:
                    List<Cliente> listaClientes = model.getListaClientes();
                    view.mostrarLista(listaClientes);
                    break;
                case 5:
                    view.mostrarMensagem("Encerrando o programa...");
                    break;
                default:
                    view.mostrarMensagem("Opção inválida! Tente novamente.");
            }

            System.out.println();
        } while (opcao != 5);
    }
}
