package run.ikaros.offline.db.bgmtv.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "character")
public class CharacterEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Integer role;
    private String name;
    private String infobox;
    private String summary;

    public Long getId() {
        return id;
    }

    public CharacterEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getRole() {
        return role;
    }

    public CharacterEntity setRole(Integer role) {
        this.role = role;
        return this;
    }

    public String getName() {
        return name;
    }

    public CharacterEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getInfobox() {
        return infobox;
    }

    public CharacterEntity setInfobox(String infobox) {
        this.infobox = infobox;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public CharacterEntity setSummary(String summary) {
        this.summary = summary;
        return this;
    }
}
