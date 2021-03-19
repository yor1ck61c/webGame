package ex2.List;

public class Pet {
    private String name;
    private String species;

    public Pet(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (!name.equals(pet.name)) return false;
        return species.equals(pet.species);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + species.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
}
