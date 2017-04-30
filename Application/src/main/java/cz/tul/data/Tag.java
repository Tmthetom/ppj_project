package cz.tul.data;

import javax.persistence.*;

@Entity
@Table(name="Tag")
public class Tag {

    @Id
    @Column(name="name")
    private String name;

    public Tag() {
        ;
    }

    public Tag(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "name = " + name +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Tag tag = (Tag) object;
        return name == tag.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
