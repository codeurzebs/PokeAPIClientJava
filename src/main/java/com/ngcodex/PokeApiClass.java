package com.ngcodex;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class PokeApiClass {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest listRequest = HttpRequest.newBuilder().uri(URI.create("https://pokeapi.co/api/v2/pokemon/")).build();
        try {
            HttpResponse<String> listResponse = client.send(listRequest, HttpResponse.BodyHandlers.ofString());
            Map<String, Object> listResponseMap = JsonClass.parseJsonObject(listResponse.body());
            if (listResponseMap.containsKey("results")) {
                List<Map<String, Object>> pokemonList = (List<Map<String, Object>>) listResponseMap.get("results");
                if (!pokemonList.isEmpty()) {
                    Map<String, Object> firstPokemon = pokemonList.get(0);
                    if (firstPokemon.containsKey("url")) {
                        String firstPokemonUrl = firstPokemon.get("url").toString();
                        System.out.println("le nom du premier Pokemon est: " + firstPokemon.get("name"));
                        System.out.println(" son URL est: " + firstPokemonUrl);
                        HttpRequest detailsRequest = HttpRequest.newBuilder().uri(URI.create(firstPokemonUrl)).build();
                        try {
                            HttpResponse<String> detailsResponse = client.send(detailsRequest, HttpResponse.BodyHandlers.ofString());
                            Map<String, Object> pokemonDetails = JsonClass.parseJsonObject(detailsResponse.body());
                            if (pokemonDetails.containsKey("abilities")) {
                                List<Map<String, Object>> abilitiesList = (List<Map<String, Object>>) pokemonDetails.get("abilities");
                                if (!abilitiesList.isEmpty()) {
                                    Map<String, Object> abilityMap = (Map<String, Object>) abilitiesList.get(0).get("ability");
                                    String abilityUrl = abilityMap.get("url").toString();
                                    System.out.println("URL de la capacité est: " + abilityUrl);
                                    abilityUrl = abilityMap.get("url").toString();
                                    HttpRequest abilityDetailsRequest = HttpRequest.newBuilder().uri(URI.create(abilityUrl)).build();
                                    try {
                                        HttpResponse<String> abilityDetailsResponse = client.send(abilityDetailsRequest, HttpResponse.BodyHandlers.ofString());
                                        Map<String, Object> abilityDetails = JsonClass.parseJsonObject(abilityDetailsResponse.body());
                                        String abilityDetailsName = (String) abilityDetails.get("name");
                                        String abilityEffect = ((List<Map<String, Object>>) abilityDetails.get("effect_entries")).get(0).get("effect").toString();
                                        System.out.println("le nom de la capacité est: " + abilityDetailsName);
                                        System.out.println("l'effet de la capacité est: " + abilityEffect);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    System.out.println("error JSON.");
                                }
                            } else {
                                System.out.println("error JSON.");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("error JSON.");
                    }
                } else {
                    System.out.println("error JSON.");
                }
            } else {
                System.out.println("error JSON.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}