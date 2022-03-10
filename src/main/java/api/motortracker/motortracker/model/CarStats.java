package api.motortracker.motortracker.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "CAR_STATS")
public class CarStats implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    private Date timeStamp;

    @JoinColumn(name = "CAR", referencedColumnName = "ID")
    @ManyToOne
    private Car car;

    private int coolant;

    private int oiltemp;

    private int airTemp;

    private int boostPressure;

    private int oilPressure;

}
