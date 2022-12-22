package lesson08.list;

/**
 * @author spasko
 */
public class Animal /* implements Comparable<Animal> */ {
    private String name;
    private int old;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public Animal(String name, int old) {
        this.name = name;
        this.old = old;
    }

    @Override
    public String toString() {
        return "Animal [name=" + name + ", old=" + old + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + old;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (old != other.old)
            return false;
        return true;
    }

//    @Override
//    public int compareTo(Animal compareAnimal) {
//        int compareName = name.compareTo(compareAnimal.getName());
//        if (compareName == 0) {
//            return Integer.compare(old, compareAnimal.getOld());
//        } else {
//            return compareName;
//        }
//    }

}
