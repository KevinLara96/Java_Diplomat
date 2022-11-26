package unam.dgtic.diplomado.m1100base.dominio;

public class CachedEntity {

    private Long createTime;

    public CachedEntity() {
        this.createTime = System.currentTimeMillis();
    }

    public Long getCacheAge() {
        return System.currentTimeMillis() - this.createTime;
    }
}
