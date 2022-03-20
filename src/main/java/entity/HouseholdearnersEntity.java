package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "householdearners", schema = "canadacensusdb", catalog = "")
public class HouseholdearnersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private short id;
    @Basic
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "householdearnersByHouseholdEarners")
    private Collection<HouseholdEntity> householdsById;

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HouseholdearnersEntity that = (HouseholdearnersEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Collection<HouseholdEntity> getHouseholdsById() {
        return householdsById;
    }

    public void setHouseholdsById(Collection<HouseholdEntity> householdsById) {
        this.householdsById = householdsById;
    }
}
