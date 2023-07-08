/************************************************* SOMMAIRE ************************************************/


/* 
    1 - VARIABLES GLOBALS
    2 - FONCTIONS
    3 - EXECUTER 
          Ce qui est directement exécuté à l'ouverture du script
*/


/*
------------------------------------------------------------------------------------
                                VARIABLES GLOBALS
------------------------------------------------------------------------------------
*/

const fileInput = document.getElementById('file_input');


/*
------------------------------------------------------------------------------------
                                FONCTIONS
------------------------------------------------------------------------------------
*/


fileInput.addEventListener('change', () => {
    /**
     * [Après que l'utilisateur ai séléctionné les fichiers]
     * 
     * A pour mission d'afficher les fichiers qui ont été séléctionné par l'utilisateur
    */

    // Cible la balise qui contient tout les noms de fichiers
    const uploadedFilesNames = document.querySelector('.uploaded_files_names');

    /* On efface les fichiers qui etaient déjà present (c'est le cas lorsque
    *  on selectionne des fichiers plus d'une fois)
    */
    Array.from(uploadedFilesNames.children).forEach((child) => {
        child.remove();
    });


    // Affichage des noms des fichiers 
    for (let i = 0; i < fileInput.files.length; ++i) {
        const uploadedFileName = document.createElement("div");
        uploadedFileName.innerHTML = fileInput.files.item(i).name;
        uploadedFileName.classList.add("uploaded_file_name");
        uploadedFilesNames.append(uploadedFileName);
    }
})