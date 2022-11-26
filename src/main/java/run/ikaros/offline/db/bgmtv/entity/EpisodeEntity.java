package run.ikaros.offline.db.bgmtv.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "episode")
public class EpisodeEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(name = "name_cn")
    private String nameCn;
    private String description;
    private String airdate;
    private Integer disc;
    @Column(name = "subject_id")
    private Long subjectId;
    private Integer sort;
    /**
     * @see run.ikaros.offline.db.bgmtv.enums.EpisodeType
     */
    private Integer type;

    public Long getId() {
        return id;
    }

    public EpisodeEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EpisodeEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getNameCn() {
        return nameCn;
    }

    public EpisodeEntity setNameCn(String nameCn) {
        this.nameCn = nameCn;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public EpisodeEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAirdate() {
        return airdate;
    }

    public EpisodeEntity setAirdate(String airdate) {
        this.airdate = airdate;
        return this;
    }

    public Integer getDisc() {
        return disc;
    }

    public EpisodeEntity setDisc(Integer disc) {
        this.disc = disc;
        return this;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public EpisodeEntity setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public EpisodeEntity setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public EpisodeEntity setType(Integer type) {
        this.type = type;
        return this;
    }
}
