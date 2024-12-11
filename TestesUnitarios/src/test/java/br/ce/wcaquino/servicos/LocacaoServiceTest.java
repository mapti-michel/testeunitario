package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;
//import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.*;

public class LocacaoServiceTest {

    @Test
    public void test() {

        // cenário
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuário 1");
        Filme filme = new Filme("Filme 1", 2, 5.0);


        // ação
        Locacao locacao = service.alugarFilme(usuario, filme);

        // verificação
        Assert.assertThat(locacao.getValor(), is(equalTo(5.0)));// verifique se o valor da locação é igual a 5
        Assert.assertThat(locacao.getValor(), is(not(6.0)));// verifique se o valor da locação é igual a 5

        Assert.assertThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
        Assert.assertThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));


        Assert.assertEquals(5.0,locacao.getValor() == 5.0);



//        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
//        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
    }



}