package com.adsosena.egloapps.services;


import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ImagenService {
    private static final String API_URL = "https://freeimage.host/api/1/upload";
    private static final String API_KEY = "6d207e02198a847aa98d0a2a901485a5";
    public String guardarImagen(MultipartFile imagen){

        String imagenUrl = "";
        // Procesar el archivo de imagen
        if (!imagen.isEmpty()) {
            try{
                // Preparar los parámetros de la llamada a la API
                MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
                bodyMap.add("key", API_KEY);
                bodyMap.add("action", "upload");
                bodyMap.add("source", imagen.getResource());

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.MULTIPART_FORM_DATA);

                HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);
                // Realizar la llamada a la API
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, requestEntity, String.class);
                // Obtener la respuesta de la API
                if (response.getStatusCode().is2xxSuccessful()) {
                    String apiResponse = response.getBody();

                    // Procesar la respuesta de la API
                    ObjectMapper objectMapper = new ObjectMapper();

                    JsonNode jsonResponse = objectMapper.readTree(apiResponse);
                    imagenUrl = jsonResponse.get("image").get("url").asText();
                    return imagenUrl;
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return imagenUrl;
    }
}
