package managers;

import collection.LabWork;
import exceptions.NoSuchIdException;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CollectionManager {
    /**
     * Хранимая коллекция
     */
    private static final Set<LabWork> collection = new HashSet<>();
    /**
     * Дата инициализации коллекции
     */
    private final Date initializationTime = new Date();
    /**
     * Возвращает коллекцию
     * @return Коллекция
     */
    public Set<LabWork> getCollection() {
        return collection;
    }
    /**
     * Очищает коллекцию
     */
    public void clearCollection(){
        collection.clear();
    }
    /**
     * Удаляет элемент коллекции по заданному значению id
     * @param id id элемента
     */
    public void removeById(long id){
        if (getById(id) != null){
            collection.remove(getById(id));
        } else {
            throw new NoSuchIdException();
        }
    }
    public void readCollection(String path) throws IOException{
        File file = new File(path);
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new IOException();
            }
        }
        if (!file.isFile()) {
            throw new IOException();
        }
        if (!file.canRead()) {
            throw new IOException();
        }
        try {
            this.scanner = new Scanner(new File(commandScriptPath));
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
        }
    }
    public void saveCollection(){

    }
    public void addElement(LabWork lab){
        collection.add(lab);
    }
    public static LabWork getById(long id){
        for (LabWork element : collection) {
            if (element.getId() == id) return element;
        }
        return null;
    }
}
