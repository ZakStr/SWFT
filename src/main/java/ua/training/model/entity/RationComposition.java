package ua.training.model.entity;

import lombok.*;
import ua.training.model.entity.enums.FoodIntake;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "rationcomposition")
public class RationComposition implements EntityObject<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRC", nullable = false)
    private Integer id;
    //    @Column(name = "idDayRation", nullable = false)
    @ManyToMany
    @JoinColumn(name = "idDayRation", nullable = false)
    private DayRation dayRation;
    /**
     * Food intake per day
     */
    @Column(name = "idDayRation", nullable = false)
    private FoodIntake foodIntake;
    //    @Column(name = "idDish", nullable = false)
    @ManyToMany
    @JoinColumn(name = "idDish", nullable = false)
    private Dish dish;
    @Column(nullable = false)
    private Integer numberOfDish;
    @Column(nullable = false)
    private Integer caloriesOfDish;
}
