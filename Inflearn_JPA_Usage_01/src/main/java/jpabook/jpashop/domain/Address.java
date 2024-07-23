package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    protected Address() {} // JPA 스펙 상 기본 생성자를 선언해야 하는데 protected로 제한한다.

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    } // setter는 제공하지 않고 생성자로만 생성 가능하도록 설계
}
