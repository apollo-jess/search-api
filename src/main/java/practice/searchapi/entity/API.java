package practice.searchapi.entity;

public enum API {
    KAKAO("kakao", 1),
    NAVER("naver", 2);

    private final String type;

    private final int order;

    API(String type, int order) {
        this.type = type;
        this.order = order;
    }

    public boolean isHigherThan(API api) {
        return this.getOrder() < api.getOrder();
    }

    public int getOrder() {
        return order;
    }
}
