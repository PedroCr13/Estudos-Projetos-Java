package com.hachathon.backend_simulador_api.integration.azure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.azure.messaging.eventhubs.EventData;
import com.azure.messaging.eventhubs.EventDataBatch;
import com.azure.messaging.eventhubs.EventHubClientBuilder;
import com.azure.messaging.eventhubs.EventHubProducerClient;
import com.azure.messaging.eventhubs.models.CreateBatchOptions;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import jakarta.annotation.PostConstruct;

@Component
public class EventHubSender {

    @Value("${azure.eventhub.namespace}")
    private String namespace;

    @Value("${azure.eventhub.policy-name}")
    private String policyName;

    @Value("${azure.eventhub.access-key}")
    private String accessKey;

    @Value("${azure.eventhub.name}")
    private String eventHubName;

    private EventHubProducerClient producer;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void init() {
        String connectionString = String.format(
                "Endpoint=sb://%s.servicebus.windows.net/;SharedAccessKeyName=%s;SharedAccessKey=%s;EntityPath=%s",
                namespace, policyName, accessKey, eventHubName
            );


        this.producer = new EventHubClientBuilder()
            .connectionString(connectionString)
            .buildProducerClient();

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public void enviarJSON(Object simulacao) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(simulacao);

            EventDataBatch batch = producer.createBatch(new CreateBatchOptions());
            boolean added = batch.tryAdd(new EventData(jsonMessage));

            if (!added) {
                throw new IllegalStateException("Mensagem JSON excede o tamanho permitido para o batch.");
            }

            producer.send(batch);
            System.out.println("Mensagem enviada com sucesso para o Event Hub.");

        } catch (Exception e) {
            System.err.println("Erro ao enviar mensagem para o Event Hub: " + e.getMessage());
        }
    }

    public void fechar() {
        producer.close();
    }
}
