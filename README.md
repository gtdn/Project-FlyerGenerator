# mif10-2020 Groupe 8

## dépendances

### maven
Maven est un outil de gestion de projet. Il est basé sur le concept POM (project object model). Il défini une structure type et notre projet utilise et respecte ce modèle.
Lien vers le site officiel : https://maven.apache.org/

### Tomcat
Tomcat est un logiciel qui execute des servlets et du JSP. Il est paramétable avec pom.xml situé à la racine du projet. Nous utilisons son plug-in maven aafin de les faires fonctions ensemble.
Lien vers le site officiel : http://tomcat.apache.org/

### wkhtmltopdf
wkhtmltopdf est un convertisseur de fichier html en fichier pdf. Nous l'utilisons pour générer nos flyer sous forme de pdf à partir des données souhaitées et de fichers hmtl/css définnissant les pâtterns visuels souhaités. 
Lien vers le site officiel : https://wkhtmltopdf.org/

### base de données PQSL
Pour notre base de données, nous utilisons la base de donnée PostgreSQL fourni par l'université. Plus particulièrement, nous utilisons celles de Quentin Rejaumont puisqu'il était le responsable back-end/BDD de notre projet.

### autres dependencies pom/xml ??


## procédure de build ------------------------------------------------------ TODO

Pour build ce projet, il faut tout d'abord démarrer Tomcat. Pour cela, il faut aller dans le dossier où est intallé Tomcat puis dans /bin. Cela donne quelquechose comme ceci :
    ```cd /Path/to/Tomcat/bin/```

*Il est impératif de lancer Tomcat depuis le dossier bin. C'est indispensable pour que le wkhtmltopdf ai le bon path pour générer le pdf.*

Une fois dans ce dossier, il faut executer startup.sh de cette façon : 
    ```./startup.sh```

Maintenant il est temps d'aller dans le dossier de notre projet :
    ```cd /Path/to/ProjectDir/flyergenerator/```

Une fois dans ce dossier, Utiliser la commande suivante pour build en local notre projet :
    ```mvn Tomcat7:redeploy```

Vous pouvez désormais accéder à votre version locale du site à l'addresse suivante :
    ```http://localhost:8080/flyergenerator```







## lien vers la VM --------------------------------------------------------- TODO