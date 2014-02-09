package br.com.snbsolucoes.dao;

import br.com.snbsolucoes.modelo.frete.OrigemDestino;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DAOFrete implements Serializable {

    public static BigDecimal vlrICMS;
    private final DAOGenerico dao;

    public DAOFrete() {
        dao = new DAOGenerico();
    }
    
    public void calculaFrete(Integer empresa,
            Integer transportadora,
            Integer familiaProduto,
            Date data,
            BigDecimal vlrNota,
            Integer idOrigemDestino,
            BigDecimal peso,
            BigDecimal percICMS){
            //pIdCalculo  in out number,
            //pVlrCalculado  out number
    
      BigDecimal distancia = BigDecimal.ZERO;
      BigDecimal vlrTotal = BigDecimal.ZERO;
      BigDecimal vlrFrete = BigDecimal.ZERO;
      BigDecimal vlrKgExced = BigDecimal.ZERO;
      BigDecimal pesoCalculo;
      OrigemDestino origemDestino;
        
      vlrICMS = BigDecimal.ZERO;      
      pesoCalculo = peso.compareTo(BigDecimal.ONE) < 1 ? BigDecimal.ONE : peso;
      
      origemDestino = ckOrigDestino(idOrigemDestino);
      ckDtTabFreteTransp(transportadora,familiaProduto,data);
      ckDtTabFreteEmp(transportadora,familiaProduto,empresa,data);
      calcVariaveis(empresa,transportadora,familiaProduto,data,vlrNota,distancia,idOrigemDestino,pesoCalculo,percICMS);
      
    /*
      --
      pAmFrete.CalcVlrFretePeso(pEmpresaProp    => pEmpresaProp,
                                pTransportadora => pTransportadora,
                                pFamiliaProduto => pFamiliaProduto,
                                pData           => pData,
                                pVlrNota        => pVlrNota,
                                pDistancia      => vDistancia,
                                pOrigDestino    => pOrigDestino,
                                pPeso           => vPeso,
                                pPercICMS       => pPercICMS,
                                pIdCalculo      => pIdCalculo,
                                pVlrFrete       => vVlrFrete,
                                pVlrKgExced     => vVlrKgExced);
      --
      -- Insere o valor do ICMS.
      -- =======================
      if  pAmFrete.getICMS is not null
      and pAmFrete.getICMS  > 0
      then
        pAmFrete.setICMS(nvl(round(pAmFrete.getICMS,2),0));
        --
        pAmFrete.GeraMemoriaCalculo(pIdCalculo        => pIdCalculo,
                                    pEmpresaProp      => pEmpresaProp,
                                    pTransportadora   => pTransportadora,
                                    pFamiliaProduto   => pFamiliaProduto,
                                    pData             => pData,
                                    pVlrNota          => pVlrNota,
                                    pDistancia        => vDistancia,
                                    pOrigDestino      => pOrigDestino,
                                    pPeso             => pPeso,
                                    pPercIcms         => pPercIcms,
                                    pFreteVariavel    => pAmFrete.VAR_ICMS_FRETE,
                                    pFretePeso        => null,
                                    pTpFaixa          => null,
                                    pTpCalcValor      => pAmFrete.TP_CALC_PERC_NF,
                                    pVlrVariavel      => pPercIcms,
                                    pVlrResultado     => pAmFrete.getICMS,
                                    pFgIncideIcms     => 'N'); --Não há incidência do ICMS sobre ele mesmo.
      end if;
      --
      pVlrCalculado := nvl(vVlrTotal,       0)
                     + nvl(vVlrFrete,       0)
                     + nvl(vVlrKgExced,     0)
                     + nvl(pAmFrete.getICMS,0);
    end CalculaFrete;
    */
    
    }
    
    public OrigemDestino ckOrigDestino(Integer idOrigDest) {
        Map<String,Object> parametros = new HashMap<String,Object>();
        parametros.put("idOrigDest", idOrigDest);
        return (OrigemDestino) dao.buscarNamedQuery("OrigemDestino.findByIdOrigDest", parametros);
    }
    
    public boolean ckDtTabFreteTransp(Integer transportadora,
            Integer familiaProduto,
            Date data) {
        //TODO Converter o metodo
        return false;
    }
    
    public boolean ckDtTabFreteEmp(Integer transportadora,
            Integer familiaProduto,
            Integer empresa,
            Date data) {
        //TODO Converter o metodo
        return false;
    }
    
    public void calcVariaveis(Integer empresa,
            Integer transportadora,
            Integer familiaProduto,
            Date data,
            BigDecimal vlrNota,
            BigDecimal distancia,
            Integer idOrigemDestino,
            BigDecimal peso,
            BigDecimal percICMS){
            //pIdCalculo  in out number,
            //pVlrCalculado  out number
        //TODO Converter o metodo
    }
}
