SRC_DIR := src
OUT_DIR := classes

# les sources pour compiler chaque fichiers
ZOMBIE_SRC :=$(SRC_DIR)/zombiegame/*.java 
ACTORS_SRC :=$(SRC_DIR)/zombiegame/Actors/*.java
EQUIPMENTS_SRC :=$(SRC_DIR)/zombiegame/Equipments/*.java
WEAPONS_SRC :=$(SRC_DIR)/zombiegame/Equipments/Weapons/*.java
ROLES_SRC :=$(SRC_DIR)/zombiegame/Roles/*.java
SPECIALROOM_SRC :=$(SRC_DIR)/zombiegame/SpecialRoom/*.java
SPECIALSTREET_SRC :=$(SRC_DIR)/zombiegame/SpecialStreet/*.java
SPECIALZOMBIE_SRC :=$(SRC_DIR)/zombiegame/SpecialZombie/*.java

# compile tout les fichiers
all: zombiegame actors equipments weapons roles specialroom specialstreet specialzombie

# compile tout les fichiers
cls: zombiegame actors equipments weapons roles specialroom specialstreet specialzombie

# compile zombiegame
zombiegame:
	javac -sourcepath $(SRC_DIR) $(ZOMBIE_SRC) -d $(OUT_DIR)

# compile les acteurs
actors:
	javac -sourcepath $(SRC_DIR) $(ACTORS_SRC) -d $(OUT_DIR)

# compile les équipements
equipments:
	javac -sourcepath $(SRC_DIR) $(EQUIPMENTS_SRC) -d $(OUT_DIR)

# compile les armes
weapons:
	javac -sourcepath $(SRC_DIR) $(WEAPONS_SRC) -d $(OUT_DIR)

# compile les roles des survivants
roles:
	javac -sourcepath $(SRC_DIR) $(ROLES_SRC) -d $(OUT_DIR)

# compile les specialRoom : ContinentalHotel et Pharmacy
specialroom:
	javac -sourcepath $(SRC_DIR) $(SPECIALROOM_SRC) -d $(OUT_DIR)

# compile SpecialStreet : Sewer
specialstreet:
	javac -sourcepath $(SRC_DIR) $(SPECIALSTREET_SRC) -d $(OUT_DIR)

# compile les Special Zombies
specialzombie:
	javac -sourcepath $(SRC_DIR) $(SPECIALZOMBIE_SRC) -d $(OUT_DIR)
	
# nettoie les fichiers 
clean:
	rm -rf $(OUT_DIR)

# genere la documentation pour tout les fichiers sources
doc:
	javadoc -sourcepath $(SRC_DIR) -d doc $(ZOMBIE_SRC) $(ACTORS_SRC) $(EQUIPMENTS_SRC) $(WEAPONS_SRC) $(ROLES_SRC) $(SPECIALROOM_SRC) $(SPECIALSTREET_SRC) $(SPECIALZOMBIE_SRC)

ARG1 ?= 8
ARG2 ?= 8
ARG3 ?= 2

# execute le jeu zombicide selon les arguments que l'utilisateur à choisi. Sinon 8 8 2 est mit par defaut
zombicide.jar: jar/Zombicide.jar
	@java -jar $< $(ARG1) $(ARG2) $(ARG3)

.DEFAULT_GOAL := zombicide.jar

# execute le jeu ZombicideInteractive
zombicideInteractive.jar:
	java -jar jar/ZombicideInteractive.jar

# creer le jar Zombicide
zombicide-jar:
	jar cvfe jar/Zombicide.jar zombiegame.Zombicide -C classes zombiegame

# créer le jar ZombieInteractif
zombicideInteractive-jar:
	jar cvfe jar/ZombicideInteractive.jar zombiegame.ZombicideInteractive -C classes zombiegame
