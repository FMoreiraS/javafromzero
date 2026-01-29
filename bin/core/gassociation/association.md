## Associação
Associação é a relação entre objetos ou classes, como por exemplo a relação entre um carro e seu proprietário.
(Quando se usar "objetos", adiante, entenda-se que valem também para classes, as relações.) Uma forma simples 
de relacionar objetos é criar um array de objetos de mesma classe:  
```
    Student socrates = new Student("Socrates");
    Student plato = new Student("Plato");
    Student aristoteles = new Student("Aristoteles");
    Student[] greeks = {socrates, plato, aristoteles};
```
Mas não isso não é associação.  
### UNIDIRECTIONAL ASSOTIATION:
É a que ocorre entre um objeto e vários ou entre vários objetos e um só. Remodelando o exemplo,
pode-se associar um objeto (school) a vários (students):
```
    Student albertus = new Student("Alberto de Colônia");
    Student thomas = new Student("Tomás de Aquino");
    Student[] students = {albertus, thomas};
    School scholastic = new School("Escolástica", students);
```
Ou associar vários students num objeto school:
```
    School antique = new School("Antiguidade");
    socrates.setSchool(antique);
    plato.setSchool(antique);
    aristoteles.setSchool(antique);
```
Essas são as chamadas associacões "one to many" e "many to one", respectivamente.
### Bidirecional association
É a que ocorre mutuamente entre objetos, ou seja, um está associado ao outro, e não apenas um, como antes.
Agora, guerreiros estarão associados a um exército e o exército, aos guerreiros:
````
Warrior knight = new Warrior("Cavaleiro Alexander");
Warrior archer = new Warrior("Arqueiro Fabricius");
Army romanus = new Army("Exercitus Romanus");

        // Mútua associação:
        knight.setArmy(romanus);
        archer.setArmy(romanus);
        
        romanus.setWarriors(knight, archer);
````