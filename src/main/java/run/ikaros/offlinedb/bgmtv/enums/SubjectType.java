package run.ikaros.offlinedb.bgmtv.enums;

/**
 * @see <a href="https://bangumi.github.io/api/">bgmtv-api</a>
 */
public enum SubjectType {

    BOOK(1),
    ANIME(2),
    MUSIC(3),
    GAME(4),
    REAL(6);
    private final Integer code;

    SubjectType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
