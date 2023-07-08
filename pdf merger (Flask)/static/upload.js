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


const filesContainer = document.querySelector('#files_container');
const mergeBtn = document.querySelector('#merge_btn');

/*
------------------------------------------------------------------------------------
                                FONCTIONS
------------------------------------------------------------------------------------
*/


function getIndex(target){
  /**
  * Retourne l'indice de l'enfant le plus proche d'un element html
  * @param  {Object} target Element html cible
  * @return {Int}      Indice 
  */

  /* Permet de transformer un objet en Array, cette technique permet d'appliquer 
  * une méthode propre aux Array qui retourne l'index d'un element
  */ 
  return Array.from(target.closest('li').parentElement.children).indexOf(target.closest('li'));
}

function dragStart() {
  /**
  * Est déclanché quand l'utilisateur maintien un element qui est 'draggable'
  */
  dragStartIndex = getIndex(this);
}

function dragEnter() {
  /**
  * Est déclanché quand l'utilisateur passe avec un element 'draggable' (A)
  * sur un autre element draggable (B). La fonction ajoute a B une classe (utile pour styliser)
  */
  this.classList.add('over');
}

function dragLeave() {
  /**
  * Est déclanché quand l'utilisateur quitte avec un element 'draggable' (A)
  * un autre element draggable (B). La fonction retire a B une classe 
  */
  this.classList.remove('over');
}

function dragOver(e) {
  /*
  * Est déclenché lorsqu'un élément draggable est glissé jusqu'à une cible de dépôt valide.
  * La fonction bloque le comportement par defaut
  */
  e.preventDefault();
}

function dragDrop() {
  /*
  * Est déclenché lorsqu'un élément draggable est déposé dans une cible valide.
  * La fonction determine l'index de l'element sur lequel un element vient d'être déposé.
  * La fonction lance une réactualisation des positions des elements puis retire une classe
  */
  dragEndIndex = getIndex(this);
  swapItems(dragStartIndex, dragEndIndex);
  this.classList.remove('over');
}

function swapItems(fromIndex, toIndex) {
  /**
  * Echange dans la liste (accessible globalement) la place de deux elements.
  * Puis, réactualise l'odre des noms de fichiers affichés
  * @param  {Int} fromIndex Index de départ de l'element draggable
  * @param  {Int} toIndex Index d'arrivé de l'element draggable
  */

  // Dans la liste filesNames, inverse les positions de deux elements
  [filesNames[fromIndex], filesNames[toIndex]] = [filesNames[toIndex], filesNames[fromIndex]];

  // Réactualisation de l'odre des noms de fichiers affichés
  const draggablesContainers = Array.from(document.querySelector('#files_container').children);
  draggablesContainers.forEach((item, index) => {
    item.querySelector('.draggable').innerHTML = filesNames[index];
  })
}


function addEventListeners() {
  /**
  * Fonction qui ajoute les evenements nécéssaire au drag aux elements concerné.
  */

  /* Array qui contiendra tout les noms des fichiers. Il a été laissé accèssible 
  * globalement pour pouvoir l'utiliser dans d'autres fonctions.
  */
  filesNames = [];

  // Elements conteneurs de la partie dragable.
  const dragablesContainers = document.querySelectorAll('.draggables li');

  dragablesContainers.forEach(draggable => {
    draggable.addEventListener('dragstart', dragStart);
  });

  // Elements dragable.
  const draggablesElements = document.querySelectorAll('.draggable'); 

  draggablesElements.forEach(item => {
    filesNames.push(item.innerHTML);

    item.addEventListener('dragover', dragOver);
    item.addEventListener('drop', dragDrop);
    item.addEventListener('dragenter', dragEnter);
    item.addEventListener('dragleave', dragLeave);
  });
}


document.getElementById("merge_btn").addEventListener('click', async () => {
  /**
  * Fonction qui gére la fusion des fichiers (assure l'envoi de l'ordre des fichiers choisi,
  * l'animation du bouton de téléchargement et du telechargement automatique du fichier fini).
  */
  
  // Contient la hauteur du bouton. Cette constante va permettre 
  // de ne pas changer la hauteur du bouton lorsque le texte que le bouton contient
  // sera effacé. 
  const mergeBtnHeight = mergeBtn.clientHeight;

  // Contient le texte initial du bouton. Cette constante va permettre 
  // de garder en mémoire le text initial du bouton pour pouvoir le
  // remettre par la suite (le texte est enlévé pour y mettre un spinner de chargement)
  const mergeBtnInnerHtml = mergeBtn.innerHTML;

  
  // Chargement
  mergeBtn.innerHTML = '';
  mergeBtn.style.height = `${mergeBtnHeight}px`;
  mergeBtn.classList.add("button--loading");


  // Requete pour envoyer les noms des fichiers dans l'ordre de fusion choisis
  // par l'utilisateur
  res = await fetch('/download', {
    method : 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body : JSON.stringify({"data": filesNames})
  })
  

  blobFile = await res.blob()
  .then(
    (blobFile) => {
      // permet de déclancher le telechargement pour le client
      const url = window.URL.createObjectURL(blobFile);
      const a = document.createElement('a');
      a.style.display = 'none';
      a.href = url;
      a.download = 'merged_file.pdf';
      document.body.appendChild(a);
      a.click();
      window.URL.revokeObjectURL(url);
      document.body.removeChild(a);
    }
  ).then(
    // Lorsque le téléchargement a été lancé, on arrete l'animation de chargement
    () => {
      mergeBtn.innerHTML = mergeBtnInnerHtml;
      mergeBtn.classList.remove("button--loading");
      mergeBtn.style.height = 'auto';
    }
  )
})


/*
------------------------------------------------------------------------------------
                                EXECUTER
------------------------------------------------------------------------------------
*/

addEventListeners()