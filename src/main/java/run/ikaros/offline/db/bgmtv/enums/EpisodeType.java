package run.ikaros.offline.db.bgmtv.enums;

/**
 * @see <a href="https://bangumi.github.io/api/">bgmtv-api</a>
 */
public enum EpisodeType {

    /**
     * 本篇
     */
    POSITIVE(0),
    /**
     * 特别篇
     */
    SPECIAL(1),
    OP(2),
    ED(3),
    /**
     * 预告/宣传/广告
     */
    PV(4),
    MAD(5),
    OTHER(6);
    private final Integer code;

    EpisodeType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
