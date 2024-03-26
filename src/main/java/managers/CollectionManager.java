package managers;

import collection.Models.LabForReading;
import collection.LabWork;
import exceptions.NoSuchIdException;
import jakarta.xml.bind.*;
import java.io.*;
import java.util.*;

public class CollectionManager {
    protected StandartConsole console;
    /**
     * Хранимая коллекция
     */
    private static HashSet<LabWork> collection = new HashSet<>();
    /**
     * Дата инициализации коллекции
     */
    public static final Date initializationTime = new Date();

    /**
     * Возвращает коллекцию
     *
     * @return Коллекция
     */
    public static Set<LabWork> getCollection() {
        return collection;
    }

    /**
     * Удаляет элемент коллекции по заданному значению id
     *
     * @param id id элемента
     */
    public static void removeById(long id) {
        if (getById(id) != null) {
            collection.remove(getById(id));
        } else {
            throw new NoSuchIdException();
        }
    }

    /**
     * Ищет элемент коллекции по заданному значению id
     *
     * @param id id элемента
     */
    public static LabWork findById(long id) {
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

    public static void readCollection(String path) throws IOException, JAXBException {
        File file = new File(path);
        StandartConsole console = new StandartConsole();
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
            Scanner fileReader = new Scanner(file);
            String s = "";
            while (fileReader.hasNextLine()) {
                s +=  (fileReader.nextLine());
            }
            StringReader newFile = new StringReader(s);

            collection.clear();

            JAXBContext jaxbContext = null;
            jaxbContext = JAXBContext.newInstance(LabForReading.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            LabForReading work = (LabForReading) jaxbUnmarshaller.unmarshal(newFile);
            collection = new HashSet<>(work.getCollectionOfLabs());
        } catch (Exception e) {
            console.printError(e.getMessage());
        }


    }
    public static void saveCollection(String path){
        StandartConsole console = new StandartConsole();
        String file_path = System.getenv("file_path");
        File file = new File(path);
        if (file_path == null || file_path.isEmpty())
            console.printError("Путь должен быть в переменных окружения в перменной 'file_path'");
        else console.println("Путь получен успешно");
        try {
            LabForReading labs = new LabForReading();
            labs.setCollectionOfLabs(collection);
            JAXBContext context = JAXBContext.newInstance(LabForReading.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            FileWriter fileWriter = new FileWriter(path);
            marshaller.marshal(labs, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            console.printError("Ошибка ввода вывода");
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addElement(LabWork lab) {
        collection.add(lab);
    }

    public static LabWork getById(long id) {
        for (LabWork element : collection) {
            if (element.getId() == id) return element;
        }
        return null;
    }

    public static void removeElements(Collection<LabWork> toRemove) {
        collection.removeAll(toRemove);
    }
}
