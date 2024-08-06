package org.junbeom.tour.entities;


import groovy.transform.builder.Builder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junbeom.global.entities.BaseEntity;

@Data
@Builder
@Entity
@NoArgsConstructor
public class TourPlace extends BaseEntity {
    @Id
    private Long contentId;
    private Long contentTypeId;

    @Column(length = 30)
    private String category1;

    @Column(length = 30)
    private String category2;

    @Column(length = 30)
    private String category3;

    @Column(length = 100)
    private String title;

    @Column(length = 30)
    private String tel;

    @Column(length = 30)
    private String address;
    private String areaCode;
    private boolean bookTour;
    private double distance;
    private String firstImage;
    private String firstImage2;
    private String cpyrhtDivCd;
    private double latitude; // mapy
    private double longitude; // mapx
    private int mapLevel;
    private int sigunguCode;


}
