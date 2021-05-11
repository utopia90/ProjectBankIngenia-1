package com.ingenia.projectbank.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id")
    @ApiModelProperty("Clave primaria tipo Long")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty("Clave tipo categoría tipo Enum")
    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    @ApiModelProperty("Clave movimientos tipo Movement")
    @OneToMany(mappedBy = "category", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Movement> movements = new ArrayList<>();

    public Category() {
    }

    public Category(CategoryType categoryType, List<Movement> movements) {
        this.categoryType = categoryType;
        this.movements = movements;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryType=" + categoryType +
                ", movements=" + movements +
                '}';
    }
}
