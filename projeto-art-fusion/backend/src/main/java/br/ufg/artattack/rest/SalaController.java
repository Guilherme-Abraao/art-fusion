package br.ufg.artattack.rest;

import br.ufg.artattack.amqp.AbrirSalaConsumidor;
import br.ufg.artattack.amqp.RabbitMQConfig;
import br.ufg.artattack.amqp.ServicoRabbitMQ;
import br.ufg.artattack.amqp.RabbitArtFusionConsumer;
import br.ufg.artattack.dto.AbrirSalaDTO;
import br.ufg.artattack.dto.SalaAbertaWrapper;
import br.ufg.artattack.modelo.Sala;
import br.ufg.artattack.servico.ArteServico;
import br.ufg.artattack.servico.SalaServico;
import br.ufg.artattack.servico.UsuarioServico;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/sala")
public class SalaController {


    @Autowired
    ArteServico arteServico;

    @Autowired
    SalaServico salaServico;

    @Autowired
    ServicoRabbitMQ servicoRabbitMQ;

    @Autowired
    UsuarioServico usuarioServico;

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;


    @PostMapping("/abrir")
    public ResponseEntity<Sala> abrirSala(@RequestBody AbrirSalaDTO abrirSalaDTO) throws Exception {

        SalaAbertaWrapper salaAbertaWrapper = salaServico.abrirSala(abrirSalaDTO.arteId);

        String queueName = salaAbertaWrapper.salaNova.uuid+"."+ salaAbertaWrapper.integranteRequerinte.colaborador.id;

        String especificoBindingKey = ServicoRabbitMQ.getEspecificoBindingKey(salaAbertaWrapper);

        String geralBindKey = ServicoRabbitMQ.getGeralBindingKey(salaAbertaWrapper.salaNova.arte.id);

        servicoRabbitMQ.createNonDurableQueue(queueName);

        servicoRabbitMQ.bindQueue(queueName, RabbitMQConfig.ALTERACOES_EXCHANGE_NAME, especificoBindingKey);

        // a partir daqui, as mensagens do desenho estarão chegando
        servicoRabbitMQ.bindQueue(queueName, RabbitMQConfig.ALTERACOES_EXCHANGE_NAME, geralBindKey);


        servicoRabbitMQ.createReadOnlyConsumer(queueName, new MessageListenerAdapter(new AbrirSalaConsumidor(queueName,servicoRabbitMQ)));

        servicoRabbitMQ.createConsumer(queueName, new MessageListenerAdapter(new RabbitArtFusionConsumer(salaAbertaWrapper,simpMessagingTemplate)));

        return ResponseEntity.ok(salaAbertaWrapper.salaNova);
    }

    @GetMapping("/obterPorArte/{arteId}")
    public ResponseEntity<Sala> obterSalaPorArte(@PathVariable String arteId) throws Exception {
        return ResponseEntity.ok(salaServico.obterSalaPorIdArte(arteId));
    }

    @GetMapping("/obter/{uui}")
    public ResponseEntity<Sala> obterSala(@PathVariable String uui){
        return ResponseEntity.ok(salaServico.obterSala(uui));
    }

    @PostMapping("/fechar/{uuid}")
    public ResponseEntity<Sala> fecharSala(@PathVariable String uuid){
        return ResponseEntity.ok(salaServico.fecharSala(uuid));

    }






}
