package run.ikaros.offline.db.bgmtv.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "file")
public class FileEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String url;
    /**
     * 完整带后缀文件名称
     */
    @Column(nullable = false)
    private String name;
    private String md5;
    private Integer size;

    public Long getId() {
        return id;
    }

    public FileEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public FileEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public FileEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getMd5() {
        return md5;
    }

    public FileEntity setMd5(String md5) {
        this.md5 = md5;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public FileEntity setSize(Integer size) {
        this.size = size;
        return this;
    }
}