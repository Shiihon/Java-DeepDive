package org.example.javaDeepDive1.javaGenericInSchool;

public class DataStorageApp {

        public static void main(String[] args) {
            DataStorage<String> memoryStorage = new MemoryStorage<>();
           String key =  memoryStorage.store("Hello, world!");
            String retrievedString = memoryStorage.retrieve(key);

            System.out.println("vi har hentet : " + retrievedString);
         /*   DataStorage<Employee> fileStorage = new FileStorage<>();
            String filename = fileStorage.store(new Employee("John", 30));
            Employee retrievedInt = fileStorage.retrieve(filename);

          */  // Create and demonstrate DatabaseStorage
        }

}
