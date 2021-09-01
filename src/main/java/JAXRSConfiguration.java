
import domain.Cliente;
import domain.Equipamento;
import domain.Funcionario;
import domain.OrdemDeServico;
import domain.enums.Funcionarios;
import domain.enums.Status;
import domain.enums.TipoCliente;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures JAX-RS for the application.
 *
 * @author Juneau
 */
@ApplicationPath("app")
public class JAXRSConfiguration extends Application {

    OrdemDeServico os1 = new OrdemDeServico(null, Status.AGUARDANDOAPROVACAO, "https://debrida-projeto-betha.s3.sa-east-1.amazonaws.com/odfoto.jpg");
    OrdemDeServico os2 = new OrdemDeServico(null, Status.APROVADO, "https://debrida-projeto-betha.s3.sa-east-1.amazonaws.com/odfoto.jpg");
    OrdemDeServico os3 = new OrdemDeServico(null, Status.FAZENDOORCAMENENTO, "https://debrida-projeto-betha.s3.sa-east-1.amazonaws.com/odfoto.jpg");
//instançiacão das ordens de servico

    Equipamento eq1 = new Equipamento(null, "bicleta", "caloi", "bicleta infantil", "Corrente arebentada");
    Equipamento eq2 = new Equipamento(null, "computador", "dell", "Computador para escritorio", "Placa mãe queimada");
    Equipamento eq3 = new Equipamento(null, "skate", "tonyhalk", "jogo", "roda quebrada");
//instanciação dos equipamentos

    Cliente cli1 = new Cliente(null, "Joao pedro folchini", "JPFolchini@gmail.com", "15158370095", "4899001122", TipoCliente.PESSOAFISICA);
    Cliente cli2 = new Cliente(null, "vicenzo de faverri", "vicendoFAV@hotmail.com", "27504060000106", "4896119005", TipoCliente.PESSOAJURIDICA);

    Funcionario func1 = new Funcionario(null, Funcionarios.ADMIN, "admin");
    Funcionario func2 = new Funcionario(null, Funcionarios.RECEPCIONISTA, "recepcionista");
    Funcionario func3 = new Funcionario(null, Funcionarios.TECNICO, "tecnico");

    
}
