package run.ikaros.offline.db.bgmtv.entity;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class SubjectEntity {
    @Id
    @GeneratedValue
    private Long id;
    /**
     * @see run.ikaros.offline.db.bgmtv.enums.SubjectType
     */
    private Integer type;
    private String name;
    @Column(name = "name_cn")
    private String nameCn;
    private String infobox;
    private Integer platform;
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
