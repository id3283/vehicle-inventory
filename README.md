# Vehicle Inventory Application
This little terminal application keeps track of a collection of vehicles and allows the user to do some basic operations like list all vehicles and search.

here's a bullet list:
  * option 1
  * option 2

Here's my search using a hash map:
```java
    public static void searchForMakeModel(String searchMakeModel, HashMap<String, Vehicle> vehicleMap) {
        Vehicle v = vehicleMap.get(searchMakeModel);
        v.display();
    }
```