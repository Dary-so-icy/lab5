package managers;

import collection.AskForms.AskLabWork;
import collection.LabWork;
import collection.Person;
import exceptions.NoSuchIdException;
import jakarta.xml.bind.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CollectionManager {
    protected StandartConsole console;
    /**
     * Хранимая коллекция
     */
    private static Set<LabWork> collection = new HashSet<>();
    /**
     * Дата инициализации коллекции
     */
    private final Date initializationTime = new Date();
    /**
     * Возвращает коллекцию
     * @return Коллекция
     */
    public static Set<LabWork> getCollection() {
        return collection;
    }
    /**
     * Удаляет элемент коллекции по заданному значению id
     * @param id id элемента
     */
    public static void removeById(long id){
        if (getById(id) != null){
            collection.remove(getById(id));
        } else {
            throw new NoSuchIdException();
        }
    }
    /**
     * Ищет элемент коллекции по заданному значению id
     * @param id id элемента
     */
    public static LabWork findById(long id){
        for (LabWork lab : CollectionManager.collection) {
            if (lab.getId() == id) {
                return lab;
            }
        }
        System.out.printf("Не найдено элемента с id равным %d \n", id);
        return null;
    }
    public static void updateById(LabWork laba, int id) {
        LabWork lab = findById(id);
        try {
            lab.setMinimalPoint(laba.getMinimalPoint());
            lab.setCreationDate(new Date());
            lab.setAuthor(laba.getAuthor());
            lab.setName(laba.getName());
            lab.setCoordinates(laba.getCoordinates());
            lab.setDifficulty(laba.getDifficulty());
        } catch (NullPointerException e) {
            System.out.println("No such space marine");
        }

    }
    public LabWork readCollection(String path) throws IOException{
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
            Scanner scanner = ScannerManager.getUserScanner();// Scanner(file) ; //fuck ScannerManager.getUserScanner()
            JAXBContext jaxbContext = null;
            jaxbContext = JAXBContext.newInstance(LabWork.class); // class для парсинга labwork
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            LabWork work = (LabWork) jaxbUnmarshaller.unmarshal(file);
            return work;
            //jaxbContext = JAXBContext.newInstance(); че за хуйня
        } catch (JAXBException e) {
            System.out.println("No such file");

        }

        return null;
    }
    public static void saveCollection() throws JAXBException {
//        //LabWork labs = new LabWork();
//        labs.setCollectionOfDragons(collectionOfDragons);
//
//        JAXBContext jaxbContext = JAXBContext.newInstance(AskLabWork.class);
//        Marshaller marshaller = jaxbContext.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        File file = new File(fileName);
//
//        marshaller.marshal(labs, new FileWriter());
//
//        System.out.println("Коллекция сохранена.");
//
    }
    public static void addElement(LabWork lab){
        collection.add(lab);
    }
    public static LabWork getById(long id){
        for (LabWork element : collection) {
            if (element.getId() == id) return element;
        }
        return null;
    }

}
