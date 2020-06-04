package br.com.api.apirest.model;

public class PlanetaDTO {

    private String name;
    private String terrain;
    private String climate;
    private Integer appears;

    public PlanetaDTO(String name, String terrain, String climate, Integer appears) {
        this.name = name;
        this.terrain = terrain;
        this.climate = climate;
        this.appears = appears;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public Integer getAppears() {
        return appears;
    }

    public void setAppears(Integer appears) {
        this.appears = appears;
    }
}
