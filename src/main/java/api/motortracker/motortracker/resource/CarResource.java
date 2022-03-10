package api.motortracker.motortracker.resource;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
public class CarResource implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String name;

    private String plate;

    private String tracker;
}
