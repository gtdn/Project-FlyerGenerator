# mif10-2020 - Groupe 8 - Flyergenerator

## Dépendances

### Maven
Maven est un outil de gestion de projet. Il est basé sur le concept POM (Project Object Model). Il définit une structure type et notre projet utilise et respecte ce modèle.
Lien vers le site officiel : https://maven.apache.org/

### Tomcat
Tomcat est un logiciel qui execute des servlets et du JSP. Il est paramétable avec pom.xml situé à la racine du projet. Nous utilisons son plug-in maven afin de les faire fonctionner ensemble.
Lien vers le site officiel : http://tomcat.apache.org/

### wkhtmltopdf
wkhtmltopdf est un convertisseur de fichier html en fichier pdf. Nous l'utilisons pour générer nos flyers sous forme de pdf à partir des données souhaitées et de fichers hmtl/css définnissant les patterns visuels souhaités. 
Lien vers le site officiel : https://wkhtmltopdf.org/

### Base de données PQSL
Pour notre base de données, nous utilisons la base de données PostgreSQL fournie par l'université. Plus particulièrement, nous utilisons celle de Quentin Rejaumont puisqu'il était le responsable back-end/BDD de notre projet.

### autres dependencies pom/xml ??


## Procédure de build

Pour build ce projet, il faut tout d'abord démarrer Tomcat. Pour cela, il faut aller dans le dossier où est intallé Tomcat puis dans /bin. Cela donne quelque chose comme ceci :
    ```cd /Path/to/Tomcat/bin/```

*Il est impératif de lancer Tomcat depuis le dossier bin. C'est indispensable pour que le wkhtmltopdf ait le bon path pour générer le pdf.*

Une fois dans ce dossier, il faut exécuter startup.sh de cette façon : 
    ```./startup.sh```

Maintenant il est temps d'aller dans le dossier de notre projet :
    ```cd /Path/to/ProjectDir/flyergenerator/```

Une fois dans ce dossier, utiliser la commande suivante pour build en local notre projet :
    ```mvn Tomcat7:redeploy```

Vous pouvez désormais accéder à votre version locale du site à l'addresse suivante :
    ```http://localhost:8080/flyergenerator```



## Lien vers la VM

Pour accéder à la VM, il faut tout d'abord se connecter au VPN de l'université.

Une fois cela fait, notre site est accessible à l'adresse suivante : ```192.168.74.210:8080/flyergenerator/```

*normalement, Tomcat devrait etre lancé sur la VM. Toutefois, si ce n'est pas le cas il faudra le lancer en suivant les consignes disponbles [ici](https://forge.univ-lyon1.fr/p1509933/mif10-2020/-/wikis/Configuration-&-utilisation-VM).*