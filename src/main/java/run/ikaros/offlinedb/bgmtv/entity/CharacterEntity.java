package run.ikaros.offlinedb.bgmtv.entity;

import javax.persistence.*;

@Entity
@Table(name = "off_character")
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer role;
    private String name;
    @Lob
    private String infobox;
    @Lob
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
