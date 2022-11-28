package run.ikaros.offlinedb.bgmtv.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import run.ikaros.offlinedb.bgmtv.enums.SubjectType;

import javax.persistence.*;

@Entity
@Table(name = "off_subject")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * @see SubjectType
     */
    private Integer type;
    private String name;
    @JsonProperty("name_cn")
    @Column(name = "name_cn")
    private String nameCn;
    @Lob
    private String infobox;
    private Integer platform;
    @Lob
    private String summary;
    private Boolean nsfw;

    public Long getId() {
        return id;
    }

    public SubjectEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public SubjectEntity setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public SubjectEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getNameCn() {
        return nameCn;
    }

    public SubjectEntity setNameCn(String nameCn) {
        this.nameCn = nameCn;
        return this;
    }

    public String getInfobox() {
        return infobox;
    }

    public SubjectEntity setInfobox(String infobox) {
        this.infobox = infobox;
        return this;
    }

    public Integer getPlatform() {
        return platform;
    }

    public SubjectEntity setPlatform(Integer platform) {
        this.platform = platform;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public SubjectEntity setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public Boolean getNsfw() {
        return nsfw;
    }

    public SubjectEntity setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
        return this;
    }
}
