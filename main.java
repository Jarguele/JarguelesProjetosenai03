public class Main {
    public static void main(String[] args) {
        CadastroClientesModel model = new CadastroClientesModel();
        CadastroClientesView view = new CadastroClientesView();
        CadastroClientesController controller = new CadastroClientesController(model, view);

        controller.executar();
    }
}
