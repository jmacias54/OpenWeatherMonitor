package com.mx.weather.config.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "code"  , "response" , "description"})
public class Error {

	@Schema(description = "Boolean response, valid values: \"true\" if the response is approved, \"false\" if the response is denied", example = "true")
	private String response;

	@Schema(description = "Response code, valid values: \"000\" if the response is approved, otherwhise a 3 digit code", example = "000")
	private String code;

	@Schema(description = "Description message, valid values: \"Aprobada\" if the response is approved, otherwhise a description message with the error", example = "Aprobada")
	private String description;

	@Schema(description = "Dynamic object that will be different for each petition, for example: [{\"id\": 240,\"status\": \"Inactive\",\"name\": \"Chambita para validar reto con respuesta alfanumérica\",\"activation_date\": \"2022-06-24\",\"expiration_date\": \"2022-06-26\",\"approved_date\": \"2022-06-24\",\"prize_amount\": \"5 días sin cobro de renta\",\"challenges\": [{\"companyId\": null,\"id\": 248,\"challengeType\": \"PreguntaAbierta\",\"indication\": null,\"title\": \"Prueba de reto respuesta alfanumérica\",\"image\": null,\"description\": \"Prueba de reto respuesta alfanumérica\",\"link\": null,\"questions\": [{\"id\": 444,\"question\": \"¿Cual es tu nombre y tu edad?\",\"is_numeric\": \"0\",\"answers\": []},{\"id\": 445,\"question\": \"¿En que año se fundo Grupo Bimbo?\",\"is_numeric\": \"0\",\"answers\": []}],\"isDone\": false},{\"companyId\": null,\"id\": 247,\"challengeType\": \"PreguntaAbierta\",\"indication\": null,\"title\": \"Prueba de reto con respuesta numércia\",\"image\": null,\"description\": \"Prueba de reto con respuesta numércia\",\"link\": null,\"questions\": [{\"id\": 442,\"question\": \"¿En qué año naciste?\",\"is_numeric\": \"1\",\"answers\": []},{\"id\": 443,\"question\": \"¿Cuántas donas tiene un paquete?\",\"is_numeric\": \"1\",\"answers\": []}],\"isDone\": false}],\"states\": [],\"products\": [1],\"blmids\": [],\"company_id\": 1,\"company_name\": \"PruebaSeguridad\",\"count_views\": 3,\"count_completed\": 3,\"count_total\": 0}]", example = "Dynamic hashmap")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Object> object;

	@Schema(description = "Creation date used only in some services", example = "30-08-2022 10:39:39")
	@JsonProperty("createdAt")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String createdAt;

	@Schema(description = "Response date used only in some services", example = "30-08-2022 10:39:56")
	@JsonProperty("responseAt")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String responseAt;

}
