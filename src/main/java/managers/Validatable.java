package managers;

import collection.LabWork;

public interface Validatable {
    boolean validate();

    int compareTo(LabWork o);
}
