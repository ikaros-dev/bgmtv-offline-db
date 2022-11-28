package run.ikaros.offlinedb.bgmtv.entity;


import run.ikaros.offlinedb.bgmtv.enums.OptionKey;

import javax.persistence.*;

@Entity
@Table(name = "off_options")
public class OptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "o_key", nullable = false)
    @Enumerated(EnumType.STRING)
    private OptionKey key;

    @Lob @Column(name = "o_value")
    private String value  = "";

    public Long getId() {
        return id;
    }

    public OptionEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public OptionKey getKey() {
        return key;
    }

    public OptionEntity setKey(OptionKey key) {
        this.key = key;
        return this;
    }

    public String getValue() {
        return value;
    }

    public OptionEntity setValue(String value) {
        this.value = value;
        return this;
    }
}
