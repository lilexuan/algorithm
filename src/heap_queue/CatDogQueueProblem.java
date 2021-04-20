package heap_queue;

import java.util.LinkedList;
import java.util.Queue;

public class CatDogQueueProblem {
    public static void main(String[] args) {
        CatDogQueue catDogQueue = new CatDogQueue();
        catDogQueue.add(new Pet("cat"), 1);
        catDogQueue.add(new Pet("dog"), 2);
        PetInfo petInfo = catDogQueue.pollAll();
        System.out.println(petInfo.getPetType() + " " + petInfo.getId());
        System.out.println(catDogQueue.isEmpty());
        catDogQueue.add(new Pet("cat"), 5);
        System.out.println(catDogQueue.isDogEmpty());
        petInfo = catDogQueue.pollCat();
        System.out.println(petInfo.getPetType() + " " + petInfo.getId());
        catDogQueue.add(new Pet("dog"), 10);
        catDogQueue.add(new Pet("cat"), 199);
        petInfo = catDogQueue.pollDog();
        System.out.println(petInfo.getPetType() + " " + petInfo.getId());
        petInfo = catDogQueue.pollAll();
        System.out.println(petInfo.getPetType() + " " + petInfo.getId());
    }
}

class Pet {
    private String type;
    public Pet(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }
}

class Dog extends Pet {
    public Dog() {
        super("dog");
    }
}

class Cat extends Pet {
    public Cat() {
        super("cat");
    }
}

class PetInfo {
    private Pet pet;
    private int count;
    private int id;
    public PetInfo(Pet pet, int count, int id) {
        this.pet = pet;
        this.count = count;
        this.id = id;
    }
    public int getCount() {
        return this.count;
    }
    public String getPetType() {
        return pet.getType();
    }
    public int getId() {
        return id;
    }
}

class CatDogQueue {
    private Queue<PetInfo> dogQueue;
    private Queue<PetInfo> catQueue;
    private int count;
    public CatDogQueue() {
        this.dogQueue = new LinkedList<>();
        this.catQueue = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet, int id) {
        String petType = pet.getType();
        if (petType.equals("dog")) {
            dogQueue.offer(new PetInfo(pet, this.count++, id));
        } else if (petType.equals("cat")) {
            catQueue.offer(new PetInfo(pet, this.count++, id));
        }
    }

    public PetInfo pollAll() {
        if (!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()) {
            if (this.dogQueue.peek().getCount() < this.catQueue.peek().getCount()) {
                return dogQueue.poll();
            } else {
                return catQueue.poll();
            }
        } else if (!dogQueue.isEmpty()) {
            return dogQueue.poll();
        } else if (!catQueue.isEmpty()) {
            return catQueue.poll();
        }
        return null;
    }

    public PetInfo pollDog() {
        if (!isDogEmpty()) {
            return dogQueue.poll();
        }
        return null;
    }

    public PetInfo pollCat() {
        if (!isCatEmpty()) {
            return catQueue.poll();
        }
        return null;
    }

    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }

    public boolean isEmpty() {
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }
}
