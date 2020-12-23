package src;

class Jogo {

}

class Tamagotchi {
    private int energyMax, hungryMax, cleanMax;
    private int energy, hungry, clean;
    private int diamonds, age;
    private boolean alive;

    public Tamagotchi(int energia, int fome, int limpo) {
        this.energyMax = energia;
        this.hungryMax = fome;
        this.cleanMax = limpo;
        
        this.energy = energia;
        this.hungry = fome;
        this.clean = limpo;
        this.diamonds = 0;
        this.age = 0;
        this.alive = true;
    }

    private void setEnergy(int energia) {
        this.energy = energia;
    }
    private void setHungry(int fome) {
        this.hungry = fome;
    }
    private void setClean(int limpo) {
        this.clean = limpo;
    }

    private void isAlive() {
        if( (this.energy <= 0) && (this.hungry <= 0) && (this.clean <= 0) ) {
            System.out.println("Morreu de fraqueza, fome e limpeza");
            this.alive = false;
        } else if ((this.energy <= 0) && (this.hungry <= 0)) {
            System.out.println("Morreu de fraqueza e fome");
            this.alive = false;
        } else if ((this.hungry <= 0) && (this.clean <= 0)) {
            System.out.println("Morreu de fome e limpeza");
            this.alive = false;
        } else if ((this.energy <= 0) && (this.clean <= 0)) {
            System.out.println("Morreu de fraqueza e limpeza");
            this.alive = false;
        } else if (this.energy <= 0) {
            System.out.println("Morreu de fraqueza");
            this.alive = false;
        } else if (this.hungry <= 0) {
            System.out.println("Morreu de fome");
            this.alive = false;
        } else if (this.clean <= 0) {
            System.out.println("Morreu de limpeza");
            this.alive = false;
        } else {
            this.alive = true;
        }
    }

    private void setZero() {
        if(this.energy < 0) {
            this.setEnergy(0);
        } else if(this.hungry < 0) {
            this.setHungry(0);
        } else if(this.clean < 0) {
            this.setClean(0);
        }
    }

    public void allGets() {

    }

    public void play() {
        if(this.alive) {
            this.energy -= 2;
            this.hungry -= 1;
            this.clean -= 3;
            this.diamonds += 1;
            this.age += 1;

            this.isAlive();
        } else {
            System.out.println("Tamagotchi esta morto");
        }
        this.setZero();

    }

    public void Shower() {
        if(this.alive) {
            this.energy -= 3;
            this.hungry -= 1;
            this.clean = this.cleanMax;
            this.age += 2;

            this.isAlive();
        } else {
            System.out.println("Tamagotchi esta morto");
        }
        this.setZero();
    }

    public void eat() {
        if(this.alive) {
            this.energy -= 1;
            this.hungry += 4;
            this.clean -= 2;
            this.age += 1;

            this.isAlive();
        } else {
            System.out.println("Tamagotchi esta morto");
        }
        this.setZero();
    }

    public void sleep() {
        if(this.alive) {

            if(this.energyMax - this.energy >= 5) {
                this.age += (this.energyMax - this.energy);
                this.energy = this.energyMax;
            } else {
                System.out.println("Nao esta com sono");
            }
            this.isAlive();

        } else {
            System.out.println("Tamagotchi esta morto");
        }
        this.setZero();
    }

    public String toString() {
        return "E: " + this.energy + "/" + this.energyMax +
        ", H: " + this.hungry + "/" + this.hungryMax + 
        ", C: " + this.clean + "/" + this.cleanMax +
        ", D: " + this.diamonds + ", A: " + this.age;
    }
}

class Main {
    public static void main(String[] args) {
    
        //case play - Brincar 
        Tamagotchi pet = new Tamagotchi(20, 10, 15);
        pet.play();
        System.out.println(pet);
        //E:18/20, S:9/10, L:12/15, D:1, I:1
        pet.play();
        System.out.println(pet);
        //E:16/20, S:8/10, L:9/15, D:2, I:2

        //case comer 
        pet.eat();
        System.out.println(pet);
        //E:15/20, S:12/10, L:7/15, D:2, I:3

        //case dormir
        pet.sleep();
        System.out.println(pet);
        //E:20/20, S:12/10, L:7/15, D:2, I:8

        //case tomar banho
        pet.Shower();
        System.out.println(pet);
        //E:17/20, S:8/10, L:15/15, D:2, I:10

        //case dormir sem sono
        pet.sleep();
        //fail: nao esta com sono

        //case morrer
        pet.play();
        pet.play();
        pet.play();
        pet.play();
        System.out.println(pet);
        //E:9/20, S:4/10, L:3/15, D:6, I:14
        pet.play();
        //fail: pet morreu de sujeira
        System.out.println(pet);
        //E:7/20, S:3/10, L:0/15, D:7, I:15
        pet.play();
        //fail: pet esta morto
        pet.eat();
        //fail: pet esta morto
        pet.Shower();
        //fail: pet esta morto
        pet.sleep();
        //fail: pet esta morto
    }
}